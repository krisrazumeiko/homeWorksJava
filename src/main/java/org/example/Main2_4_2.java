package org.example;

public class Main2_4_2 {
    public static void main(String[] args) {
        //Задание 2
        //Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур: круг, прямоугольник, треугольник.
        //Задать для каждой фигуры цвет заливки и цвет границы.
        //Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ] по каждой фигуре вывести в консоль.
        //Попробуйте реализовать базовые методы, такие как расчет периметра фигур, в качестве дефолтных методов в интерфейсе.

        Rectangle rectangle1 = new Rectangle(12.3, 14, "green", "white");
        rectangle1.rectangleInfo();
        System.out.println("=================================================================");

        Triangle triangle1 = new Triangle(5.2, 5, "white", "black");
        triangle1.triangleInfo();
        System.out.println("=================================================================");

        Circle circle1 = new Circle(20, "red", "yellow");
        circle1.circleInfo();
    }
}