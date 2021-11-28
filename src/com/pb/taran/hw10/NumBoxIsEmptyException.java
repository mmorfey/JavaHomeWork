package com.pb.taran.hw10;

public class NumBoxIsEmptyException extends Exception {
    public NumBoxIsEmptyException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Массив пуст...";
    }
}