package com.pb.taran.hw7;

public class Tie extends Clothes implements ManClothes {

    public Tie(String name, Size size, int cost, String color) {
        super(name, size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("мужской " + name + ", " + this);
    }
}
