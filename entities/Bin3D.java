package entities;

public class Bin3D extends Bin {
    private int length;

    public Bin3D(String id) {
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
