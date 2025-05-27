package org.example;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        //Вычислить факториал числа;
        System.out.println("Факториал числа = " + MathMethods.factorialNumber(10));
        System.out.println("----------------------------------------------");

        //Найти площадь треугольника;
        System.out.println("Площадь S треугольника = " + MathMethods.areaTriangle(3.2, 2));
        System.out.println("----------------------------------------------");

        //Арифметические действия с двумя целыми числами (сложение, вычитание, деление и умножение);
        System.out.println("Арифметические операции над числами");
        MathMethods.arithmeticOperations(15,3);

        //Сравнить два целых числа
        System.out.println("Сравнить два целых числа");
        MathMethods.compareNumbers(5, 3);
    }
}