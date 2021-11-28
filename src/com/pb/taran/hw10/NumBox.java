package com.pb.taran.hw10;

public class NumBox<T extends Number> {
    private final T[] values;
    private final int size;
    private int length;
    private double sum;

    public NumBox(int size) {
        this.values = (T[]) new Number[size];
        this.size = size;
        this.length = 0;
        this.sum = 0;
    }
    //метод void add(T num) добавляющий число в массив
    public void add(T num) throws NumBoxOutOfSizeException {
        //В случае если массив полон - выбросить исключение
        if (length >= size) {
            throw new NumBoxOutOfSizeException(size);
        }
        values[length] = num;
        sum += num.doubleValue();
        length++;
    }
    //метод T get(int index) возвращающий число по индексу
    public T get(int index) throws NumBoxOutOfBoundsException {
        if (index < 0 || index >= length) {
            throw new NumBoxOutOfBoundsException(length - 1);
        }
        return values[index];
    }
    //метод int length() возвращает текущее количество элементов
    public int length() {
        return length;
    }
    //метод double average() - подсчет среднего арифметического среди элементов массива
    public double average() throws NumBoxIsEmptyException {
        if (length == 0) {
            throw new NumBoxIsEmptyException();
        }
        return sum / length;
    }
    //метод double sum() - сумма всех элементов массива
    public double sum() {
        return sum;
    }
    //метод T max() - максимальный элемент массива
    public T max() throws NumBoxIsEmptyException {
        if (length == 0) {
            throw new NumBoxIsEmptyException();
        }
        T maxValue = values[0];

        for (int i = 0; i < length; i++) {
            if (values[i].doubleValue() > maxValue.doubleValue()) {
                maxValue = values[i];
            }
        }
        return maxValue;
    }

    public void print() {
        System.out.print("Максимальный размер массива: " + size);
        System.out.println(" / Текущий размер массива: " + length);
        System.out.print("Элементы массива: ");
        try {
            for (int i = 0; i < length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(this.get(i));
            }
        } catch (NumBoxOutOfBoundsException exOutOfBounds) {
            System.out.println(exOutOfBounds.getMessage());
        }
        System.out.println();
        try {
            System.out.println("Сумма всех элементов = " + sum());
            System.out.println("Максимальный элемент = " + max());
        } catch (NumBoxIsEmptyException exBoxEmpty) {
            System.out.println(exBoxEmpty.getMessage());
        }
        try {
            System.out.println("Среднее значение = " + average());
        } catch (NumBoxIsEmptyException exBoxEmpty) {
            System.out.println(exBoxEmpty.getMessage());
        }
    }
}