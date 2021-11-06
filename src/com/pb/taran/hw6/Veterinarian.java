package com.pb.taran.hw6;

public class Veterinarian {
    private String name;
    private int animalsTreated;

    public Veterinarian(String name, int animalsTreated) {
        this.name = name;
        this.animalsTreated = animalsTreated;
    }

    public String getName() {
        return name;
    }

    public void treatAnimal(Animal animal) {
        System.out.println();
        System.out.print("Пациент №" + (animalsTreated + 1) + " - ");

        if (animal instanceof Cat) {
            System.out.println("кошка");
            Cat cat = (Cat) animal;
            cat.sleep();
        }
        else
        if (animal instanceof Dog) {
            System.out.println("собака");
            Dog dog = (Dog) animal;
            dog.makeNoise();
        }
        else
        if (animal instanceof Horse)  {
            System.out.println("лошадь");
            Horse horse = (Horse) animal;
            horse.eat();
        }
        else {
            System.out.println("что ты?!");
            animal.makeNoise();
        }
        System.out.println("Любимая еда - " + animal.getFood() +
                ", место жительства - " + animal.getLocation());
        animalsTreated++;
    }

}
