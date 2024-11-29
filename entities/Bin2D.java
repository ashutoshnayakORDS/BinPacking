package entities;

public class Bin2D extends Bin<Item2D> {
    private int width;

    public Bin2D(String id, int length, int width) {
        super(id, length);
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
