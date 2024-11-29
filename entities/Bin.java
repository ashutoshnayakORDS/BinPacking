package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Bin<T extends Item> { // Use a generic type T constrained to Item
    private String id;
    private int length;
    private List<T> items;

    public Bin(String id, int length) {
        this.id = id;
        this.length = length;
        this.items = new ArrayList<>();
    }

    // Getters
    public String getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public List<T> getItems() {
        return items;
    }

    // Method to add an item
    public void addItem(T item) {
        items.add(item);
    }

    public abstract double getVolume();
}
