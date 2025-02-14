package com.example.hsezoo.model.thing;

public class Computer extends Thing {
    public Computer(String name, String description) {
        super(name, description);
    }

    @Override
    public String getCategory() {
        return "Computer";
    }
}
