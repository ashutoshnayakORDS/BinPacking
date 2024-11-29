package entities;

// inheritance classes for items
public class Item3D extends Item2D {

    private int height;

    public Item3D(String id, double weight, int length, int width, int height) {
        super(id, weight, length, width);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return super.getLength() * super.getWidth() * height;
    }

    // Getters
    public int getHeight() {
        return height;
    }

}
