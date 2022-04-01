package com.enesthedev.gpa.calculator.classes

import com.enesthedev.gpa.calculator.constants.FALLBACK_LANGUAGE

class Language {
    companion object {
        @JvmStatic
        val languages: Array<String> = arrayOf("ar", "en")
        val keys: Array<Map<String, String>> = arrayOf(
            mapOf(
                "welcome" to "Ders Not Ortalaması hesaplayıcıya hoşgeldiniz",
                "lesson" to "Lütfen aldığınız dersin ismini/kodunu giriniz:",
                "lesson.name" to "ders ismi",
                "grade" to "Lütfen %s dersinden aldığınız %s notunu giriniz:",
                "invalid" to "Girdiğiniz %s geçersiz.",
                "note" to "not",
                "visa" to "vize",
                "final" to "final",
                "ratio" to "Lütfen %s dersinin %s sınavının yüzdelik etkisini giriniz (Boş bırakabilirsiniz Varsayılan değer %d):",
                "result" to "%s Dersinden aldığınız notlar:\nVize: %s\nFinal: %s\nOrtalama: %s\nGeçme durumu: %s",
                "pass" to "Geçer",
                "!pass" to "Geçmez",
            ),
            mapOf(
                "welcome" to "Welcome the GPA Calculator",
                "lesson" to "Please type course name/number:",
                "lesson.name" to "crn number",
                "grade" to "Please type youre %s lesson %s grade:",
                "note" to "point",
                "visa" to "midterm",
                "final" to "final",
                "ratio" to "Please type the percentage effect %s course of the %s: (Default value is %d)",
                "result" to "Information about %s course:\nMidterm: %s\nFinal: %s\nAverage: %s\nState: %s",
                "pass" to "Pass",
                "!pass" to "Failed"
            ),
        )

        fun hasLanguage(language: String): Boolean {
            return this.languages.contains(language)
        }

        fun getKeyMapOfLanguage(languageKey: String): Map<String, String> {
            return if (this.hasLanguage(languageKey))
                this.keys[this.languages.indexOf(languageKey)]
            else
            /**
             * FALLBACK_LANGUAGE
             * Sistem dilinin program dillerince desteklenmediği zamanda kullanılacak ana dil seçeneği
             * bu seçeneği oluştururken konfigre edilebilebilir static bir değer olması gerektiği için constants kullandım
             *
             * Kotlinde constans için alttaki adresden yararlandım.
             * https://stackoverflow.com/questions/44038721/constants-in-kotlin-whats-a-recommended-way-to-create-them
             */
                this.keys[this.languages.indexOf(FALLBACK_LANGUAGE)]
        }
    }
}