package org.example;

public interface Shape {
    public double getArea(); //метод для расчета площади

    default double getPerimetr() { //метод для расчета периметра
        return 0.0;
    }

    String getFillColor(); //метод для заливки фигуры

    String getBorderColor(); //метод для заливки границы
}