package com.pb.taran.hw11;

import java.util.ArrayList;
import java.util.Arrays;

public class Contact {
    private String fullName;
    private String birthDate;
    private String address;
    private ArrayList<String> phoneNumbers;

    public Contact() {
    }

    public Contact(String fullName, String birthDate, String address) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumbers = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getFullName() {
        return fullName;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void addPhone(String phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}