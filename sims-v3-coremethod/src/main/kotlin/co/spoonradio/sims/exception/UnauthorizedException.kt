package co.spoonradio.sims.exception

/**
 * @author whale@spoonradio.co
 * @date   2021/11/15.
 * @Desc
 */
class UnauthorizedException(val code: String) : RuntimeException()