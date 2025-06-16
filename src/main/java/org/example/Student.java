package org.example;

import java.util.*;
public class Student {

    String studentName;
    int group;
    int course;
    List<Integer> grades;

    public Student(String studentName, int group, int course, List<Integer> grades) {
        this.studentName = studentName;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double avgGrades() {
        int sum = 0;

        for(int i = 0; i < grades.size(); i++) { // Проходим по всем оценкам
            sum = sum + grades.get(i); // Получаем оценку по индексу и добавляем к сумме
        }
        return (double) sum / grades.size();//привели результат к типу double для точности
    }

    public String getName() {
        return studentName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void printInfo() {
        System.out.println(studentName + " | Группа: " + group + " | Курс: " + course + " | Средняя оценка: " + avgGrades());
    }
}