package com.example.hsezoo.model.thing;

import com.example.hsezoo.config.AppConfig;
import com.example.hsezoo.interfaces.IInventory;
import com.example.hsezoo.utils.Utils;

public abstract class Thing implements IInventory {
    private final int inventoryId;
    private final String name;
    private final String description;

    public Thing(String name, String description) {
        inventoryId = Utils.getRandomInventoryId();
        this.name = name;
        this.description = description;
    }

    public abstract String getCategory();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public final String buildTableHeaders(int rowLength) {
        int columnWidth = rowLength / AppConfig.THING_VISIBLE_PROPERTIES;

        String idColumn = Utils.formatValue("ID", columnWidth);
        String nameColumn = Utils.formatValue("Name", columnWidth);
        String descriptionColumn = Utils.formatValue("Description", columnWidth);

        return String.format("|%s|%s|%s|",
                idColumn, nameColumn, descriptionColumn
        );
    }

    @Override
    public final String serialize(int rowLength) {
        int columnWidth = rowLength / AppConfig.THING_VISIBLE_PROPERTIES;

        String idColumn = Utils.formatValue(String.valueOf(getInventoryId()), columnWidth);
        String nameColumn = Utils.formatValue(getName(), columnWidth);
        String descriptionColumn = Utils.formatValue(getDescription(), columnWidth);

        return String.format("|%s|%s|%s|",
                idColumn, nameColumn, descriptionColumn
        );
    }

    @Override
    public int getInventoryId() {
        return inventoryId;
    }
}
