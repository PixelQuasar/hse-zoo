package com.example.hsezoo.model.animal;

public class Wolf extends Animal implements ICarnivore {
    public Wolf(String name) {
        super(name);
    }

    Wolf() {
       super();
    }

    @Override
    public final String getSpecies() {
        return "Wolf";
    }

    @Override
    public final AnimalSize getAnimalSize() {
        return AnimalSize.MEDIUM;
    }

    @Override
    public final void eat(int foodAmount) {
        if (foodAmount < getNeededFoodAmount()) {
            System.out.println("Wolf is hungry as a wolf!");
        } else {
            System.out.println("Wolf is greedily chewing on meat");
        }
    }

    @Override
    public final void play() {
        System.out.println("Wolf is playing");
    }
}
