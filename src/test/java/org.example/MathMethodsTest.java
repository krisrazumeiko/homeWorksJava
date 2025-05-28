package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MathMethodsTest {
    @Test
    public void testFactorial_5() { //для обычных значений
        assertEquals(MathMethods.factorialNumber(5), 120);
    }

    @Test
    public void testFactorial_0() { //если 0!
        assertEquals(MathMethods.factorialNumber(0), 1);
    }

    @Test
    public void testFactorial_1() {//если 1!
        assertEquals(MathMethods.factorialNumber(1), 1);
    }

    //AreaTriangle
    @Test
    public void testAreaTriangle() {//для обычных значений
        assertEquals(MathMethods.areaTriangle(3.2, 2), 3.2, 0.0001);//(основание, высота, ОР, погрешность для double)
    }

    @Test
    public void testAreaTriangle_a0() {//если а = 0
        assertEquals(MathMethods.areaTriangle(0, 10), 0.0, 0.0001);
    }

    @Test
    public void testAreaTriangle_h0() {//если h = 0
        assertEquals(MathMethods.areaTriangle(10, 0), 0.0, 0.0001);
    }

    //ArithmeticOperations
    @Test
    public void testArithmeticOperations() {
        String expected = "Сумма чисел = 12" + "\n" +
                "Разность чисел = 4" + "\n" +
                "Деление чисел = 2" + "\n" +
                "Умножение чисел = 32";
        assertEquals(MathMethods.arithmeticOperations(8, 4), expected);
    }

    @Test(expectedExceptions = ArithmeticException.class) //деление на 0
    public void testArithmeticOperations_DivideByZero() {
        String result = MathMethods.arithmeticOperations(8, 0);
    }

    //CompareNumbers
    @Test
    public void testCompareNumbers() {
        String expected = "a > b = true" + "\n" +
                "a < b = false" + "\n" +
                "a = b - false" + "\n";
        assertEquals(MathMethods.compareNumbers(5, 3), expected);
    }

    @Test
    public void testCompareNumbers_a_Less() {
        String expected = "a > b = false\n" +
                "a < b = true\n" +
                "a = b - false\n";
        assertEquals(expected, MathMethods.compareNumbers(3, 7));
    }

    @Test
    public void testCompareNumbers_a_Equals_b() {
        String expected = "a > b = false\n" +
                "a < b = false\n" +
                "a = b - true\n";
        assertEquals(expected, MathMethods.compareNumbers(4, 4));
    }
}