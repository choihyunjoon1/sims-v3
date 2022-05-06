package co.spoonradio.sims.type

/**
 * @author whale@spoonradio.co
 * @date   2021/08/06.
 * @Desc
 */

enum class CountryZone(val zoneId: String, val region: String) {
    KR("Asia/Seoul","ap-northeast-2"),
    JP("Asia/Tokyo","ap-northeast-1"),
    US("America/Los_Angeles","us-east-1"),
    AR("Asia/Riyadh","eu-central-1")
}