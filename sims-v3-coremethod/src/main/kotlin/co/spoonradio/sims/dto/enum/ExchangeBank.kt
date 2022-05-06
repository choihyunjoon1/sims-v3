package co.spoonradio.sims.dto.enum

enum class ExchangeBank(val bankCode: String) {
    KDB("002"),
    IBK("003"),
    KB("004"),
    SUHYUP("007"),
    NH("011"),
    LOCALNH("012"),
    WOORI("020"),
    SC("023"),
    CITI("027"),
    DGB("031"),
    BUSAN("032"),
    KJ("034"),
    JEJU("035"),
    JB("037"),
    KN("039"),
    KFCC("045"),
    SHINHYUP("048"),
    SB("050"),
    HSBC("054"),
    DEUTSCHE("055"),
    JP("057"),
    BOA("060"),
    BNP("061"),
    ICBC("062"),
    NFCF("064"),
    CCB("067"),
    EPOST("071"),
    HANA("081"),
    SHINHAN("088"),
    KBANK("089"),
    KAKAOBANK("090"),
    MYASSET("209"),
    KBSEC("218"),
    KTB("227"),
    MIRAE("238"),
    SAMSUNGPOP("240"),
    TRUEFRIEND("243"),
    NHQV("247"),
    IPROVEST("261"),
    HIIB("262"),
    HMSEC("263"),
    KIWOOM("264"),
    EBESTSEC("265"),
    SKS("266"),
    DAISHIN("267"),
    HANWHAWM("269"),
    HANAW("270"),
    SHINHANINVEST("278"),
    DBFI("279"),
    EUGENEFN("280"),
    IMERITZ("287"),
    KAKAOPAYSEC("288"),
    BOOKOOK("290"),
    SHINYOUNG("291"),
    CAPEFN("292"),
    FUNDONLINE("294");

    companion object {
        private val map = values().associateBy(ExchangeBank::bankCode)
        fun fromBankCode(bankCode: String) = map[bankCode]
    }
}
