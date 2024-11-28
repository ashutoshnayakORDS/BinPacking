package entities;

// inheritance classes for items
public class Item1D extends Item {

    private int length;

    public Item1D(String id, double weight, int length) {
        super(id, weight);
        this.length = length;
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
