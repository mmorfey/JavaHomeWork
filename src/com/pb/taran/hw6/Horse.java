package com.pb.taran.hw6;

import java.util.Objects;

public class Horse extends Animal {
    private int maxSpeed;

    public Horse(String food, String location, int maxSpeed) {
        super(food, location);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void makeNoise() {
        System.out.println("Лошадь фыркает");
    }

    @Override
    public void eat() {
        System.out.println("Для достижения максимальной скорости в " + maxSpeed + " км/ч лошадь много кушает");
    }

    @Override
    public String toString() {
        return "У лошади любимая еда: " + food + ", место жительства: " + location +
                ", максимальная скорость: " + maxSpeed + " км/ч";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null || getClass() != obj.getClass()) { return false; }
        Horse anotherHorse = (Horse) obj;
        return food.equals(anotherHorse.food) &&
                location.equals(anotherHorse.location) &&
                maxSpeed == anotherHorse.maxSpeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, location, maxSpeed);
    }
}
