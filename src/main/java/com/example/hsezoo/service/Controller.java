package com.example.hsezoo.service;

import java.util.Scanner;

enum UserMethod {
    ADD_ANIMAL,
    ADD_NAMED_ANIMAL,
    ADD_THING,
    ADD_EMPLOYEE,
    PRINT_ALL_ANIMALS,
    PRINT_ANIMAL_SPECIE,
    PRINT_FRIENDLY_ANIMALS,
    PRINT_ALL_THINGS,
    EMPLOYEES_ROLL_CALL,
    FEED_ALL,
    FEED_ANIMALS,
    FEED_EMPLOYEES,
    ZOO_ACTIONS,
    EXIT
}

public class Controller {
    final Zoo zoo;
    final int rowLength;
    boolean active;
    final Scanner scanner;

    public Controller(Zoo zoo, int rowLength) {
        this.zoo = zoo;
        this.rowLength = rowLength;
        active = false;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        active = true;
        while (active) {
            try {
                poll();
            } catch (Exception e) {
                System.out.println("Error has occurred: " + e.getMessage());
            }
        }
        System.out.println("Goodbye!");
    }

    private String pollMessage() {
        return "What would you like to do?\n" +
                "1. Add an animal\n" +
                "2. Add a named animal\n" +
                "3. Add a thing\n" +
                "4. Add an employee\n" +
                "5. Print all animals\n" +
                "6. Print animals of a specie\n" +
                "7. Print friendly animals\n" +
                "8. Print all things\n" +
                "9. Employees roll call\n" +
                "10. Feed all\n" +
                "11. Feed animals\n" +
                "12. Feed employees\n" +
                "13. Zoo actions\n" +
                "14. Exit";
    }

    private void poll() {
        System.out.println(pollMessage());
        int choice = scanner.nextInt();
        String species, name, description, category;
        int id;
        switch (UserMethod.values()[choice - 1]) {
            case ADD_ANIMAL:
                System.out.println("Enter the species of the animal");
                species = scanner.next();
                id = zoo.createAnimal(species);
                System.out.println("Animal added to the zoo with ID: " + id);
                break;
            case ADD_NAMED_ANIMAL:
                System.out.println("Enter the species of the animal");
                species = scanner.next();
                System.out.println("Enter the name of the animal");
                name = scanner.next();
                id = zoo.createNamedAnimal(species, name);
                System.out.println("Animal added to the zoo with ID: " + id);
                break;
            case ADD_THING:
                System.out.println("Enter the category of the thing");
                category = scanner.next();
                System.out.println("Enter the name of the thing");
                name = scanner.next();
                System.out.println("Enter the description of the thing");
                description = scanner.next();
                id = zoo.createNamedThing(category, name, description);
                System.out.println("Thing added to the zoo with ID: " + id);
                break;
            case ADD_EMPLOYEE:
                zoo.createEmployee();
                System.out.println("Employee added to the zoo: ");
                break;
            case PRINT_ALL_ANIMALS:
                zoo.printAllAnimals(rowLength);
                break;
            case PRINT_ANIMAL_SPECIE:
                System.out.println("Enter the species of the animal");
                species = scanner.next();
                zoo.printAnimalsOfSpecies(species, rowLength);
                break;
            case PRINT_FRIENDLY_ANIMALS:
                zoo.printFriendlyAnimals(rowLength);
                break;
            case PRINT_ALL_THINGS:
                zoo.printAllThings(rowLength);
                break;
            case EMPLOYEES_ROLL_CALL:
                zoo.employeesRollCall();
                break;
            case FEED_ALL:
                zoo.feedAll();
                break;
            case FEED_ANIMALS:
                zoo.feedAnimals();
                break;
            case FEED_EMPLOYEES:
                zoo.feedEmployees();
                break;
            case ZOO_ACTIONS:
                zoo.zooActions();
                break;
            default:
                active = false;
        }
    }
}
