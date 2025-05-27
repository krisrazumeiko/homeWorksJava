import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathMethodsTest {
    @Test
    void testFactorialNumber() {
        assertEquals(120, MathMethods.factorialNumber(5));
        assertEquals(1, MathMethods.factorialNumber(0));
    }

    @Test
    void testAreaTriangle() {
        assertEquals(6.0, MathMethods.areaTriangle(3, 4));
    }

    @Test
    void testArithmeticOperations() {
        String expected = "Сумма чисел = 5\n" +
                "Разность чисел = -1\n" +
                "Деление чисел = 0\n" +
                "Умножение чисел = 6";
        assertEquals(expected, MathMethods.arithmeticOperations(2, 3));
    }

    @Test
    void testCompareNumbers() {
        String expected = "a > b = true\n" +
                "a < b = false\n" +
                "a = b - false\n";
        assertEquals(expected, MathMethods.compareNumbers(5, 3));
    }
}