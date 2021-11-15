package com.pb.taran.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {

    public Tshirt(String name, Size size, int cost, String color) {
        super(name, size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("мужская " + name + ", " + this);
    }

    @Override
    public void dressWomen() {
        System.out.println("женская " + name + ", " + this);
    }
}
