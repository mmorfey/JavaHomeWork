package com.pb.taran.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number;

        //Предложите пользователю ввести целое число и сохраните его в переменную с произвольным именем
        System.out.print("Enter integer: ");
        while (!scan.hasNextInt()) {
            System.out.println("That not a integer!");
            System.out.print("Enter again: ");
            scan.next();
        }
        number = scan.nextInt();

        //Программа должна выяснить в какой промежуток попадает введенное число [0 - 14] [15 - 35] [36 - 50] [51 - 100].
        //Вывести на экран сообщение с подходящим промежутком.
        if (number >= 0 && number <= 14) {
            System.out.print("Integer in range  [0 - 14]");
        } else if (number >= 15 && number <= 35) {
            System.out.println("Integer in range  [15 - 35]");
        } else if (number >= 36 && number <= 50) {
            System.out.println("Integer in range  [36 - 50]");
        } else if (number >= 51 && number <= 100) {
            System.out.println("Integer in range  [51 - 100]");
        //Если введенное число не попадает в один из имеющихся промежутков, то вывести соответствующее сообщение.
        } else {
            System.out.println("Your integer " + number + ". Unknown range ¯\\_(ツ)_/¯");
        }
    }
}