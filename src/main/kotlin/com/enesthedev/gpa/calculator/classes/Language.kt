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
                "invalid" to "Girdiğiniz %s geçersiz."
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
                this.keys.get(
                    this.languages.indexOf(languageKey)
                )
            else
                this.keys.get(
                    this.languages.indexOf(FALLBACK_LANGUAGE)
                );
        }
    }
}