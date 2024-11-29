package entities;

import java.util.ArrayList;
import java.util.List;

// based on how the person can move, decide width and depth
public abstract class Bin {
    private String id;
    private List<Item> items;

    public Bin(String id) {
        this.id = id;
        this.items = new ArrayList<>();
    }

    // Getters
    public String getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public abstract double getVolume();
}
