package entities;

// inheritance classes for items
public class Item2D extends Item {

    private int width;

    public Item2D(String id, double weight, int length, int width) {
        super(id, weight, length);
        this.width = width;
    }

    @Override
    public double getVolume() {
        return super.getLength() * width;
    }

    // Getters
    public int getWidth() {
        return width;
    }

}
