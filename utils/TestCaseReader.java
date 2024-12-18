package utils;

import entities.Bin3D;
import entities.Item3D;
import entities.TestCase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestCaseReader {

    /**
     * Reads test cases from a file and parses them into a list of TestCase<Bin3D, Item3D>.
     *
     * @param inputFile Path to the input file.
     * @return List of TestCase objects containing bins and items.
     * @throws IOException If an error occurs while reading the file.
     */
    public static List<TestCase<Bin3D, Item3D>> readTestCases(String inputFile) throws IOException {
        List<TestCase<Bin3D, Item3D>> testCases = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        String line;
        String testName = null;
        int binWidth = 0, binHeight = 0, binLength = 0;
        List<Bin3D> bins = new ArrayList<>();
        List<Item3D> items = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            line = line.trim();

            // Detect test type and bin dimensions
            if (line.startsWith("---- Test Type")) {
                // Extract everything after the first colon
                String[] mainParts = line.split(":");
                String typeAndDims = mainParts[2].trim(); // The part after the second ":"
            
                // Split bin dimensions
                String[] dims = typeAndDims.split(" ");
                binWidth = Integer.parseInt(dims[0]);
                binHeight = Integer.parseInt(dims[1]);
                binLength = Integer.parseInt(dims[2]);
            }

            // Detect a new test case header
            else if (line.startsWith("Test")) {
                if (testName != null) {
                    // Add the previous test case
                    bins.add(new Bin3D("Bin-1", binLength, binWidth, binHeight));
                    testCases.add(new TestCase<>("3D", testName, new ArrayList<>(bins), new ArrayList<>(items)));
                    bins.clear();
                    items.clear();
                }

                // Parse the test name
                testName = line.split("\\(")[0].trim();
            }

            // Parse item lines
            else if (line.startsWith("Item-Item3D")) {
                String[] parts = line.split(":")[1].replaceAll("[\\[\\]]", "").split(",");
                int width = Integer.parseInt(parts[0].split("=")[1].trim());
                int height = Integer.parseInt(parts[1].split("=")[1].trim());
                int length = Integer.parseInt(parts[2].split("=")[1].trim());
                float weight = 1.0f;

                String id = line.split(":")[0].trim().replace("Item-", "");
                items.add(new Item3D(id, weight, length, width, height));
            }
        }

        // Add the last test case if it exists
        if (testName != null) {
            bins.add(new Bin3D("Bin-1", binLength, binWidth, binHeight));
            testCases.add(new TestCase<>("3D", testName, new ArrayList<>(bins), new ArrayList<>(items)));
        }

        reader.close();
        return testCases;
    }
}
