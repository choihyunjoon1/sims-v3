package co.spoonradio.sims.exception

/**
 * @author whale@spoonradio.co
 * @date   2021/11/04.
 * @Desc
 */
class GeneralException(val code: String, var args:Array<String>? = null) : RuntimeException()