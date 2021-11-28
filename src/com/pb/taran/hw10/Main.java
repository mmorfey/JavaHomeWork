package com.pb.taran.hw10;

import java.util.Random;

//Создать класс Main с методом main где протестировать полученный класс на примере NumBox<Float> и NumBox<Integer>
public class Main {
    public static void main(String[] args) {
        int integerCount = 5;
        int floatCount = 5;
        NumBox<Integer> numbersInteger = new NumBox<>(integerCount);
        NumBox<Float> numbersFloat = new NumBox<>(floatCount);
        int maxIntValue = 10;
        float maxFloatValue = 10.0f;
        Random random = new Random();

        System.out.println("Максимальное число пустого массива:");
        try {
            System.out.println(numbersInteger.max());
        }
        catch (NumBoxIsEmptyException exBoxEmpty) {
            System.out.println(exBoxEmpty.getMessage());
        }
        System.out.println("Среднее число пустого массива:");
        try {
            System.out.println(numbersFloat.average());
        }
        catch (NumBoxIsEmptyException exBoxEmpty) {
            System.out.println(exBoxEmpty.getMessage());
        }

        System.out.println();
        try {
            while (true) {
                numbersInteger.add(random.nextInt(maxIntValue + 1));
            }
        }
        catch (NumBoxOutOfSizeException exOutOfSize) {
            System.out.println(exOutOfSize.getMessage());
        }
        System.out.println("Массив чисел с типом Integer:");
        numbersInteger.print();

        System.out.println();
        try {
            for (int i=0; i < floatCount - 2; i++) {
                numbersFloat.add(random.nextFloat() * maxFloatValue);
            }
        }
        catch (NumBoxOutOfSizeException exOutOfSize) {
            System.out.println(exOutOfSize.getMessage());
        }
        System.out.println("Массив чисел с типом Float:");
        numbersFloat.print();

        System.out.println();
        int indexOutOfBounds = numbersFloat.length();
        System.out.println("Элемент Float по индексу: " + indexOutOfBounds);
        try {
            numbersFloat.get(indexOutOfBounds);
        }
        catch (NumBoxOutOfBoundsException exOutBounds) {
            System.out.println(exOutBounds.getMessage());
        }
    }
}