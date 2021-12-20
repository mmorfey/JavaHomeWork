package com.pb.taran.hw11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactBook {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ContactList contacts = new ContactList();
        String filePath = "contacts.json";
        String[] mainMenuText = {
                "1 - добавить контакт",
                "2 - найти контакт",
                "3 - вывести все контакты",
                "4 - сохранить контакты в файл",
                "5 - загрузить контакты из файла",
                "0 - завершить работу"
        };
        int usersChoice = 0;

        do {
            usersChoice = getMenuChoice(mainMenuText);
            System.out.println();

            switch (usersChoice) {
                case 0:
                    System.out.println("Телефонная книга закрывается.");
                    break;
                case 1: addContact(contacts);
                    break;
                case 2: findContact(contacts);
                    break;
                case 3: showAllContacts(contacts);
                    break;
                case 4: saveContactsToFile(contacts, filePath, objectMapper);
                    break;
                case 5: ContactList tempContactList = loadContactsFromFile(filePath, objectMapper);
                    if (tempContactList != null) {
                        contacts = tempContactList;
                    }
                    break;
                default:
                    System.out.println("Неизвестный код меню!");
            }
            System.out.println();
        }
        while (usersChoice != 0);
    }

    public static int getMenuChoice(String[] menuText) {
        Scanner console = new Scanner(System.in);
        String choice;

        ArrayList<String> possibleChoices = new ArrayList<>();

        System.out.println("Выберите действие из списка (введите цифру):");
        for (String menuItem: menuText) {
            System.out.println(menuItem);
            possibleChoices.add(menuItem.substring(0, 1));
        }

        do {
            choice = console.nextLine();
        }
        while (!possibleChoices.contains(choice));

        return Integer.parseInt(choice);
    }

    public static void addContact(ContactList contacts) {
        Scanner console = new Scanner(System.in);
        String fullName = titledScan(console, "Введите ФИО контакта:"),
                dateBirth = titledScan(console, "Введите дату рождения:"),
                address = titledScan(console, "Введите адрес:"),
                choice;
        System.out.println(fullName + " " + dateBirth + " " + address);
        Contact contact = new Contact(fullName, dateBirth, address);

        do {
            String phone = titledScan(console, "Введите номер телефона:");
            contact.addPhone(phone);
            choice = titledScan(console, "Чтобы добавить еще номер, введите +, иначе - контакт готов");
        }
        while(choice.equals("+"));
        contacts.add(contact);
    }

    public static String titledScan(Scanner input, String title) {
        System.out.print(title + " ");
        return input.nextLine();
    }

    public static void findContact(ContactList contacts) {
        Scanner console = new Scanner(System.in);
        System.out.println("поиск контакта");
    }

    public static void showAllContacts(ContactList contacts) {
        contacts.print();
    }

    public static void saveContactsToFile(ContactList contacts, String filePath, ObjectMapper mapper) throws JsonProcessingException {
        String jsonAsString = mapper.writeValueAsString(contacts);
        Path path = Paths.get(filePath);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonAsString);
        } catch (IOException exWrite) {
            System.out.println("Ошибка записи в файл " + filePath + ": " + exWrite);
        }
        System.out.println("Контакты успешно записаны в файл " + filePath + ".");
    }

    public static ContactList loadContactsFromFile(String filePath, ObjectMapper mapper) {
        Path path = Paths.get(filePath);
        ContactList result = null;

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String jsonString = reader.readLine();
            System.out.println(jsonString);
            if (jsonString != null) {
                result = mapper.readValue(jsonString, ContactList.class);
                System.out.println("Контакты успешно загружены из файла: " + filePath);
            }
            else {
                System.out.println("В файле " + filePath + " еще нет данных, сохраните сначала список контактов");
            }
        } catch (NoSuchFileException ex) {
            System.out.println("Файл с контактами не найден: " + filePath);
        } catch (IOException exRead) {
            System.out.println("Ошибка чтения контактов из файла " + filePath + ": " + exRead);
        }
        return result;
    }
}