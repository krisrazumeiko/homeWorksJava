package org.example;

public class MyArrayDataException extends Exception{ //сообщение, если внутри массива не число
    public MyArrayDataException(String message) {
        super(message);
    }
}