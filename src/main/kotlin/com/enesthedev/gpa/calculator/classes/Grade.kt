package com.enesthedev.gpa.calculator.classes

class Grade {
    var value: Int = 0
    var ratio: Double = 0.0

    /**
     * Not sınıfı
     * Bu sınıf value ve ratio isminde biri sayı diğeri ondalık sayı tipinde iki adet eleman içerir.
     * Bunun sebebi GPA hesaplamızda vize notu ve final notunun oranlarının ve değerlerinin farklı olmasıdır.
     *
     * result metodu ise bize son ortalamada kullanabileceğimiz value ile ratio'nun çarpımını verir.
     *
     * Örnek: GPA'ya %20 etkisi olan bir vizeden 60 aldığımızı varsayıyorum bu metod sayesinde 60 * 0.2 = 12 çıktısını alacağız.
     */

    constructor(value: Int, ratio: Double) {
        this.value = value;
        this.ratio = ratio;
    }

    fun result(): Double {
        return this.value * this.ratio;
    }
}