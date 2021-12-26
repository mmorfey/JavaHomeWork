package com.pb.taran.hw12;

import java.util.ArrayList;
import java.util.Comparator;

public class ContactList {
    private ArrayList<Contact> list;

    ContactList() {
        this.list = new ArrayList<>();
    }

    ContactList(ContactList anotherContactList) {
        this.list = anotherContactList.getList();
    }

    public void add(Contact contact) {
        list.add(contact);
    }

    public void del(int index) {
        list.remove(index);
    }

    public boolean del(Contact contact) {
        int index = list.indexOf(contact);
        if (index != -1) {
            list.remove(index);
            return true;
        }
        return false;
    }

    public Contact get(int index) {
        return list.get(index);
    }

    public int length() {
        return list.size();
    }

    public ArrayList<Contact> getList() {
        return list;
    }

    public void print() {
        for (Contact contact: list) {
            System.out.println();
            System.out.println("Контакт № " + (list.indexOf(contact) + 1));
            System.out.println(contact);
        }
    }

    public Contact find(String key, String value) {
        switch (key) {
            case "number":
                int index = Integer.parseInt(value) - 1;
                if (index >= 0 && index < list.size()) {
                    return list.get(index);
                }
                else {
                    System.out.println("Введенное число за пределами списка!");
                }
            case "name":
                for(Contact contact: list) {
                    if (contact.getFullName().equals(value)) {
                        return contact;
                    }
                }
            case "birth":
                for(Contact contact: list) {
                    if (contact.getBirthDate().equals(value)) {
                        return contact;
                    }
                }
            case "address":
                for(Contact contact: list) {
                    if (contact.getAddress().equals(value)) {
                        return contact;
                    }
                }
            case "phone":
                for(Contact contact: list) {
                    if (contact.getPhoneNumbers().contains(value)) {
                        return contact;
                    }
                }
        }
        return null;
    }

    public void sort(String key) {
        switch (key) {
            case "name":
                list.sort(Comparator.comparing(Contact::getFullName));
                break;
            case "birth":
                list.sort(Comparator.comparing(Contact::getBirthDate));
                break;
            case "address":
                list.sort(Comparator.comparing(Contact::getAddress));
                break;
            case "datetime":
                list.sort(Comparator.comparing(Contact::getChangeTime));
                break;
        }
    }
}