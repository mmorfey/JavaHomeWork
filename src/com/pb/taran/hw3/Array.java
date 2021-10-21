package com.pb.taran.hw3;

/*
+Создайте класс Array в пакете hw3.
+Программа должна позволить пользователю ввести одномерный массив целых чисел размерностью 10 элементов.
+Вывести на экран введенный массив.
+Подсчитать сумму всех элементов массива и вывести ее на экран.
+Подсчитать и вывести на экран количество положительных элементов.
+Произвести сортировку этого массива от меньшего к большему по алгоритму сортировки пузырьком. (https://en.wikipedia.org/wiki/Bubble_sort)
+Вывести на экран отсортированный массив.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Array {    //Создайте класс Array в пакете hw3.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Программа должна позволить пользователю ввести одномерный массив целых чисел размерностью 10 элементов.
        int[] arrayList = new int[10];

        for (int i = 0; i < arrayList.length; i++) {
            System.out.print("Please enter number " + (i + 1) + ": ");
            arrayList[i] = scan.nextInt();
        }
        System.out.println("Array list (toString): " + Arrays.toString(arrayList));

        System.out.print("Array list (for): ");
        for (int i = 0; i < arrayList.length; i++) {
            if (i < arrayList.length - 1) {
                System.out.print(arrayList[i] + ", ");
            } else {
                System.out.print(arrayList[i]);
            }
        }
        System.out.println();
        //Подсчитать сумму всех элементов массива и вывести ее на экран.
       System.out.println("Array sum (stream): " + Arrays.stream(arrayList).sum());

        int counter = 0;
        int sum = 0;
//        for (int i = 0; i < arrayList.length; i++) { //for
//            if (arrayList[i] > 0) {
//                counter += 1;
//            }
//            sum += arrayList[i];
//        }
        for (int num : arrayList) { //foreach
            if (num > 0) {   //Подсчитать и вывести на экран количество положительных элементов.
                counter += 1;
            }
            sum += num;
        }
        System.out.println("Array sum (for): " + sum);
        System.out.println("Positive array numbers: " + counter);


        for (int i = 0; i < arrayList.length - 1; i++) {    //Произвести сортировку этого массива от меньшего к большему по алгоритму сортировки пузырьком. (https://en.wikipedia.org/wiki/Bubble_sort)
            for (int j = 0; j < arrayList.length - i - 1; j++) {
                if (arrayList[j] > arrayList[j + 1]) {
                    int temp = arrayList[j];
                    arrayList[j] = arrayList[j + 1];
                    arrayList[j + 1] = temp;
                }
            }
        }
        //Вывести на экран отсортированный массив.
        System.out.println("Array sort: " + Arrays.toString(arrayList));
    }
}