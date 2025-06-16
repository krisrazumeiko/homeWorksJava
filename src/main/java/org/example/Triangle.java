package org.example;

public class Triangle implements Shape{ //треугольник
    private double length;
    private double height;
    String fillColor;
    String borderColor;

    public Triangle(double length, double height, String fillColor, String borderColor) {
        this.length = length;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double getArea() {
        return (length * height)/2;
    }

    @Override
    public double getPerimetr() {
        return length * 3;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    public void triangleInfo() {
        System.out.println("Площадь треугольника: " + getArea() + "\n" +
                String.format("Периметр треугольника: %.2f", + getPerimetr()) + "\n" +
                "Цвет заливки треугольника: " + getFillColor() + "\n" +
                "Цвет границы треугольника: " + getBorderColor() + "\n" +
                "----------------------------------------------------------\n");
    }
}