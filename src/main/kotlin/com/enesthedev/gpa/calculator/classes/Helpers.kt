package com.enesthedev.gpa.calculator.classes

class Helpers {
    /**
     * Yardımcı sınıf
     * Bu sınıf programın ihtiyaçlarına göre tekrar kullanılabilir fonksiyonlar içerir.
     */
    companion object {
        @JvmStatic
        // Bir string tipindeki verinin tamamının sayı olup olmadığını kontrol eder.
        fun isNumber(string: String): Boolean {
            if (string == null || string.isEmpty()) {
                return false;
            }
            if (!string.all { Character.isDigit(it) }) {
                return false;
            }
            return true;
        }
    }
}