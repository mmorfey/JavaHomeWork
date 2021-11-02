package com.pb.taran.hw5;

public class Book {
    private String title, author;
    private int yearOfPublishing;

    public Book(String author, String title, int yearOfPublishing) {
        this.author = author;
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;

    }

    public String toString() {
        return title + " (" + author + " " + yearOfPublishing + " г.)";
    }

    public String getTitle() {
        return title;
    }
}