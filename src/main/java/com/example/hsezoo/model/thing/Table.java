package com.example.hsezoo.model.thing;

enum TableMaterial {
    WOOD, METAL, PLASTIC
}

public class Table extends Thing {
    public Table(String name, String description) {
        super(name, description);
    }

    @Override
    public String getCategory() {
        return "Table";
    }
}
