package co.spoonradio.sims.configuration.security

import co.spoonradio.sims.dto.response.adminuser.AdminUserInfo
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.sql.Date
import javax.servlet.http.HttpServletRequest


/**
 * @author whale@spoonradio.co
 * @date   2021/11/15.
 * @Desc
 * https://lemontia.tistory.com/1021 (Token 해석)
 * https://charlie-choi.tistory.com/211
 */
@Component
class JwtTokenProvider {

    companion object {
        val SECRETKEY: String = "SIMS-V3-IMPROVEMENT"
        val JWT_EXPIRATON_TIME = 8 * 1000 * 60 * 60 //8시간
    }

    private fun generateKey(): ByteArray = SECRETKEY.toByteArray(StandardCharsets.UTF_8)

    fun makeJwt(adminUserInfoInfo:AdminUserInfo): String {
        val headerMap = mapOf(
            "type" to "JWT",
            "algorithm" to "HS256"
        )
        val claimMap = mapOf(
            "id" to adminUserInfoInfo.userId,
            "email" to adminUserInfoInfo.email,
            "name" to adminUserInfoInfo.userName
        )

        val expired = Date(System.currentTimeMillis() + JWT_EXPIRATON_TIME) // 2시간

        return Jwts.builder()
            .setSubject(adminUserInfoInfo.userName+"_SIMS") //국가 , 이름
            .setHeader(headerMap)
            .setClaims(claimMap)
            .setExpiration(expired)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .signWith(SignatureAlgorithm.HS256, generateKey())
            .compact()
    }

    fun resolveToken(request: HttpServletRequest): String? = request.getHeader("X-TOKEN")
    fun isTokenExpired(token: String): Boolean {
        return try {
            Jwts
                .parser()
                .setSigningKey(generateKey())
                .parseClaimsJws(token)
                .body
                .expiration
                .before(Date(System.currentTimeMillis()))
        } catch (e: Exception) {
            return true
        }
    }

}
