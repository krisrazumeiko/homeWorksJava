package org.example;

public class Cat extends Animal {
    String color;
    public static int catCount = 0;
    private boolean catStiety = false; //добавили поле сытость
    private int catAppetite; //аппетит кота

    public Cat(String name, String color, int catAppetite) {
        super(name);
        this.color = color;
        this.catAppetite = catAppetite;
        catCount++;
    }

    public void catToEat(Plate plate) { //попытка кота поесть из миски. Проверка кол-во еды в миске
        if (plate.getFood() >= catAppetite) {
            plate.reduceFood(catAppetite);
            catStiety = true;
        } else {
            catStiety = false;
        }
    }

    public void CatStietyInfo() {
        if (catStiety) {
            System.out.println(name + " сыт");
        } else {
            System.out.println(name + " голоден");
        }
    }

    public void catInfo() {
        System.out.println("Кот с именем: " + name + "; " + "имеет цвет: " + color + " сытость кота: " + catStiety);
    }

    @Override
    //бег: кот 200 м.
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот пробежал " + distance + " м");
        } else {
            System.out.println("Кот не может пробежать больше, чем 200 м");
        }
    }

    @Override
    //плавание: кот не умеет плавать
    public void swim(int distance) {
        System.out.println("Коты не умеют плавать!");
    }
}