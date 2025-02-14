package com.example.hsezoo.model.animal;

public class Tiger extends Animal implements ICarnivore {
    public Tiger(String name) {
        super(name);
    }

    Tiger() {
        super();
    }

    @Override
    public final String getSpecies() {
        return "Tiger";
    }

    @Override
    public final AnimalSize getAnimalSize() {
        return AnimalSize.LARGE;
    }

    @Override
    public final void eat(int foodAmount) {
        if (foodAmount < getKindnessLevel()) {
            System.out.println("Tiger is hungry");
        } else {
            System.out.println("Tiger is graceful eating meat");
        }
    }

    @Override
    public final void play() {
        System.out.println("Tiger is playing");
    }
}
