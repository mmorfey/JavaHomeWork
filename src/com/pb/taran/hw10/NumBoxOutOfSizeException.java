package com.pb.taran.hw10;

public class NumBoxOutOfSizeException extends Exception {
    private final int size;

    public NumBoxOutOfSizeException(int size) {
        this.size = size;
    }

    @Override
    public String getMessage() {
        return "Массив переполнен. Максимальный размер: " + size;
    }
}