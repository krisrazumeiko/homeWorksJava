package org.example;

public class Dog extends Animal {
    String color;
    public static int dogCount = 0;

    public Dog(String name, String color) {
        super(name);
        this.color = color;
        dogCount++;
    }

    public void dogInfo() {
        System.out.println("Собака по кличке: " + name + "; " + "ее цвет: " + color);
    }

    //бег: собака 500 м.
    @Override
    public void run(int distance) {
        if(distance <= 500) {
            System.out.println("Собака пробежала " + distance + " м");
        } else {
            System.out.println("Собака не может пробежать больше, чем 500 м");
        }
    }

    @Override
    //плавание: собака 10 м
    public void swim(int distance) {
        if(distance <= 10) {
            System.out.println("Собака проплыла " + distance + " м");
        } else {
            System.out.println("Собака не может проплыть больше, чем 10 м");
        }
    }
}
