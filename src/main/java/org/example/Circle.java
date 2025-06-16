package org.example;

public class Circle implements Shape{ //круг
    private double radius;
    private double pi = 3.14;
    String fillColor;
    String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getArea() { //площадь круга
        return pi * (radius * radius);
    }

    @Override
    public double getPerimetr() { //длина окружности
        return 2 * pi * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    public void circleInfo() {
        System.out.println("Площадь круга: " + getArea() + "\n" +
                String.format("Длина окружности: %.2f", getPerimetr()) + "\n" +
                "Цвет заливки круга: " + getFillColor() + "\n" +
                "Цвет границы круга: " + getBorderColor() + "\n" +
                "----------------------------------------------------------\n");
    }
}