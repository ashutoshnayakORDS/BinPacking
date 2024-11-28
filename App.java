import java.util.ArrayList;
import java.util.List;

import utils.TestCase;
import entities.*;

public class App {
    public static void main(String[] args) {
        List<TestCase> testCases = new ArrayList<>();

        // loop to get the test cases
        for (int tc = 0; tc < 10; tc++) {
            String name = "TestCase" + (tc + 1);
            List<Bin> bins = new ArrayList<>();
            List<Item> items = new ArrayList<>();

            // loop to get the bins
            bins.add(new Bin("Bin" + 1, 10, 5, 6));

            // loop to get the items for packing
            items.add(new Item("Item" + 1, 2, 3, 4));
            items.add(new Item("Item" + 2, 4, 2, 5));

            testCases.add(new TestCase(name, bins.size(), items.size(), bins, items));
        }

        System.out.print("first java");
    }
}