package com.example.hsezoo.services;

import com.example.hsezoo.service.Controller;
import com.example.hsezoo.service.Zoo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;

public class ControllerTest {
    @Mock
    private Zoo zooMock;

    private Controller controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        controller = new Controller(zooMock, 100);
    }

    @Test
    public void testStartAndExit() {
        String simulatedInput = "14\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        this.controller = new Controller(zooMock, 100);
        this.controller.start();

        assert(true);
    }

    @Test
    public void testCreateAnimal() {
        String simulatedInput = "1\nWolf\n14\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        this.controller = new Controller(zooMock, 100);
        this.controller.start();

        verify(zooMock, times(1)).createAnimal("Wolf");
    }

    @Test
    public void testCreateNamedAnimal() {
        String simulatedInput = "2\nWolf\nWolfie\n14\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        this.controller = new Controller(zooMock, 100);
        this.controller.start();

        verify(zooMock, times(1)).createNamedAnimal("Wolf", "Wolfie");
    }

    @Test
    public void testCreateThing() {
        String simulatedInput = "3\nTable\nTable1\ndescription\n14\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        this.controller = new Controller(zooMock, 100);
        this.controller.start();

        verify(zooMock, times(1)).createNamedThing("Table", "Table1", "description");
    }

    @Test
    public void testCreateEmployee() {
        String simulatedInput = "4\n14\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        this.controller = new Controller(zooMock, 100);
        this.controller.start();

        verify(zooMock, times(1)).createEmployee();
    }

    @Test
    public void testPrintAllAnimals() {
        String simulatedInput = "5\n14\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        this.controller = new Controller(zooMock, 100);
        this.controller.start();

        verify(zooMock, times(1)).printAllAnimals(100);
    }

    @Test
    public void testPrintFriendlyAnimals() {
        String simulatedInput = "7\n14\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        this.controller = new Controller(zooMock, 100);
        this.controller.start();

        verify(zooMock, times(1)).printFriendlyAnimals(100);
    }

    @Test
    public void testEmployeesRollCall() {
        String simulatedInput = "9\n14\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        this.controller = new Controller(zooMock, 100);
        this.controller.start();

        verify(zooMock, times(1)).employeesRollCall();
    }

    @Test
    public void testFeedAll() {
        String simulatedInput = "10\n14\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        this.controller = new Controller(zooMock, 100);
        this.controller.start();

        verify(zooMock, times(1)).feedAll();
    }

    @Test
    public void testFeedAnimals() {
        String simulatedInput = "11\n14\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        this.controller = new Controller(zooMock, 100);
        this.controller.start();

        verify(zooMock, times(1)).feedAnimals();
    }

    @Test
    public void testFeedEmployees() {
        String simulatedInput = "12\n14\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        this.controller = new Controller(zooMock, 100);
        this.controller.start();

        verify(zooMock, times(1)).feedEmployees();
    }

    @Test
    public void testZooActions() {
        String simulatedInput = "13\n14\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        this.controller = new Controller(zooMock, 100);
        this.controller.start();

        verify(zooMock, times(1)).zooActions();
    }

    @Test
    public void testInvalidInput() {
        String simulatedInput = "15\n14\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        this.controller = new Controller(zooMock, 100);
        this.controller.start();
    }
}
