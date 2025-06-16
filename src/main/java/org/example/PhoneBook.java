package org.example;

import  java.util.*;
public class PhoneBook {
    Map<String, List<String>> phoneBook;
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        // Если фамилия уже есть в справочнике
        if (phoneBook.containsKey(lastName)) {
            // Добавляем номер в уже существующий список
            phoneBook.get(lastName).add(phoneNumber);
        } else {
            // Если фамилии ещё нет, создаём новый список и добавляем номер
            List<String> phones = new ArrayList<>();
            phones.add(phoneNumber);
            phoneBook.put(lastName, phones);
        }
    }

    public void get(String lastName) {
        List<String> phones = phoneBook.get(lastName);
        if (phones != null) {
            System.out.println("Телефоны для " + lastName + ":");
            for (String phone : phones) {
                System.out.println(phone);
            }
        } else {
            System.out.println("Фамилия " + lastName + " не найдена в справочнике.");
        }
    }
}
