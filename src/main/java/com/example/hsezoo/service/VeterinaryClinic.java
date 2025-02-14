package com.example.hsezoo.service;

import com.example.hsezoo.model.animal.Animal;

public class VeterinaryClinic {
    private final int healthThreshold;

    VeterinaryClinic(int healthThreshold) {
        this.healthThreshold = healthThreshold;
    }

    public boolean validateAnimal(Animal animal) {
        return animal.getHealth() > healthThreshold;
    }
}
