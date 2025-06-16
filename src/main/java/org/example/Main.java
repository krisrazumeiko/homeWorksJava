package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //    Задание 2.6.1
        //    Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
        //    Создайте коллекцию, содержащую объекты класса Student.
        //    Следует написать метод, который удаляет студентов со средним баллом < 3,
        //    а также отдельный метод, который переводит студента на следующий курс, если средний балл >= 3.

        List<Student> students = new ArrayList<>(); //создаeм коллекцию
        students.add(new Student("Гриша", 1, 1, Arrays.asList(4, 3, 8, 9)));
        students.add(new Student("Вова", 10, 2, Arrays.asList(9, 9, 8, 9)));
        students.add(new Student("Лена", 13, 1, Arrays.asList(10, 7, 8, 9)));
        students.add(new Student("Петя", 1, 3, Arrays.asList(1, 1, 2, 9)));
        students.add(new Student("Оля", 13, 1, Arrays.asList(8, 9, 8, 9)));
        students.add(new Student("Катя", 2, 3, Arrays.asList(2, 1, 1, 1)));
        students.add(new Student("Ваня", 5, 3, Arrays.asList(5, 6, 9, 10)));
        students.add(new Student("Галя", 13, 1, Arrays.asList(3, 3, 3, 3)));
        students.add(new Student("Таня", 3, 3, Arrays.asList(9, 8, 8, 8)));
        students.add(new Student("Егор", 12, 2, Arrays.asList(10, 10, 10, 10)));
        students.add(new Student("Саша", 2, 3, Arrays.asList(1, 1, 1, 1)));

        System.out.println("Изначальный массив:");
        for (Student student : students) {
            student.printInfo();
        }
        System.out.println("===========================");

        //removeStudents(students);
        transitionToNextCourse(students);

        System.out.println("Измененный массив:");
        for (Student student : students) {
            student.printInfo();
        }
        System.out.println("===========================");

        printStudents(students, 2);

        System.out.println("============Task 2.6.2===============");
        //Задание 2.6.2
        //    Задание 2.6.2
        //    Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи,
        //    а с помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        //    тогда при запросе такой фамилии должны выводиться все телефоны.
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "111-11-11");
        phoneBook.add("Иванов", "222-22-22");
        phoneBook.add("Петров", "333-33-33");
        phoneBook.add("Сидоров", "511-11-11");
        phoneBook.add("Иванов", "222-22-22");
        phoneBook.add("Сидоров", "633-33-33");

        phoneBook.get("Иванов");  // Три номера
        phoneBook.get("Сидоров"); //Два номера
        phoneBook.get("Попков"); // Такого нет — будет сообщение об отсутствии
    }

    //2.6.1
    //Метод удаляет студентов с низким средним баллом (< 3.0)
    public static void removeStudents(List<Student> students) {
        // Получаем итератор для списка студентов
        Iterator<Student> iterator = students.iterator();

        // Пока есть следующий элемент в списке
        while (iterator.hasNext()) {
            // Получаем следующего студента
            Student student = iterator.next();

            // Проверяем, если средняя оценка меньше 3.0
            if (student.avgGrades() < 3.0) {
                // Удаляем этого студента из списка
                iterator.remove();
            }
        }
    }

    // Повышаем курс у студентов с оценками >= 3
    public static void transitionToNextCourse(List<Student> students) {
        for (Student student : students) {
            if (student.avgGrades() >= 3.0) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }


    //    Напишите метод printStudents(Set<Student> students, int course), который получает список студентов и номер курса.
    //    Метод печатает на консоль имена тех студентов, которые обучаются на данном курсе.
    public static void printStudents(Collection<Student> students, int course) {
        // Проходим по каждому студенту в коллекции
        System.out.println("Студенты, которые учатся на курсе: ");
        for (Student student : students) {
            // Проверяем, на том ли курсе учится студент
            if (student.getCourse() == course) {
                // Если да — выводим его имя
                System.out.println(student.getName());
            }
        }
    }
}