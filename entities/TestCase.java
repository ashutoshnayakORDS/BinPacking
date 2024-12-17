package entities;

import java.util.List;

public class TestCase<B extends Bin<?>, I extends Item> {
    private String binType;
    private String name;
    private List<B> bins;
    private List<I> items;

    public TestCase(String binType, String name, List<B> bins, List<I> items) {
        this.binType = binType;
        this.name = name;
        this.bins = bins;
        this.items = items;
    }

    // Getters
    public String getBinType() {
        return binType;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBins() {
        return bins.size();
    }

    public int getNumberOfItems() {
        return items.size();
    }

    public List<B> getBins() {
        return bins;
    }

    public List<I> getItems() {
        return items;
    }

    // Optional setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setBins(List<B> bins) {
        this.bins = bins;
    }

    public void setItems(List<I> items) {
        this.items = items;
    }
}
