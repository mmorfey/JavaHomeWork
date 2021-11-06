package com.pb.taran.hw6;

import java.util.Objects;

public class Cat extends Animal {
    private int sleepTime;

    public Cat(String food, String location, int sleepTime) {
        super(food, location);
        this.sleepTime = sleepTime;

    }

    @Override
    public void makeNoise() {
        System.out.println("Кошка мяукает");
    }

    @Override
    public void eat() {
        System.out.println("Кошка кушает рыбу");
    }

    @Override
    public String toString() {
        return "У кошки любимая еда: " + food + ", место жительства: " + location +
                ", продолжительность сна " + sleepTime + " часов";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null || getClass() != obj.getClass()) { return false; }
        Cat anotherCat = (Cat) obj;
        return food.equals(anotherCat.food) &&
                location.equals(anotherCat.location) &&
                sleepTime == anotherCat.sleepTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, location, sleepTime);
    }

}
