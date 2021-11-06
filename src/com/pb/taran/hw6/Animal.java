package com.pb.taran.hw6;

public class Animal {
    protected String food;
    protected String location;

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public void makeNoise() {
        System.out.println("Животное издаёт звук");
    }

    public void eat() {
        System.out.println("Животное кушает еду");
    }

    public void sleep() {
        System.out.println("Животное спит Zzz");
    }

//    @Override
//    public String toString() {
//        return species + ' ' + name;
//    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }
}
