package utils;

import entities.*;
import java.util.List;

public class TestCase {
    private String name;
    private int numberOfBins;
    private int numberOfItems;
    private List<Bin> bins;
    private List<Item> items;

    public TestCase(String name, int numberOfBins, int numberOfItems, List<Bin> bins, List<Item> items) {
        this.name = name;
        this.numberOfBins = numberOfBins;
        this.numberOfItems = numberOfItems;
        this.bins = bins;
        this.items = items;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getNumberOfBins() {
        return numberOfBins;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public List<Bin> getBins() {
        return bins;
    }

    public List<Item> getItems() {
        return items;
    }

    // Optional setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfBins(int numberOfBins) {
        this.numberOfBins = numberOfBins;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setBins(List<Bin> bins) {
        this.bins = bins;
    }
}