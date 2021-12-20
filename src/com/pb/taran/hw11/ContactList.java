package com.pb.taran.hw11;

import java.util.ArrayList;

public class ContactList {
    private ArrayList<Contact> list;

    ContactList() {
        this.list = new ArrayList<>();
    }

    ContactList(ArrayList<Contact> contacts) {
        this.list = contacts;
    }

    public void add(Contact contact) {
        list.add(contact);
    }

    public void del(int index) {
        list.remove(index);
    }

    public ArrayList<Contact> getList() {
        return list;
    }

    public void print() {
        if (list.size() == 0) {
            System.out.println("Список контактов пуст");
        }
        else {
            for (Contact contact: list) {
                System.out.println(contact);
            }
        }
    }
}