package org.example;
import java.util.Arrays;

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
}