package com.example.hsezoo.service;

import com.example.hsezoo.interfaces.IAlive;
import com.example.hsezoo.model.Employee;
import com.example.hsezoo.model.animal.*;
import com.example.hsezoo.model.thing.Computer;
import com.example.hsezoo.model.thing.Table;
import com.example.hsezoo.model.thing.Thing;
import com.example.hsezoo.utils.Utils;

import java.util.ArrayList;
import java.util.function.Function;

public class Zoo {
    VeterinaryClinic veterinaryClinic;
    ArrayList<Animal> animals;
    ArrayList<Thing> things;
    ArrayList<Employee> employees;

    public Zoo(VeterinaryClinic veterinaryClinic) {
        this.veterinaryClinic = veterinaryClinic;
        this.animals = new ArrayList<>();
        this.things = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public int createNamedAnimal(String species, String name) {
        Animal animal = switch (species) {
            case "Zebra" -> new Zebra(name);
            case "Tiger" -> new Tiger(name);
            case "Rabbit" -> new Rabbit(name);
            case "Wolf" -> new Wolf(name);
            default -> throw new IllegalArgumentException("Unknown species: " + species);
        };
        addAnimal(animal);
        return animal.getInventoryId();
    }

    public int createAnimal(String species) {
        return createNamedAnimal(species, Utils.getRandomAnimalName());
    }

    public int createNamedThing(String category, String name, String description) {
        Thing thing = switch (category) {
            case "Table" -> new Table(name, description);
            case "Computer" -> new Computer(name, description);
            default -> throw new IllegalArgumentException("Unknown category: " + category);
        };
        addThing(thing);
        return thing.getInventoryId();
    }

    public void createEmployee() {
        Employee employee = new Employee();
        addEmployee(employee);
    }

    private void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added to the zoo: " + employee.getName());
    }

    public void printAnimalById(int id, int rowLength) {
        printAnimalTable(rowLength, animal -> animal.getInventoryId() == id);
    }

    public void printThingById(int id, int rowLength) {
        printThingTable(rowLength, thing -> thing.getInventoryId() == id);
    }

    public void employeesRollCall() {
        for (Employee employee : employees) {
            System.out.println(employee.introduce());
        }
    }

    public void printAllAnimals(int rowLength) {
        printAnimalTable(rowLength, animal -> true);
    }

    public void printFriendlyAnimals(int rowLength) {
        printAnimalTable(rowLength, Animal::isKind);
    }

    public void printAnimalsOfSpecies(String species, int rowLength) {
        printAnimalTable(rowLength, animal -> animal.getSpecies().equals(species));
    }

    public void printAllThings(int rowLength) {
        printThingTable(rowLength, thing -> true);
    }

    public void printThingsOfCategory(String category, int rowLength) {
        printThingTable(rowLength, thing -> thing.getCategory().equals(category));
    }

    public void feedAll() {
        feed(alive -> true);
    }

    public void feedAnimals() {
        feed(alive -> alive instanceof Animal);
    }

    public void feedEmployees() {
        feed(alive -> alive instanceof Employee);
    }

    public void zooActions() {
        for (Animal animal : animals) {
            if (animal instanceof ICarnivore carnivore) {
                carnivore.play();
            } else if (animal instanceof IHerbivore herbivore) {
                herbivore.glaze();
            }
        }
    }

    private void addThing(Thing thing) {
        things.add(thing);
    }

    private void addAnimal(Animal animal) {
        System.out.println("Checking animal health...");
        if (veterinaryClinic.validateAnimal(animal)) {
            System.out.println("Animal is healthy! :) Welcome to our zoo, " + animal.getName() + "!");
            animals.add(animal);
        } else {
            throw new RuntimeException("Animal is unhealthy :( Come later, everything is going to be okay!");
        }
    }

    private void feed(Function<IAlive, Boolean> predicate) {
        for (Employee employee : employees) {
            if (predicate.apply(employee)) {
                employee.eat(100);
            }
        }
        for (Animal animal : animals) {
            if (predicate.apply(animal)) {
                animal.eat(100);
            }
        }
    }

    private void printAnimalTable(int rowLength, Function<Animal, Boolean> predicate) {
        if (!animals.isEmpty()) {
            System.out.println(animals.getFirst().buildTableHeaders(rowLength));
            for (Animal animal : animals) {
                if (predicate.apply(animal)) {
                    System.out.println(animal.serialize(rowLength));
                }
            }
        } else {
            System.out.println("No animals in the zoo");
        }
    }

    private void printThingTable(int rowLength, Function<Thing, Boolean> predicate) {
        if (!things.isEmpty()) {
            System.out.println(things.getFirst().buildTableHeaders(rowLength));
            for (Thing thing : things) {
                if (predicate.apply(thing)) {
                    System.out.println(thing.serialize(rowLength));
                }
            }
        } else {
            System.out.println("No things in the zoo");
        }
    }
}
