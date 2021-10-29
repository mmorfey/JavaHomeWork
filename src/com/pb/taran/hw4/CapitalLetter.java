package com.pb.taran.hw4;

/*
Создайте класс CapitalLetter в пакете hw4.
Напишите программу, которая принимает строку и переводит первую букву слова в верхний регистр.
Строку должен ввести пользователь.
Пример работы:
Истина — это то, что выдерживает проверку опытом. Эйнштейн А.
Истина — Это То, Что Выдерживает Проверку Опытом. Эйнштейн А.
При выполнении задания использовать метод(ы).
 */

import java.util.Scanner;

public class CapitalLetter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputString, outputString;

        System.out.print("Введите строку для обработки: ");
        inputString = scan.nextLine();
        outputString = toUpperCase(inputString);

        System.out.print("Строка после обработки: ");
        System.out.println(outputString);
    }

    public static String toUpperCase(String text) {
        char[] textArray = text.toCharArray();
        final String separators = " \t,.!?\"";
        boolean prevCharIsSeparator = true;

        for (int i = 0; i < textArray.length; i++) {
            char curChar = textArray[i];

            if (Character.isLowerCase(curChar) && prevCharIsSeparator) {
                textArray[i] = Character.toUpperCase(curChar);
            }
            prevCharIsSeparator = (separators.indexOf(curChar) != -1);
        }
        return String.valueOf(textArray);
    }
}