package com.pb.taran.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Создайте две целочисленных переменные с именами operand1 и operand2.
        int operand1;
        int operand2;
        String sign;

        //Предложите ввести значения operand1 и operand2 пользователю.
        System.out.print("Enter first operand: ");
        operand1 = scan.nextInt();
        System.out.print("Enter second operand: ");
        operand2 = scan.nextInt();

        //Также предложите пользователю ввести знак арифметической операции и поместите его в строковую переменную sign.
        System.out.print("Enter operation type (+, -, *, /): ");
        sign = scan.next();

        //Для организации выбора алгоритма вычислительного процесса, используйте переключатель switch.
        //Выведите на экран результат выполнения арифметической операции.
        switch (sign) {
            case "+":
                System.out.println("Result: " + (operand1 + operand2));
                break;
            case "-":
                System.out.println("Result: " + (operand1 - operand2));
                break;
            case "*":
                System.out.println("Result: " + (operand1 * operand2));
                break;
            case "/":
                if (operand2 == 0) {
                    System.out.print("Wrong operation. Divide by zero");
                } else {
                    System.out.println("Result: " + (operand1 / operand2));
                }
                break;
            default:
                System.out.println("Wrong operation. Only +,-,*,/");
        }
    }
}
