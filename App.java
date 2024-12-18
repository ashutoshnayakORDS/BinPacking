import java.util.ArrayList;
import java.util.List;

import entities.*;
import utils.TestCaseGenerator3D;

public class App {
    public static void main(String[] args) {

        String outputFile = "3dbpp_testcases.txt";

        // Generate all 320 test cases
        TestCaseGenerator3D.generateAllTestCases(outputFile);

        List<TestCase<? extends Bin<?>, ? extends Item>> testCases = new ArrayList<>();

        String name = "TestCase";

        // 3D Test Case
        List<Bin3D> bins3D = new ArrayList<>();
        List<Item3D> items3D = new ArrayList<>();

        // Add 2 bins
        bins3D.add(new Bin3D("Bin3D-1", 10, 5, 6));
        bins3D.add(new Bin3D("Bin3D-2", 8, 4, 5));

        // Add 3 items
        items3D.add(new Item3D("Item3D-1", 1.0, 2, 3, 4));
        items3D.add(new Item3D("Item3D-2", 1.0, 4, 2, 3));
        items3D.add(new Item3D("Item3D-3", 1.0, 3, 3, 3));

        // Create and add 3D test case
        testCases.add(new TestCase<>("3D", name, bins3D, items3D));

        // // 2D Test Case
        // List<Bin2D> bins2D = new ArrayList<>();
        // List<Item2D> items2D = new ArrayList<>();

        // // Add 2 bins
        // bins2D.add(new Bin2D("Bin2D-1", 10, 5));
        // bins2D.add(new Bin2D("Bin2D-2", 8, 4));

        // // Add 3 items
        // items2D.add(new Item2D("Item2D-1", 1.0, 2, 3));
        // items2D.add(new Item2D("Item2D-2", 1.0, 4, 2));
        // items2D.add(new Item2D("Item2D-3", 1.0, 5, 1));

        // // Create and add 2D test case
        // testCases.add(new TestCase<>("2D", name, bins2D, items2D));
            

        // Confirm test cases created
        System.out.println("Total Test Cases Created: " + testCases.size());
        System.out.println("First Test Case Type: " + testCases.get(0).getName());
    }
}
