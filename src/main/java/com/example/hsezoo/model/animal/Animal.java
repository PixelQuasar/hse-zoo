package com.example.hsezoo.model.animal;

import com.example.hsezoo.config.AppConfig;
import com.example.hsezoo.interfaces.IAlive;
import com.example.hsezoo.interfaces.IInventory;
import com.example.hsezoo.utils.Utils;

public abstract class Animal implements IAlive, IInventory {
    private final int inventoryId;
    private final int kindnessLevel;
    private final String name;
    private final int health;
    private final int neededFoodAmount;

    Animal(String name) {
        this.inventoryId = Utils.getRandomInventoryId();
        this.kindnessLevel = Utils.genKindnessLevel(7, 2);
        this.health = Utils.getRandomHealth();
        this.name = name;
        this.neededFoodAmount = 1;
    }

    Animal() {
        this(Utils.getRandomAnimalName());
    }

    abstract public String getSpecies();

    abstract public AnimalSize getAnimalSize();

    public final int getKindnessLevel() {
        return kindnessLevel;
    }

    public final String getName() {
        return name;
    }

    public final int getHealth() {
        return health;
    }

    public final boolean isKind() {
        return getKindnessLevel() > AppConfig.MINIMAL_KINDNESS_LEVEL;
    }

    public final int getNeededFoodAmount() {
        return neededFoodAmount;
    }

    @Override
    public final int getInventoryId() {
        return inventoryId;
    }

    @Override
    public final String buildTableHeaders(int rowLength) {
        int columnWidth = rowLength / AppConfig.ANIMAL_VISIBLE_PROPERTIES;

        String idColumn = Utils.formatValue("ID", columnWidth);
        String speciesColumn = Utils.formatValue("Species", columnWidth);
        String nameColumn = Utils.formatValue("Name", columnWidth);
        String kindnessColumn = Utils.formatValue("Kindness", columnWidth);
        String isKindColumn = Utils.formatValue("Is Kind", columnWidth);
        String healthColumn = Utils.formatValue("Health", columnWidth);
        String sizeColumn = Utils.formatValue("Size", columnWidth);

        return String.format("|%s|%s|%s|%s|%s|%s|%s|",
                idColumn, speciesColumn, nameColumn, kindnessColumn, isKindColumn, healthColumn, sizeColumn
        );
    }

    @Override
    public final String serialize(int rowLength) {
        int columnWidth = rowLength / AppConfig.ANIMAL_VISIBLE_PROPERTIES;

        int id = getInventoryId();

        String name = getName();
        int kindnessLevel = getKindnessLevel();
        boolean isKind = isKind();
        String size = getAnimalSize().name();

        String idColumn = Utils.formatValue(String.valueOf(id), columnWidth);
        String speciesColumn = Utils.formatValue(getSpecies(), columnWidth);
        String nameColumn = Utils.formatValue(name, columnWidth);
        String kindnessColumn = Utils.formatValue(String.valueOf(kindnessLevel), columnWidth);
        String isKindColumn = Utils.formatValue(String.valueOf(isKind), columnWidth);
        String healthColumn = Utils.formatValue(String.valueOf(getHealth()), columnWidth);
        String sizeColumn = Utils.formatValue(size, columnWidth);

        return String.format("|%s|%s|%s|%s|%s|%s|%s|",
                idColumn, speciesColumn, nameColumn, kindnessColumn, isKindColumn, healthColumn, sizeColumn
        );
    }
}
