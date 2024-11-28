package entities;

import java.util.ArrayList;
import java.util.List;

// based on how the person can move, decide width and depth
public class Bin {
    private String id;
    private int height;
    private int width;
    private int depth;
    private List<Item> items;

    public Bin(String id, int height, int width, int depth) {
        this.id = id;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.items = new ArrayList<>();
    }

    // Getters
    public String getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public List<Item> getItems() {
        return items;
    }
}
