package org.example;

public class Rectangle implements Shape{ //прямоугольник
    private double length;
    private double width;
    String fillColor;
    String borderColor;

    public Rectangle(double length, double width, String fillColor, String borderColor) {
        this.length = length;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimetr() {
        return 2 * (length + width);
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    public void rectangleInfo() {
        System.out.println(String.format("Площадь прямоугольника:  %.2f", + getArea()) + "\n" +
                "Периметр прямоугольника: " + getPerimetr() + "\n" +
                "Цвет заливки прямоугольника: " + getFillColor() + "\n" +
                "Цвет границы прямоугольника: " + getBorderColor() + "\n" +
                "----------------------------------------------------------\n");
    }
}