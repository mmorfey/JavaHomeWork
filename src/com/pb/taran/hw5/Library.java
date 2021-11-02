package com.pb.taran.hw5;

//Класс Library используется как демонстрация работы классов Book и Reader.
//        Имеет метод main() в котором создается массивы объектов Book и Reader, по 3 или более элементов в каждом.
//        Выполняются такие действия:
//        - печатаются все книги.
//        - печатаются все читатели.
//        - демонстрируется работа всех вариантов методов takeBook() и returnBook().

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        Reader[] readers = new Reader[3];

        books[0] = new Book("Marcel Proust", "In Search of Lost Time", 1913);
        books[1] = new Book("James Joyce", "Ulysses", 1904);
        books[2] = new Book("Miguel de Cervantes", "Don Quixote", 1605);
        books[3] = new Book("Gabriel Garcia Marquez", "One Hundred Years of Solitude", 1967);
        books[4] = new Book("F. Scott Fitzgerald", "The Great Gatsby", 1925);

        readers[0] = new Reader("Паша Новиков", 14753698, "050-123-45-67", "Gryffindor", "12.12.2000");
        readers[1] = new Reader("Лев Дуров", 85635445, "099-765-43-21", "Hufflepuff", "23 декабря 1931");
        readers[2] = new Reader("Андрей Шевченко", 63759612, "067-451-32-67", "Ravenclaw", "29/09/1976");

        System.out.println("________________Перечень книг___________________");
        for (Book book: books) {
            System.out.println(book);
        }

        System.out.println();

        System.out.println("______________Список читателей__________________");
        for (Reader reader: readers) {
            System.out.println(reader);
        }

        System.out.println();

        System.out.println("_______________Взятые книги___________________");

        System.out.println(readers[0].takeBook(3));
        System.out.println(readers[2].takeBook(books[4]));
        System.out.println(readers[1].takeBook(books[1].getTitle(), books[2].getTitle(), books[3].getTitle()));

        System.out.println();

        System.out.println("____________Возвращенные книги________________");
        System.out.println(readers[2].returnBook(1));
        System.out.println(readers[0].returnBook(books[3]));
        System.out.println(readers[2].returnBook(books[0].getTitle(), books[4].getTitle(), books[1].getTitle()));

    }
}
