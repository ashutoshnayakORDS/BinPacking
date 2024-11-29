package entities;

public class Bin3D extends Bin<Item3D> {
    private int width;
    private int height;

    // Constructor for Bin3D
    public Bin3D(String id, int length, int width, int height) {
        super(id, length); // Call the Bin constructor
        this.width = width;
        this.height = height;
    }

    // Override getVolume to calculate 3D volume
    @Override
    public double getVolume() {
        return super.getLength() * width * height; // length * width * height
    }

    // Getter for width
    public int getWidth() {
        return width;
    }

    // Getter for height
    public int getHeight() {
        return height;
    }
}