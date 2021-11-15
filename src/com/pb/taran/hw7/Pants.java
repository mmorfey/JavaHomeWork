package com.pb.taran.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {

    public Pants(String name, Size size, int cost, String color) {
        super(name, size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("мужские " + name + ", " + this);
    }

    @Override
    public void dressWomen() {
        System.out.println("женские " + name + ", " + this);
    }
}
