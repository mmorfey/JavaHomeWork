package com.pb.taran.hw11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Contact {
    private String fullName;
    private String birthDate;
    private String address;
    private ArrayList<String> phoneNumbers;
    private LocalDateTime changeTime;

    public Contact() {
    }

    public Contact(String fullName, String birthDate, String address) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumbers = new ArrayList<>();
        this.changeTime = LocalDateTime.now();
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

    public LocalDateTime getChangeTime() {
        return changeTime;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        this.changeTime = LocalDateTime.now();
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        this.changeTime = LocalDateTime.now();
    }

    public void setAddress(String address) {
        this.address = address;
        this.changeTime = LocalDateTime.now();
    }

    public void addPhoneNumber(String phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
        this.changeTime = LocalDateTime.now();
    }

    public void delPhoneNumber(int index) {
        this.phoneNumbers.remove(index);
        this.changeTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return "ФИО: " + fullName +
                "\nДата рождения: " + birthDate +
                "\nАдрес: " + address +
                "\nПоследнее изменение: " + changeTime.format(formatter) +
                "\nКонтактные номера: " + phoneNumbers;
    }
}