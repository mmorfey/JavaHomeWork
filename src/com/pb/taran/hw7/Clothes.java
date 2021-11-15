package com.pb.taran.hw7;

//абстрактный класс
public abstract class Clothes {

    protected String name;
    protected Size size;
    protected int cost;
    protected String color;

    protected Clothes(String name, Size size, int cost, String color) {
        this.name = name;
        this.size = size;
        this.cost = cost;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("размер: %s (%d, %s), цвет: %s, цена: %d$",
                size, size.getEuroSize(), size.getDescription(), color, cost);
    }
}
