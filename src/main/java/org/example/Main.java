package org.example;

public class Main {
    public static void main(String[] args) {
//        1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//        2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе массива преобразование не удалось
//        (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
//        3 В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.

        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "10", "12"},
                {"13", "fourteen", "15", "16"}// Ошибка в элементе [3][1]
        };

        try {
            System.out.println("Сумма всех элементов: " + checkArray(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("==============================================================");


        // 4 Напишите код для генерации и поимки ArrayIndexOutOfBoundsException.
        int[] numbers = {1, 2, 3};

        try {
            int value = numbers[5];// Пытаемся обратиться к элементу с индексом 5, но его не существует, потому что массив состоит из трех элементов
            System.out.println("Значение элемента = " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e);
            System.out.println("Ошибка: индекс выходит за границы массива.");
        }
        System.out.println("Программа завершена.");
    }

    //Задание 1-3
    public static int checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        //Проверка, что массив содержит 4 строки
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен содержать 4 строки, но найдено: " + array.length);
        }
        // Проверка, что в каждой строке 4 столбца
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Строка " + i + " содержит " + array[i].length + " элементов вместо 4");
            }
        }


        int sum = 0;// Переменная для хранения суммы

        // Проход по массиву и преобразование в строковых элементов в числа
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int num = Integer.parseInt(array[i][j]); // Преобразуем строку в число
                    sum += num; // Добавляем к сумме
                } catch (NumberFormatException e) {
                    // Если строка не может быть преобразована в число, то бросаем своё исключение
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]:" + " " + array[i][j]);
                }
            }
        }
        return sum;// Возвращаем итоговую сумму
    }
}