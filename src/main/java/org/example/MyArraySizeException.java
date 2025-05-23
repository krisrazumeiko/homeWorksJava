package org.example;

public class MyArraySizeException extends Exception { //сообщение, если размер массива не 4x4
    public MyArraySizeException(String message) {
        super(message);
    }
}