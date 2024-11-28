package entities;

public abstract class Item {
    private String id;
    protected double weight;

    public Item(String id, double weight) {
        this.id = id;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String getId() {
        return id;
    }

    public abstract double getVolume();
}