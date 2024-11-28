package entities;

// inheritance classes for items
public class Item3D extends Item {

    private int length;
    private int width;
    private int height;

    public Item3D(String id, double weight, int length, int width, int height) {
        super(id, weight);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return length * width * height;
    }

    // Getters
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
