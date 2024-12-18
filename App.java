import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.*;
// import utils.TestCaseGenerator3D;
import utils.TestCaseReader;

public class App {
    public static void main(String[] args) {

        // Generate all 320 test cases
        // String outputFile = "3dbpp_testcases.txt";
        // TestCaseGenerator3D.generateAllTestCases(outputFile);

        String inputFile = "3dbpp_testcases.txt"; // Path to the input file
        List<TestCase<Bin3D, Item3D>> testCases = new ArrayList<>();
        try {
            // Step 1: Read test cases from the input file
            testCases = TestCaseReader.readTestCases(inputFile);

            // Step 2: Iterate through test cases
            for (TestCase<Bin3D, Item3D> testCase : testCases) {
                // Step 3: Print Test Case Details
                System.out.println("Test Name: " + testCase.getName());
                Bin3D bin = testCase.getBins().get(0); // Assuming only one bin per test case
                System.out.println("Bin Dimensions: " + bin.getLength() + "x" + bin.getWidth() + "x" + bin.getHeight());
                System.out.println("Number of Items: " + testCase.getNumberOfItems());
                System.out.println("Items:");
                for (Item3D item : testCase.getItems()) {
                    System.out.println("  Item-" + item.getId() + ": [W=" + item.getWidth() +
                                       ", H=" + item.getHeight() + ", L=" + item.getLength() + "]");
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Error reading test cases: " + e.getMessage());
        }

        // Confirm test cases created
        System.out.println("Total Test Cases Created: " + testCases.size());
        System.out.println("First Test Case Type: " + testCases.get(0).getName());
    }
}
