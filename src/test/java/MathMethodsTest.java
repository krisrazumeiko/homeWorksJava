import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.function.Executable;

public class MathMethodsTest {
    //Factorial
    @Test
    void testFactorial_5() {
        assertEquals(120, MathMethods.factorialNumber(5));
    }

    @Test
    void testFactorial_0() {
        assertEquals(1, MathMethods.factorialNumber(0));
    }

    @Test
    void testFactorial_1() {
        assertEquals(1, MathMethods.factorialNumber(1));
    }

    //AreaTriangle
    @Test
    void testAreaTriangle() {
        assertEquals(6.0, MathMethods.areaTriangle(3, 4));
    }

    @Test
    void testAreaTriangle_a0() {
        assertEquals(0.0, MathMethods.areaTriangle(0, 4));
    }

    @Test
    void testAreaTriangle_h0() {
        assertEquals(0.0, MathMethods.areaTriangle(3, 0));
    }

    //ArithmeticOperations
    @Test
    void testArithmeticOperations() {
        String expected = "Сумма чисел = 5\n" +
                "Разность чисел = -1\n" +
                "Деление чисел = 0\n" +
                "Умножение чисел = 6";
        assertEquals(expected, MathMethods.arithmeticOperations(2, 3));
    }

    @Test
    void testArithmeticOperations_DivByZero() {
        Executable executable = new Executable() {
            @Override
            public void execute() {
                MathMethods.arithmeticOperations(8, 0);
            }
        };
        assertThrows(ArithmeticException.class, executable);
    }

    //CompareNumbers
    @Test
    void testCompareNumbers_() {
        String expected = "a > b = true" + "\n" +
                "a < b = false" + "\n" +
                "a = b - false" + "\n";
        assertEquals(expected, MathMethods.compareNumbers(5, 3));
    }

    @Test
    void testCompareNumbers_a_Less() {
        String expected = "a > b = false" + "\n" +
                "a < b = true" + "\n" +
                "a = b - false" + "\n";
        assertEquals(expected, MathMethods.compareNumbers(1, 3));
    }

    @Test
    void testCompareNumbers_a_Equals_b() {
        String expected = "a > b = false" + "\n" +
                "a < b = false" + "\n" +
                "a = b - true" + "\n";
        assertEquals(expected, MathMethods.compareNumbers(5, 5));
    }
}