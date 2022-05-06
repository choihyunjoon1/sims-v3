package co.spoonradio.sims.dto.request.voc.ban

import co.spoonradio.sims.common.excel.annotation.ExcelParse
import org.springframework.web.multipart.MultipartFile
import java.time.ZonedDateTime
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * @author whale@spoonradio.co
 * @date   2021/12/01.
 * @Desc
 */
data class RequestRegistBanTest(
    var xlsx_file: MultipartFile? = null
)
