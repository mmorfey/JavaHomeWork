package com.pb.taran.hw6;

import java.util.Objects;

public class Dog extends Animal {
    private String bark;

    public Dog(String food, String location, String bark) {
        super(food, location);
        this.bark = bark;

    }

    @Override
    public void makeNoise() {
        System.out.println("Собака лает: " + bark + "!!!");
    }

    @Override
    public void eat() {
        System.out.println("Собака кушает косточку");
    }

    @Override
    public String toString() {
        return "У собаки любимая еда: " + food + ", место жительства: " + location +
                ", звук лая: " + bark;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null || getClass() != obj.getClass()) { return false; }
        Dog anotherDog = (Dog) obj;
        return food.equals(anotherDog.food) &&
                location.equals(anotherDog.location) &&
                bark.equals(anotherDog.bark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, location, bark);
    }

}