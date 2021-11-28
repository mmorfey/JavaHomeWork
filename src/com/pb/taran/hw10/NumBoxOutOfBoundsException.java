package com.pb.taran.hw10;

public class NumBoxOutOfBoundsException extends Exception {
    private final int maxIndex;

    public NumBoxOutOfBoundsException(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    @Override
    public String getMessage() {
        return "Указанный индекс за пределами допустимых значений: 0.." + maxIndex;
    }
}