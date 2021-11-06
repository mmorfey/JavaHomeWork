package com.pb.taran.hw6;

import java.lang.reflect.Constructor;

public class VetСlinic {

    public static void main(String[] args) throws Exception {
        Animal[] animalsToTreat = new Animal[6];
        animalsToTreat[0] = new Cat("рыба", "комната", 15);
        animalsToTreat[1] = new Cat("консерва", "улица", 13);

        animalsToTreat[2] = new Dog("мясо", "загородный дом", "Гггав");
        animalsToTreat[3] = new Dog("сухой корм", "квартира", "тяв");

        animalsToTreat[4] = new Horse("овёс", "ранчо", 30);

        animalsToTreat[5] = new Animal("люди", "лес");

        Class<?> doctorClazz = Class.forName("com.pb.taran.hw6.Veterinarian");
        Constructor<?> newDoctor = doctorClazz.getConstructor(String.class, int.class);
        Object doctor1 = newDoctor.newInstance("Айболит", 0);

        if (doctor1 instanceof Veterinarian) {
            Veterinarian veterinarian1 = (Veterinarian) doctor1;

            System.out.println();
            System.out.println("Прием у врача по имени " + veterinarian1.getName());

            for (Animal nextAnimal: animalsToTreat) {
                veterinarian1.treatAnimal(nextAnimal);
            }
        }
    }
}
