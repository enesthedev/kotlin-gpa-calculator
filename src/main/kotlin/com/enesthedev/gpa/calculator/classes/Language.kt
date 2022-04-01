package com.enesthedev.gpa.calculator.classes

import com.enesthedev.gpa.calculator.constants.FALLBACK_LANGUAGE

class Language {
    companion object {
        @JvmStatic
        val languages: Array<String> = arrayOf("tr", "en")
        val keys: Array<Map<String, String>> = arrayOf(
            mapOf(
                "welcome" to "Ders Not Ortalaması hesaplayıcıya hoşgeldiniz",
                "lesson" to "Lütfen aldığınız dersin ismini/kodunu giriniz:",
                "midterm" to "Lütfen %s dersinden aldığınız vize notunu giriniz:",
                "invalid" to "Girdiğiniz %s geçersiz.",
                "visa" to "vize",
                "final" to "final",
                "ratio" to "Lütfen %s dersinin %s sınavının yüzdelik etkisini giriniz (Boş bırakabilirsiniz Varsayılan değer %d):"
            ),
            mapOf(
                "welcome" to "en"
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
                this.keys[this.languages.indexOf(FALLBACK_LANGUAGE)];
        }
    }
}