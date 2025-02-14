package com.example.hsezoo.model.animal;

public class Zebra extends Animal implements IHerbivore {
    public Zebra(String name) {
        super(name);
    }

    Zebra() {
        super();
    }

    @Override
    public final void glaze() {
        System.out.println("Zebra is glazing");
    }

    @Override
    public final String getSpecies() {
        return "Zebra";
    }

    @Override
    public final AnimalSize getAnimalSize() {
        return AnimalSize.LARGE;
    }

    @Override
    public final void eat(int foodAmount) {
        if (foodAmount < getNeededFoodAmount()) {
            System.out.println("Zebra is hungry");
        } else {
            System.out.println("Zebra is peacefully nibbles grass");
        }
    }
}
