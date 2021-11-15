package com.pb.taran.hw7;

public class Atelier {

    public static void main(String[] args) {

        Clothes[] clothes = new Clothes[4];

        clothes[0] = new Tshirt("футболка", Size.XXS, 10, "black");
        clothes[1] = new Pants("штаны", Size.L, 14, "orange");
        clothes[2] = new Skirt("юбка", Size.S, 11, "yellow");
        clothes[3] = new Tie("галстук", Size.XS, 12, "blue");

        System.out.println("Перечень одежды");
        System.out.println("---------------");
        System.out.println();
        dressMan(clothes);
        System.out.println();
        dressWomen(clothes);

    }

    static void dressMan(Clothes[] clothes) {
        for (Clothes clothe : clothes) {
            if (clothe instanceof ManClothes) {
                ((ManClothes) clothe).dressMan();
            }
        }
    }

    static void dressWomen(Clothes[] clothes) {
        for (Clothes clothe : clothes) {
            if (clothe instanceof WomenClothes) {
                ((WomenClothes) clothe).dressWomen();
            }
        }
    }
}