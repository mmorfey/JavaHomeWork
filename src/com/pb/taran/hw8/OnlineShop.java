package com.pb.taran.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Auth user = new Auth();

        System.out.println("Для начала зарегистрируйтесь");
        if (!safeSignUp(user)) return;

        System.out.println("Отлично! Теперь авторизуйтесь.");
        if (!safeSignIn(user)) return;
    }

    private static boolean safeSignUp(Auth user) {
        Scanner console = new Scanner(System.in);
        String login = readString(console, "Введите логин (от 5 до 15 символов, только латинские буквы или цифры): ");
        String password = readString(console, "Введите пароль (8 и более символов, только латинские буквы, цифры или знаки _ & $: ");
        String confirmPassword = readString(console, "Повторите пароль: ");

        try {
            user.signUp(login, password, confirmPassword);
        }
        catch (WrongLoginException | WrongPasswordException signUpException) {
            System.out.println("Ошибка: " + signUpException.getMessage());
            return false;
        }
        System.out.println();
        return true;
    }

    private static boolean safeSignIn(Auth user) {
        Scanner console = new Scanner(System.in);
        String login = readString(console, "Введите логин: ");
        String password = readString(console, "Введите пароль: ");

        try {
            user.signIn(login, password);
        }
        catch (WrongLoginException | WrongPasswordException signInException) {
            System.out.println("Ошибка: " + signInException.getMessage());
            return false;
        }
        System.out.println();
        return true;
    }

    private static String readString(Scanner input, String title) {
        System.out.print(title);
        return input.nextLine();
    }
}