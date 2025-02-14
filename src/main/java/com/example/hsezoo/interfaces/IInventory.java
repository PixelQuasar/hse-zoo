package com.example.hsezoo.interfaces;

public interface IInventory {
    int getInventoryId();

    String buildTableHeaders(int rowLength);

    String serialize(int rowLength);
}
