package org.example;

public class Product {
    String name;
    String prodDate;
    String producer;
    String prodCountry;
    int price;
    Boolean bookState;

    public Product(String name, String prodDate, String producer, String prodCountry, int price, Boolean bookState) {
        this.name = name;
        this.prodDate = prodDate;
        this.producer = producer;
        this.prodCountry = prodCountry;
        this.price = price;
        this.bookState = bookState;
    }

    public String toString() {
        return "\nТовар: " +
                "\nНазвание: " + this.name +
                "\nДата производства: " + this.prodDate +
                "\nПроизводитель: " + this.producer +
                "\nCтрана происхождения: " + this.prodCountry +
                "\nЦена: " + this.price +
                "\nСостояние бронирования покупателем: " + this.bookState +
                "\n-------------------------------------------------------";
    }

    public void printInfo() {
        System.out.println(this); // вызовет toString()
    }
}