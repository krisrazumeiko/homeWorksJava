public class MathMethods {
    //Вычислить факториал числа;
    public static int factorialNumber(int factorial) {
        int result = 1;
        for(int i = 1; i <= factorial; i++) {
            result = result * i;
        }
        return result;
    }

    //Найти площадь треугольника;
    public static double areaTriangle(double a, double h) {
        return (a * h) / 2;
    }

    //Арифметические действия с двумя целыми числами (сложение, вычитание, деление и умножение);
    public static String arithmeticOperations(int a, int b) {
        int summa = a + b;
        int subtraction = a - b;
        int division  = a / b;
        int multiplication = a * b;

        return"Сумма чисел = " + summa + "\n" +
                "Разность чисел = " + subtraction + "\n" +
                "Деление чисел = " + division + "\n" +
                "Умножение чисел = " + multiplication;
    }

    //Сравнить два целых числа
    public static String compareNumbers(int a, int b) {
        boolean more = a > b;
        boolean less = a < b;
        boolean equal  = a == b;

        return "a > b = " + more + "\n" +
                "a < b = " + less + "\n" +
                "a = b - " + equal + "\n";
    }
}