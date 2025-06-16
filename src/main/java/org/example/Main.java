package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //1. Создать класс "Товар" с полями: название, дата производства, производитель, страна происхождения, цена, состояние бронирования покупателем.
        //Конструктор класса должен заполнять эти поля при создании объекта.
        //Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.
        Product prod1 = new Product("Phone", "11.11.2011","Apple", "USA", 10000, false);
        Product prod2 = new Product("Phone", "23.11.2011","Samsung", "Korea", 9000, true);
        Product prod3 = new Product("Laptop", "22.02.2019","Asus", "Taiwan", 12000, true);

        System.out.println("======================Task 1========================");
        prod1.printInfo();
        prod2.printInfo();
        prod3.printInfo();


        //  2. Создать массив из 5 товаров.
        //  Пример:
        //  вначале объявляем массив объектов
        //  Product[] productsArray = new Product[5];
        //  потом для каждой ячейки массива задаем объект
        //  productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        //  productsArray[1] = new Product(...);
        //...
        //  productsArray[4] = new Product(...);
        Product[] prodArray = new Product[5];
        prodArray[0] = new Product("Phone", "11.11.2011", "Apple", "USA", 10000, false);
        prodArray[1] = new Product("Phone", "23.11.2011", "Samsung", "Korea", 9000, true);
        prodArray[2] = new Product("Laptop", "22.02.2019", "Asus", "Taiwan", 12000, true);
        prodArray[3] = new Product("TV", "22.12.2017", "Samsung", "Korea", 13000, false);
        prodArray[4] = new Product("Laptop", "10.02.2020", "HP", "USA", 11000, true);

        System.out.println("======================Task 2========================");
        System.out.println(Arrays.toString(prodArray));


        //3. Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.
        Park park = new Park();

        System.out.println("======================3========================");
        park.addAttraction("Колесо обозрения", "10.00 - 20.00", 10);
        park.addAttraction("Американские горки", "12.00 - 20.00", 15);
        park.addAttraction("Машинки", "10.00 - 21.00", 15);

        park.printAllAttractions();
    }
}