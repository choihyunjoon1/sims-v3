package co.spoonradio.sims.common.excel

import co.spoonradio.sims.common.excel.annotation.ExcelParse
import org.apache.poi.ss.formula.functions.T
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream
import java.lang.Boolean.parseBoolean
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt
import java.time.LocalDateTime

class ExcelParser {
    companion object {

        inline fun <reified T> readFromExcel(row: Row): T {

            // T 의 constructor을 가져오기 위해 필요한 constructor argument type list
            val fieldList = T::class.java.declaredFields
                .filter { it.isAnnotationPresent(ExcelParse::class.java) }
            // 실제 constructor을 호출하기 위한 argument 리스트 init
            val paramList = mutableListOf<Any>()

            // row 에서 읽어오기
            fieldList.forEach { field ->
                val cellNum = field.getAnnotation(ExcelParse::class.java).order
                val cell = row.getCell(cellNum)
                val stringValue = when (cell.cellType) {
                    CellType.NUMERIC -> cell.numericCellValue.toString()
                    CellType.BOOLEAN -> cell.booleanCellValue.toString()
                    CellType.STRING -> cell.stringCellValue
                    else -> cell.stringCellValue
                }

                paramList.add(
                    cellNum, when (field.type) {
                        Long::class.java -> Math.floor(parseDouble(stringValue)).toLong()
                        Int::class.java -> Math.floor(parseDouble(stringValue)).toInt()
                        Double::class.java -> parseDouble(stringValue)
                        Boolean::class.java -> parseBoolean(stringValue)
                        LocalDateTime::class.java -> cell.localDateTimeCellValue
                        else -> stringValue
                    }
                )
            }

            // T의 constructor 호출
            return T::class.java
                .getConstructor(*fieldList.map { it.type }.toTypedArray())
                .newInstance(*paramList.toTypedArray())
        }

        inline fun <reified T> parseExcel(file: File): Collection<T> {

            val workbook = XSSFWorkbook(FileInputStream(file))
            val sheet = workbook.getSheetAt(0)
            val parsedList = mutableListOf<T>()

            sheet.forEachIndexed { i, row ->
                if (i == 0) return@forEachIndexed
                if (row.lastCellNum <= 0) return@forEachIndexed
                parsedList.add(readFromExcel(row))
            }

            return parsedList
        }
    }
}


