package com.pb.taran.hw11;

import java.util.Arrays;

public class Contact {
    private String fullName;
    private String birthDate;
    private String address;
    private String[] phones;

    public Contact() {
    }

    public Contact(String fullName, String birthDate, String address) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
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

    @Override
    public String toString() {
        return "{" +
                "fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", address='" + address + '\'' +
                ", phones=" + Arrays.toString(phones) +
                '}';
    }
}