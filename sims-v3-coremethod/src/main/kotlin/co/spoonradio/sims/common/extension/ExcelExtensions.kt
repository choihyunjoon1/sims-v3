package co.spoonradio.sims.common.extension

import org.apache.poi.openxml4j.opc.OPCPackage
import org.apache.poi.poifs.crypt.EncryptionInfo
import org.apache.poi.poifs.crypt.EncryptionMode
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import org.apache.poi.ss.usermodel.Workbook
import org.springframework.web.multipart.MultipartFile
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

/**
 * @author whale@spoonradio.co
 * @date   2021/12/15.
 * @Desc
 */
fun Workbook.getEncryptedByteArray(password: String) = use {
    POIFSFileSystem()
        .use { poiFs ->
            val enc = EncryptionInfo(EncryptionMode.agile)
                .encryptor
                .apply{
                    confirmPassword(password)
                }

            val out = ByteArrayOutputStream()
            this.write(out)

            OPCPackage.open(ByteArrayInputStream(out.toByteArray()))
                .use { opc ->
                    enc.getDataStream(poiFs)
                        .use { os ->
                            opc.save(os)
                        }
                }

            ByteArrayOutputStream()
                .use {
                    poiFs.writeFilesystem(it)
                    it
                }
        }
}


fun MultipartFile.toFile() =
    File(this.originalFilename).apply {
        createNewFile()
    }.also {
        FileOutputStream(it).use { fos ->
            fos.write(this.bytes)
        }
    }

/*
fun MultipartFile.toFile(): File {
    val convFile: File = File(this.getOriginalFilename())
    convFile.createNewFile()
    val fos = FileOutputStream(convFile)
    fos.write(this.getBytes())
    fos.close()
    return convFile
}*/
