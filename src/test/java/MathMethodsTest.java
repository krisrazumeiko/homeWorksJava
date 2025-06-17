import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MathMethodsTest {
    //Factorial
    @ParameterizedTest
    @CsvSource({
            "5, 120",
            "0, 1",
            "1, 1"
    })
    void testFactorial(int input, int expected) {
        assertEquals(expected, MathMethods.factorialNumber(input));
    }

    //AreaTriangle
    @ParameterizedTest
    @CsvSource({
            "3, 4, 6.0",
            "0, 4, 0.0",
            "3, 0, 0.0"
    })
    void testAreaTriangle(double a, double h, double expected) {
        assertEquals(expected, MathMethods.areaTriangle(a, h));
    }

    //ArithmeticOperations
    @ParameterizedTest
    @CsvSource({
            "2, 3, 'Сумма чисел = 5\nРазность чисел = -1\nДеление чисел = 0\nУмножение чисел = 6'",
            "10, 5, 'Сумма чисел = 15\nРазность чисел = 5\nДеление чисел = 2\nУмножение чисел = 50'"
    })
    void testArithmeticOperations(int a, int b, String expected) {
        assertEquals(expected, MathMethods.arithmeticOperations(a, b));
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
    @ParameterizedTest
    @CsvSource({
            "5, 3, 'a > b = true\na < b = false\na = b - false\n'",
            "1, 3, 'a > b = false\na < b = true\na = b - false\n'",
            "5, 5, 'a > b = false\na < b = false\na = b - true\n'"
    })
    void testCompareNumbers(int a, int b, String expected) {
        assertEquals(expected, MathMethods.compareNumbers(a, b));
    }
}