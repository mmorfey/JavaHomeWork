package com.pb.taran.hw11;

// Задача почти готова. Loading... Простите(

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Scanner;



public class ContactBook {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Contact contact = new Contact("Dude", "01.01.2000", "some street");
        Contact contact2 = new Contact("Chick", "02.02.2002", "next street");
        int choice;
        /*
        ContactList contacts = new ContactList();
        contacts.add(contact);
        contacts.add(contact2);
        String result = objectMapper.writeValueAsString(contacts);
        System.out.println(result);
        ContactList contacts2 = objectMapper.readValue(result, ContactList.class);
        contacts2.print();
        System.out.println();
        */
        do {
            choice = getMainMenuChoise();

            switch (choice) {
                case 0: addContact();
                    break;
                default:
                    System.out.println("Неизвестный код меню!");
            }
            System.out.println("Вы выбрали вариант: " + choice);
        }
        while (choice == 0);
    }

    public static int getMainMenuChoise() {
        Scanner console = new Scanner(System.in);
        String choice;
        String[] menuList = {
                "1 - добавить контакт",
                "2 - найти контакт",
                "3 - вывести все контакты",
                "4 - сохранить контакты в файл",
                "5 - загрузить контакты из файла",
                "0 - завершить работу"
        };
        ArrayList<String> possibleChoices = new ArrayList<>();

        System.out.println("Выберите действие из списка (введите цифру):");
        for (String menuItem: menuList) {
            System.out.println(menuItem);
            possibleChoices.add(menuItem.substring(0, 1));
        }

        do {
            choice = console.nextLine();
        }
        while (!possibleChoices.contains(choice));

        return Integer.parseInt(choice);
    }

    public static void addContact() {
        Scanner console = new Scanner(System.in);

    }
}