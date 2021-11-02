package com.pb.taran.hw5;

//    Имеет перегруженные методы takeBook(), returnBook():
//
//    - takeBook, который будет принимать количество взятых книг.
//    Выводит на консоль сообщение
//    "Петров В. В. взял 3 книги".
//
//    - takeBook, который будет принимать переменное количество названий книг.
//    Выводит на консоль сообщение
//    "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
//
//    - takeBook, который будет принимать переменное количество объектов класса Book.
//    Выводит на консоль сообщение
//    "Петров В. В. взял книги: Приключения (Иванов И. И. 2000 г.), Словарь (Сидоров А. В 1980 г.), Энциклопедия (Гусев К. В. 2010 г.)".
//
//    Аналогичным образом перегрузить метод returnBook().
//    Должно быть 3 метода returnBook() которые выводит на консоль сообщения:
//    - "Петров В. В. вернул 3 книги"
//    - "Петров В. В. вернул книги: Приключения, Словарь, Энциклопедия".
//    - "Петров В. В. вернул книги: Приключения (Иванов И. И. 2000 г.), Словарь (Сидоров А. В 1980 г.), Энциклопедия (Гусев К. В. 2010 г.)".

import java.util.Arrays;

import static jdk.nashorn.internal.parser.TokenType.OR;

public class Reader {
    private String userName; // ФИО
    private String faculty; // факультет
    private String phoneNumber; // телефон
    private String birthDay; // дата рождения
    private int userId; //номер читательского билета

    public Reader(String userName, int userId, String phoneNumber, String faculty, String birthDay) {
        this.userName = userName;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.birthDay = birthDay;
    }

    public String toString() {
        return "ФИО: " + userName + ", номер читательского билета " + userId + ", факультет: " + faculty + ", дата рождения: " + birthDay + ", телефон: " + phoneNumber;
    }

    //takeBook, который будет принимать количество взятых книг
    public String takeBook(int booksTaken) {
        if (booksTaken == 1) {
            return userName + " взял " + booksTaken + " книгу";
        } else if (booksTaken == 2 || booksTaken == 3) {
            return userName + " взял " + booksTaken + " книги";
        }
        return userName + " взял " + booksTaken + " книг";
    }

    //returnBook, который будет принимать количество взятых книг
    public String returnBook(int booksReturn) {
        if (booksReturn == 1) {
            return userName + " вернул " + booksReturn + " книгу";
        } else if (booksReturn == 2 || booksReturn == 3) {
            return userName + " вернул " + booksReturn + " вернул";
        }
        return userName + " вернул " + booksReturn + " книг";
    }

    //takeBook, который будет принимать переменное количество названий книг
    public String takeBook(String... bookNames) {
        return userName + " взял книги: " + String.join(", ", bookNames);
    }

    //returnBook, который будет принимать переменное количество названий книг
    public String returnBook(String... bookNames) {
        return userName + " вернул книги: " + String.join(", ", bookNames);
    }

    //takeBook, который будет принимать переменное количество объектов класса Book
    public String takeBook(Book... books) {
        StringBuilder textList = new StringBuilder();

        for (int i = 0; i < books.length; i++) {
            if (i > 0) {
                textList.append(", ");
            }
            textList.append(books[i]);
        }
        return userName + " взял книги: " + textList;
    }

    //returnBook, который будет принимать переменное количество объектов класса Book
    public String returnBook(Book... books) {
        StringBuilder textList = new StringBuilder();

        for (int i = 0; i < books.length; i++) {
            if (i > 0) {
                textList.append(", ");
            }
            textList.append(books[i]);
        }
        return userName + " вернул книги: " + textList;
    }
}
