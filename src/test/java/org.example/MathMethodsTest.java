package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MathMethodsTest {
    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
                {5, 120},
                {1, 1},
                {0, 1}
        };
    }
    @Test(dataProvider = "factorialData")
    public void testFactorial(int input, int expected) {
        assertEquals(MathMethods.factorialNumber(input), expected);
    }

    //AreaTriangle
    @DataProvider(name = "areaTriangleData")
    public Object[][] areaTriangleData() {
        return new Object[][]{
                {3.2, 2.0, 3.2},
                {0.0, 10.0, 0.0},
                {10.0, 0.0, 0.0}
        };
    }

    @Test(dataProvider = "areaTriangleData")
    public void testAreaTriangle(double a, double h, double expected) {
        double actual = (a * h) / 2;
        assertEquals(MathMethods.areaTriangle(a, h), expected, 0.0001);//(основание, высота, ОР, погрешность для double)
    }

    //ArithmeticOperations
    @DataProvider(name = "arithmeticOperationsData")
    public Object[][] arithmeticOperationsData() {
        return new Object[][]{
                {8, 9, "Сумма чисел = 17\nРазность чисел = -1\nДеление чисел = 0\nУмножение чисел = 72"},
                {10, 2, "Сумма чисел = 12\nРазность чисел = 8\nДеление чисел = 5\nУмножение чисел = 20"},
                {3, 1, "Сумма чисел = 4\nРазность чисел = 2\nДеление чисел = 3\nУмножение чисел = 3"}
        };
    }

    @Test(expectedExceptions = ArithmeticException.class) //деление на 0
    public void testArithmeticOperations_DivideByZero() {
        String result = MathMethods.arithmeticOperations(8, 0);
    }

    //CompareNumbers
    @DataProvider(name="compareNumbersData")
    public Object[][] compareNumbersData() {
        return new Object[][] {
                {6, 3, "a > b = true\na < b = false\na = b - false"},
                {2, 4, "a > b = false\na < b = true\na = b - false"},
                {8, 8, "a > b = false\na < b = false\na = b - true"}
        };
    }

    @Test(dataProvider = "compareNumbersData")
    public void testCompareNumbers(int a, int b, String expected) {
        assertEquals(MathMethods.compareNumbers(a, b), expected);
    }
}