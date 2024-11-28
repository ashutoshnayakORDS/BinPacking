package entities;

public class Item {
    private String id;
    private int height;
    private int width;
    private int depth;

    public Item(String id, int height, int width, int depth) {
        this.id = id;
        this.height = height;
        this.width = width;
        this.depth = depth;
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

}
