package org.example;

public class Plate {
    public int food;

    public Plate(int food) {
        this.food = food;
    }

    public void reduceFood(int amount) { //уменьшает количество еды
        if (food >= amount) {
            food = food - amount;
        }
    }

    public void addFood(int amount) { //добавляет еду
        if (amount > 0) {
            food = food + amount;
        }
    }

    public int getFood() { //узнать, сколько еды в миске
        return food;
    }

    public void plateFoodInfo() {
        System.out.println("В миске осталось еды: " + food);
    }
}