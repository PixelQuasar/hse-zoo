package com.example.hsezoo.model;

import com.example.hsezoo.interfaces.IAlive;
import com.example.hsezoo.utils.Utils;

public class Employee implements IAlive {
    private final String name;
    private final String jobTitle;
    private final int neededFoodAmount;


    public Employee() {
        name = Utils.getRandomHumanName();
        jobTitle = Utils.getRandomJobTitle();
        neededFoodAmount = 10;
    }

    @Override
    public void eat(int foodAmount) {
        if (foodAmount >= neededFoodAmount) {
            System.out.println("Employee is eating");
        } else {
            System.out.println("Employee is hungry! It's a worker exploitation!");
        }
    }

    public String getName() {
       return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public final String introduce() {
        return "Hello, my name is " + name + " and I am a " + jobTitle + ".";
    }
}
