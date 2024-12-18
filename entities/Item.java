package entities;

public abstract class Item {
    private String id;
    private float weight;
    private int length;

    public Item(String id, float weight, int length) {
        this.id = id;
        this.weight = weight;
        this.length = length;
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public int getLength() {
        return length;
    }

    public abstract double getVolume();
}