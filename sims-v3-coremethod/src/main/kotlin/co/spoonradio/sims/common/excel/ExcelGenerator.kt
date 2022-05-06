package co.spoonradio.sims.common.excel

import co.spoonradio.arch.extension.toJsonByteArray
import co.spoonradio.sims.common.excel.annotation.ExcelColumn
import co.spoonradio.sims.common.extension.getEncryptedByteArray
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.ByteArrayOutputStream
import java.io.File
import java.util.*

class ExcelGenerator {
    companion object {

        val EXCEL_MAX_ROW_SIZE = 10000

        inline fun <reified T> createHeaderRow(sheet: Sheet) {
            if (sheet.lastRowNum >= 0) {
                sheet.shiftRows(0, sheet.lastRowNum, 1)
            }

            val headerRow = sheet.createRow(0)

            T::class.java.declaredFields
                .filter { field -> field.getAnnotation(ExcelColumn::class.java) != null }
                .forEachIndexed { index, field ->
                    val headerLabel = field.getAnnotation(ExcelColumn::class.java).korLabel
                    headerRow.createCell(index).setCellValue(headerLabel)
                }
        }

        fun <T> createRow(sheet: Sheet, data: T) {
            val row: Row = sheet.createRow(sheet.lastRowNum + 1)
            data!!::class.java.declaredFields
                .filter { field -> field.getAnnotation(ExcelColumn::class.java) != null }
                .forEachIndexed { index, field ->
                    field.isAccessible = true
                    when {
                        field.get(data) is Number -> row.createCell(index).setCellValue((field.get(data) as Number).toDouble())
                        Objects.isNull(field.get(data)) -> row.createCell(index).setCellValue("")
                        else -> row.createCell(index).setCellValue(field.get(data).toString())
                    }
                }
        }

        inline fun <reified T> createRows(sheet: Sheet, data: Collection<T>) {
            require(data.iterator().hasNext())
            require(data.size < EXCEL_MAX_ROW_SIZE)
            require(sheet.lastRowNum == -1)

            createHeaderRow<T>(sheet)

            data.forEach { row ->
                createRow(sheet, row)
            }
        }

        inline fun <reified T> generateToFile(originaldata: Collection<T>, filename: String):File {
            return XSSFWorkbook().run {
                var file = File(filename)
                val sheet = this.createSheet()
                createRows<T>(sheet, originaldata)
                this.write(file.outputStream())
                file
            }
        }

        inline fun <reified T> generateToByteArray(originaldata: List<T>, password:String): ByteArray {
            return XSSFWorkbook().run {
                val sheet = this.createSheet()
                createRows<T>(sheet, originaldata)
                this.getEncryptedByteArray(password).toByteArray()
            }
        }
    }
}