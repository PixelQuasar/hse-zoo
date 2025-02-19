package com.example.hsezoo.model.animal;

public class Rabbit extends Animal implements IHerbivore {
    public Rabbit(String name) {
        super(name);
    }

    Rabbit() {
        super();
    }

    @Override
    public final String getSpecies() {
        return "Rabbit";
    }

    @Override
    public final AnimalSize getAnimalSize() {
        return AnimalSize.LARGE;
    }

    @Override
    public final void eat(int foodAmount) {
        if (foodAmount < getNeededFoodAmount()) {
            System.out.println("Rabbit is hungry");
        } else {
            System.out.println("Rabbit is peacefully chewing grass");
        }
    }

    @Override
    public void glaze() {
        System.out.println("Rabbit is glazing");
    }
}
