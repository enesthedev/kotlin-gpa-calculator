import com.enesthedev.gano.calculator.constants.FALLBACK_LANGUAGE
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
    val currentLanguage =
        if (languages.contains(systemLanguage))
            keys[languages.indexOf(systemLanguage)]
        else
            // FALLBACK_LANGUAGE değeri constants/Language.kt'den gelmekte.
            // Bu tarz sabit değeler için yeni bir paket oluşturdum. Yararlandığım kaynağın adresini altta bulabilirsiniz.
            // https://stackoverflow.com/questions/44038721/constants-in-kotlin-whats-a-recommended-way-to-create-them
            keys[languages.indexOf(FALLBACK_LANGUAGE)];

    println(currentLanguage.get("welcome"))
}
