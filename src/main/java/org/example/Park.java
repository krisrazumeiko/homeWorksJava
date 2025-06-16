package org.example;

import java.util.ArrayList;
import java.util.List;

public class Park {
    //private Attraction attraction;

    //inner class Attraction
    public class Attraction {
        String name;
        String time;
        int priceTicket;

        //конструктор
        public Attraction (String name, String time, int priceTicket) {
            this.name = name;
            this.time = time;
            this.priceTicket = priceTicket;
        }

        //вывод информации о работе аттракционов
        public void printInfo () {
            System.out.println("Название: " + '\'' + name + '\'');
            System.out.println("Время работа: " + time);
            System.out.println("Цена билета = " + priceTicket + "\n");
        }
    }

    // список всех аттракционов парка
    private List<Attraction> attractions = new ArrayList<>();

    //метод добавления аттракциона
    public void addAttraction(String name, String time, int priceTicket) {
        Attraction attraction = new Attraction(name, time, priceTicket);
        attractions.add(attraction);
    }

    // метод вывода информации обо всех аттракционах
    public void printAllAttractions() {
        if(attractions.isEmpty()) {
            System.out.println("В парке нет аттрационов");
        } else {
            for(int i = 0; i < attractions.size(); i++){
                attractions.get(i).printInfo();
            }
        }
    }
}