package com.example.hsezoo.services;

import com.example.hsezoo.model.animal.Animal;
import com.example.hsezoo.service.VeterinaryClinic;
import com.example.hsezoo.service.Zoo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZooTest {
    @Mock
    private VeterinaryClinic veterinaryClinic;

    private Zoo zoo;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        zoo = new Zoo(veterinaryClinic);
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void testCreateAnimal() throws NoSuchFieldException, IllegalAccessException {
        try {
            zoo.createAnimal("Wolf");
        } catch (Exception e) {
            verify(veterinaryClinic, times(1)).validateAnimal(any(Animal.class));
        }

        Field privateAnimals = Zoo.class.getDeclaredField("animals");
        privateAnimals.setAccessible(true);

        Object fieldValue = privateAnimals.get(zoo);
        assertEquals(fieldValue.getClass(), ArrayList.class);
    }

    @Test
    public void testCreateNamedAnimal() throws NoSuchFieldException, IllegalAccessException {
        for (int i = 0; i < 20; i++) {
            try {
                zoo.createNamedAnimal("Wolf", "Wolfie");
            } catch (Exception _) {}
        }

        Field privateAnimals = Zoo.class.getDeclaredField("animals");
        privateAnimals.setAccessible(true);

        Object fieldValue = privateAnimals.get(zoo);
        assertEquals(fieldValue.getClass(), ArrayList.class);
    }

    @Test
    public void testCreateNamedThing() throws NoSuchFieldException, IllegalAccessException {
        zoo.createNamedThing("Table", "Table1", "A table");


        Field privateAnimals = Zoo.class.getDeclaredField("things");
        privateAnimals.setAccessible(true);

        Object fieldValue = privateAnimals.get(zoo);
        assertEquals(fieldValue.getClass(), ArrayList.class);
    }

    @Test
    public void testCreateEmployee() throws NoSuchFieldException, IllegalAccessException {
        zoo.createEmployee();

        Field privateAnimals = Zoo.class.getDeclaredField("employees");
        privateAnimals.setAccessible(true);

        Object fieldValue = privateAnimals.get(zoo);
        assertEquals(fieldValue.getClass(), ArrayList.class);
    }

    @Test
    public void testPrintAnimalById() {
        for (int i = 0; i < 20; i++) {
            try {
                zoo.createNamedAnimal("Wolf", "Wolfie");
            } catch (Exception _) {}
        }

        System.setOut(new PrintStream(outContent));

        zoo.printAnimalById(1, 1);

        assertEquals('C', outContent.toString().charAt(0));
    }

    @Test
    public void testPrintThingById() {
        for (int i = 0; i < 20; i++) {
            zoo.createNamedThing("Table", "Table1", "A table");
        }

        System.setOut(new PrintStream(outContent));

        zoo.printThingById(1, 1);

        assertEquals('|', outContent.toString().charAt(0));
    }

    @Test
    public void testEmployeesRollCall() {
        for (int i = 0; i < 20; i++) {
            zoo.createEmployee();
        }

        zoo.employeesRollCall();

        assertEquals('E', outContent.toString().charAt(0));
    }

    @Test
    public void testPrintAllAnimals() {
        for (int i = 0; i < 20; i++) {
            try {
                zoo.createNamedAnimal("Wolf", "Wolfie");
            } catch (Exception _) {}
        }

        System.setOut(new PrintStream(outContent));

        zoo.printAllAnimals(1);

        assertEquals('C', outContent.toString().charAt(0));
    }

    @Test
    public void testPrintFriendlyAnimals() {
        for (int i = 0; i < 20; i++) {
            try {
                zoo.createNamedAnimal("Rabbit", "Wolfie");
            } catch (Exception _) {}
        }

        System.setOut(new PrintStream(outContent));

        zoo.printFriendlyAnimals(1);

        assertEquals('C', outContent.toString().charAt(0));
    }

    @Test
    public void testPrintAllThings() {
        for (int i = 0; i < 20; i++) {
            zoo.createNamedThing("Table", "Table1", "A table");
        }

        System.setOut(new PrintStream(outContent));

        zoo.printAllThings(1);

        assertEquals('|', outContent.toString().charAt(0));
    }

    @Test
    public void testFeedAll() {
        for (int i = 0; i < 20; i++) {
            try {
                zoo.createNamedAnimal("Rabbit", "Wolfie");
            } catch (Exception _) {}
        }

        zoo.feedAll();

        assert(countLines(outContent.toString()) > 0);
    }

    @Test
    public void testFeedAnimals() {
        for (int i = 0; i < 20; i++) {
            try {
                zoo.createNamedAnimal("Rabbit", "Wolfie");
            } catch (Exception _) {}
        }

        zoo.feedAnimals();

        assert(countLines(outContent.toString()) > 0);
    }

    @Test
    public void testFeedEmployees() {
        for (int i = 0; i < 20; i++) {
            zoo.createEmployee();
        }

        zoo.feedEmployees();

        assert(countLines(outContent.toString()) > 0);
    }

    @Test
    public void testPrintAnimalsOfSpecies() {
        for (int i = 0; i < 20; i++) {
            try {
                zoo.createNamedAnimal("Wolf", "Wolfie");
            } catch (Exception _) {}
        }

        System.setOut(new PrintStream(outContent));

        zoo.printAnimalsOfSpecies("Wolf", 1);

        assertEquals('C', outContent.toString().charAt(0));
    }

    @Test
    public void testPrintThingsOfCategory() {
        for (int i = 0; i < 20; i++) {
            zoo.createNamedThing("Table", "Table1", "A table");
        }

        zoo.printThingsOfCategory("Table", 1);

        assertEquals('|', outContent.toString().charAt(0));
    }

    @AfterEach
    public void restoreStreams() {
        // Восстанавливаем стандартный поток вывода
        System.setOut(originalOut);
    }

    private int countLines(String payload) {
        int count = 0;
        for (int i = 0; i < payload.length(); i++) {
            if (payload.charAt(i) == '\n') {
                count++;
            }
        }
        return count;
    }
}
