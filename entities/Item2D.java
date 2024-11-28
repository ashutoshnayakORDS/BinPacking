package entities;

// inheritance classes for items
public class Item2D extends Item {

    private int length;
    private int width;

    public Item2D(String id, double weight, int height, int width, int depth) {
        super(id, weight);
        this.length = height;
        this.width = width;
    }

    @Override
    public double getVolume() {
        return length * width;
    }

    // Getters
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

}
