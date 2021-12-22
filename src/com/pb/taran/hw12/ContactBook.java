package com.pb.taran.hw12;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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
        objectMapper.registerModule(new JavaTimeModule());
        ContactList contacts;
        String filePath = "contacts.json";
        String[] mainMenuText = {
                "1 - добавить контакт",
                "2 - найти контакт",
                "3 - вывести все контакты",
                "4 - сохранить контакты в файл",
                "5 - загрузить контакты из файла",
                "0 - завершить работу"
        };
        int usersChoice;

        contacts = loadContactsFromFile(filePath, objectMapper);
        System.out.println();

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
                case 5: contacts = loadContactsFromFile(filePath, objectMapper);
                    break;
                default:
                    System.out.println("Неизвестный код главного меню!");
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
            contact.addPhoneNumber(phone);
            choice = titledScan(console, "Чтобы добавить еще номер, введите +");
        }
        while(choice.equals("+"));
        contacts.add(contact);
        System.out.println("Контакт добавлен");
    }

    public static String titledScan(Scanner input, String title) {
        System.out.print(title + " ");
        return input.nextLine();
    }

    public static void findContact(ContactList contacts) {
        Scanner console = new Scanner(System.in);
        Contact contact = null;
        String[] findMenuText = {
                "1 - найти контакт по № в списке",
                "2 - найти контакт по ФИО",
                "3 - найти контакт по дате рождения",
                "4 - найти контакт по адресу",
                "5 - найти контакт по номеру телефона",
                "0 - в главное меню"
        };
        int usersChoice = getMenuChoice(findMenuText);
        System.out.println();

        switch (usersChoice) {
            case 0: break;
            case 1: String number = titledScan(console, "Введите № в списке:");
                contact = contacts.find("number", number);
                break;
            case 2: String name = titledScan(console, "Введите ФИО:");
                contact = contacts.find("name", name);
                break;
            case 3: String birth = titledScan(console, "Введите дату рождения:");
                contact = contacts.find("birth", birth);
                break;
            case 4: String address = titledScan(console, "Введите новый адрес:");
                contact = contacts.find("address", address);
                break;
            case 5: String phone = titledScan(console, "Введите номер телефона:");
                contact = contacts.find("phone", phone);
                break;
            default:
                System.out.println("Неизвестный код меню поиска!");
        }
        System.out.println();

        if (contact == null) {
            System.out.println("Ничего не найдено!");
            return;
        }

        String[] contactMenuText = {
                "1 - редактировать контакт",
                "2 - удалить контакт",
                "0 - в главное меню"
        };
        usersChoice = getMenuChoice(contactMenuText);
        System.out.println();

        switch (usersChoice) {
            case 0: break;
            case 1: editContact(contact);
                break;
            case 2: delContact(contacts, contact);
                break;
            default:
                System.out.println("Неизвестный код меню контакта!");
        }
        System.out.println();
    }

    public static void showAllContacts(ContactList contacts) {
        if (contacts.length() == 0) {
            System.out.println("Список контактов пуст");
            return;
        }

        String[] showListMenuText = {
                "1 - вывести список контактов как есть",
                "2 - вывести список контактов, сортированный по ФИО",
                "3 - вывести список контактов, сортированный по дате рождения",
                "4 - вывести список контактов, сортированный по адресу",
                "5 - вывести список контактов, сортированный по дате изменения",
                "0 - в главное меню"
        };
        int usersChoice = getMenuChoice(showListMenuText);
        ContactList showList = new ContactList(contacts);
        System.out.println();

        switch (usersChoice) {
            case 0: return;
            case 1: break;
            case 2: showList.sort("name"); break;
            case 3: showList.sort("birth"); break;
            case 4: showList.sort("address"); break;
            case 5: showList.sort("datetime"); break;
            default:
                System.out.println("Неизвестный код меню списка контактов!");
        }
        System.out.println();
        System.out.println("Список контактов:");
        showList.print();
    }

    public static void editContact(Contact contact) {
        System.out.println(contact);

        String[] editMenuText = {
                "1 - редактировать ФИО",
                "2 - редактировать дату рождения",
                "3 - редактировать адрес",
                "4 - добавить номер телефона",
                "5 - удалить номер телефона",
                "0 - в главное меню"
        };
        int usersChoice = getMenuChoice(editMenuText);
        System.out.println();

        Scanner console = new Scanner(System.in);
        String choice;

        switch (usersChoice) {
            case 0: break;
            case 1: String fullName = titledScan(console, "Введите новое ФИО контакта:");
                contact.setFullName(fullName);
                break;
            case 2: String dateBirth = titledScan(console, "Введите новую дату рождения:");
                contact.setBirthDate(dateBirth);
                break;
            case 3: String address = titledScan(console, "Введите новый адрес:");
                contact.setAddress(address);
                break;
            case 4:
                do {
                    String phone = titledScan(console, "Введите номер телефона:");
                    contact.addPhoneNumber(phone);
                    choice = titledScan(console, "Чтобы добавить еще номер, введите +");
                }
                while (choice.equals("+"));
                break;
            case 5:
                do {
                    String strIndex = titledScan(console, "Введите номер по счету в списке телефонов, который нужно удалить:");
                    contact.delPhoneNumber(Integer.parseInt(strIndex) + 1);
                    choice = titledScan(console, "Чтобы удалить еще номер, введите -");
                }
                while (choice.equals("-"));
                break;
            default:
                System.out.println("Неизвестный код меню редактирования!");
        }
        System.out.println();
    }

    public static void delContact(ContactList contacts, Contact contact)  {
        if (contacts.del(contact)) {
            System.out.println("Контакт удален");
        }
        else {
            System.out.println("Контакт не найден в списке");
        }
    }

    public static void saveContactsToFile(ContactList contacts, String filePath, ObjectMapper mapper) throws JsonProcessingException {
        if (contacts.length() == 0) {
            System.out.println("Список контактов пуст, нечего сохранять");
            return;
        }
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
        ContactList result = new ContactList();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String jsonString = reader.readLine();
            // System.out.println(jsonString);
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