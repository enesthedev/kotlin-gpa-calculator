import com.enesthedev.gpa.calculator.classes.Helpers
import com.enesthedev.gpa.calculator.classes.Language
import com.enesthedev.gpa.calculator.constants.FINAL_RATIO
import com.enesthedev.gpa.calculator.constants.VISA_RATIO
import java.util.*

fun main(args: Array<String>) {
    /**
     * Şuanki sistem dilini kullanaraktan aplikasyonda dil desteği verdiğim dillerin arasında olup olmadığını sorguladım ve
     * map tipinde dil bilgilerini currentLanguage değişkenine döndürdüm. Yararlandığım kaynağın adresini altta bulabilirsiniz.
     * https://discuss.kotlinlang.org/t/python-like-dictionaries-in-kotlin/2008
     */
    val systemLanguage = Locale.getDefault().language
    val currentLanguage = Language.getKeyMapOfLanguage(systemLanguage)

    println(currentLanguage["welcome"])

    println(currentLanguage["lesson"])
    val lessonName: String? = readLine()

    if (lessonName == null || lessonName.isEmpty()) {
        println(currentLanguage["invalid"]?.format(currentLanguage["lesson.name"]))
        return
    }

    println(currentLanguage["grade"]?.format(
        lessonName,
        currentLanguage["visa"]
    ))
    val midtermValue: String? = readLine()

    if (midtermValue?.let { Helpers.isNumber(it) } == false || midtermValue?.toInt()!! > 100) {
        println(currentLanguage["invalid"]?.format(currentLanguage["note"]))
        return
    }

    println(currentLanguage["ratio"]?.format(
        lessonName,
        currentLanguage["visa"],
        VISA_RATIO
    ))
    var midtermRatio: String? = readLine()

    if ((midtermRatio !== null && midtermRatio.isEmpty()) || midtermRatio?.let { Helpers.isNumber(it) } == false) {
        midtermRatio = VISA_RATIO.toString()
    }

    println(currentLanguage["grade"]?.format(
        lessonName,
        currentLanguage["final"]
    ))
    val finalValue: String? = readLine()

    if (finalValue?.let { Helpers.isNumber(it) } == false || finalValue?.toInt()!! > 100) {
        println(currentLanguage["invalid"]?.format("not"))
        return
    }

    println(currentLanguage["ratio"]?.format(
        lessonName,
        currentLanguage["final"],
        FINAL_RATIO
    ))
    var finalRatio: String? = readLine()

    if ((finalRatio !== null && finalRatio.isEmpty()) || finalRatio?.let { Helpers.isNumber(it) } == false) {
        finalRatio = FINAL_RATIO.toString()
    }

    val resultValue: Double = Helpers.getRealGrade(midtermValue.toInt(), midtermRatio?.toDouble()) + Helpers.getRealGrade(finalValue.toInt(), finalRatio?.toDouble())
    println(currentLanguage["result"]?.format(
        lessonName,
        midtermValue,
        finalValue,
        resultValue.toString(),
        if (resultValue <= 50) currentLanguage["!pass"] else currentLanguage["pass"]
    ))
}