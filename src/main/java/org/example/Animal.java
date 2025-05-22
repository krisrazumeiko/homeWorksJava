package org.example;

public class Animal {
    protected String name;
    public static int totalAnimals = 0;//переменная для подсчета всех животных

    //Конструктор, в том числе для подсчета созданных животных
    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал(а) " + distance + " м");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл(а) " + distance + " м");
    }
}