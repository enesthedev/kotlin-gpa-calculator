import java.util.*

val languages = arrayOf("tr", "en")
val keys = arrayOf(
    mapOf(
        "welcome" to "Ders Not Ortalaması hesaplayıcıya hoşgeldiniz"
    ),
    mapOf(
        "welcome" to "en"
    ),
)

fun main(args: Array<String>) {
    /**
     * Şuanki sistem dilini kullanaraktan aplikasyonda dil desteği verdiğim dillerin arasında olup olmadığını sorguladım ve
     * map tipinde dil bilgilerini currentLanguage değişkenine döndürdüm. Yararlandığım kaynağın adresini altta bulabilirsiniz.
     * https://discuss.kotlinlang.org/t/python-like-dictionaries-in-kotlin/2008
     */
    val systemLanguage = Locale.getDefault().language
    val currentLanguage = if (languages.contains(systemLanguage)) keys[languages.indexOf(systemLanguage)] else keys[languages.indexOf("en")];

    println(currentLanguage.get("welcome"))
}
