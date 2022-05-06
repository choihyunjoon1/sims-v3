package co.spoonradio.sims.common.`object`

import org.springframework.util.AntPathMatcher

/**
 * @author whale@spoonradio.co
 * @date   2021/12/02.
 * @Desc
 */
object ExcludeUrl {
    val EXCLUDE_URL: List<String> = listOf(
        "/",
        "/saml/SSO",
        "/login",
    )

    val EXCLUDE_PATTERN: List<String> = listOf(
        "/commons/download/**",
        "/actuator/health/**",
    )
    fun isMatch(path: String): Boolean {
        //return true

        return  EXCLUDE_PATTERN.stream().anyMatch { pattern -> AntPathMatcher().match(pattern, path) } ||
                EXCLUDE_URL.stream().anyMatch { exclude -> exclude.equals(path) }
    }
}