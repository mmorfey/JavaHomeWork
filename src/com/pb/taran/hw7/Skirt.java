package com.pb.taran.hw7;

public class Skirt extends Clothes implements WomenClothes {

    public Skirt(String name, Size size, int cost, String color) {
        super(name, size, cost, color);
    }

    @Override
    public void dressWomen() {
        System.out.println("женская " + name + ", " + this);
    }
}
