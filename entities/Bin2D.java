package entities;

public class Bin2D extends Bin {
    private int length;

    public Bin2D(String id) {
        super(id);
    }

    @Override
    public double getVolume() {
        return length;
    }

    // Getters
    public int getLength() {
        return length;
    }
}
