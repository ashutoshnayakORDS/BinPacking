package utils;

import entities.Item3D;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestCaseGenerator3D {

    private static final int[] ITEM_COUNTS = {50, 100, 150, 200}; // Values of n
    private static final int TESTS_PER_TYPE = 10; // 10 tests for each type
    private static final int NUM_TYPES = 8; // Types 1 to 8
    private static final Random random = new Random();

    /**
     * Generates all 320 test cases and writes them to a file.
     *
     * @param outputFile Path to the output file.
     */
    public static void generateAllTestCases(String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("==== 3D Bin Packing Problem Test Cases ====\n\n");

            // For each value of n (item count)
            for (int n : ITEM_COUNTS) {
                writer.write(String.format("==== Number of Items: %d ====\n", n));

                // For each type (1 to 8)
                for (int type = 1; type <= NUM_TYPES; type++) {
                    int BL, BW, BH;
                    switch (type) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            BW = BH = BL = 100; // Cases 1-5: Bin dimensions are all 100
                            break;
                        case 6:
                            BW = BH = BL = 10; // Case 6: Bin dimensions are all 10
                            break;
                        case 7:
                            BW = BH = BL = 40; // Case 7: Bin dimensions are all 40
                            break;
                        case 8:
                            BW = BH = BL = 100; // Case 8: Bin dimensions are all 100
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid case: " + type);
                    }


                    writer.write(String.format("---- Test Type: %d : %d %d %d ----\n", type, BW, BH, BL));
                    

                    // Generate 10 test cases for each type
                    for (int test = 1; test <= TESTS_PER_TYPE; test++) {
                        writer.write(String.format("Test %d (Type %d, n=%d)\n",
                                test, type, n));

                        List<Item3D> items = new ArrayList<>();

                        // Generate items
                        for (int i = 1; i <= n; i++) {
                            items.add(generateRandomItem(i, type, BL, BW, BH));
                        }

                        // Write items to file
                        for (Item3D item : items) {
                            writer.write(String.format("Item-%s: [W=%d, H=%d, L=%d]\n",
                                item.getId(), item.getWidth(), item.getHeight(), item.getLength()));

                        }
                        writer.write("\n");
                    }
                }
            }

            System.out.println("All 320 test cases successfully written to: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing test cases: " + e.getMessage());
        }
    }

    /**
     * Generates a random 3D item based on the type rules.
     *
     * @param id   Item ID.
     * @param bdim Bin dimension.
     * @param type Type of instance.
     * @return Item3D object.
     */

     private static Item3D generateRandomItem(int id, int type, int BL, int BW, int BH) {
        int w = 1, h = 1, l = 1;
    
        switch (type) {
            // Martello-Vigo Types (1-5)
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                BL = BW = BH = 100;
    
                // Generate based on probability
                double probability = Math.random();
    
                if (probability < 0.6) { // 60% chance: Use dimensions from the current case
                    switch (type) {
                        case 1:
                            w = getRandom(1, BW / 2);
                            h = getRandom(2 * BH / 3, BH);
                            l = getRandom(2 * BL / 3, BL);
                            break;
                        case 2:
                            w = getRandom(2 * BW / 3, BW);
                            h = getRandom(1, BH / 2);
                            l = getRandom(2 * BL / 3, BL);
                            break;
                        case 3:
                            w = getRandom(2 * BW / 3, BW);
                            h = getRandom(2 * BH / 3, BH);
                            l = getRandom(1, BL / 2);
                            break;
                        case 4:
                            w = getRandom(BW / 2, BW);
                            h = getRandom(BH / 2, BH);
                            l = getRandom(BL / 2, BL);
                            break;
                        case 5:
                            w = getRandom(1, BW / 2);
                            h = getRandom(1, BH / 2);
                            l = getRandom(1, BL / 2);
                            break;
                    }
                } else { // 10% chance each for one of the other 4 cases
                    int subType;
                    do {
                        subType = (int) (Math.random() * 5) + 1; // Randomly pick a case 1-5
                    } while (subType == type); // Ensure it's a different case
    
                    switch (subType) {
                        case 1:
                            w = getRandom(1, BW / 2);
                            h = getRandom(2 * BH / 3, BH);
                            l = getRandom(2 * BL / 3, BL);
                            break;
                        case 2:
                            w = getRandom(2 * BW / 3, BW);
                            h = getRandom(1, BH / 2);
                            l = getRandom(2 * BL / 3, BL);
                            break;
                        case 3:
                            w = getRandom(2 * BW / 3, BW);
                            h = getRandom(2 * BH / 3, BH);
                            l = getRandom(1, BL / 2);
                            break;
                        case 4:
                            w = getRandom(BW / 2, BW);
                            h = getRandom(BH / 2, BH);
                            l = getRandom(BL / 2, BL);
                            break;
                        case 5:
                            w = getRandom(1, BW / 2);
                            h = getRandom(1, BH / 2);
                            l = getRandom(1, BL / 2);
                            break;
                    }
                }
                break;
    
            // Berkey-Wang Types (6-8) remain unchanged
            case 6:
                BL = BW = BH = 10;
                w = getRandom(1, 10);
                h = getRandom(1, 10);
                l = getRandom(1, 10);
                break;
            case 7:
                BL = BW = BH = 40;
                w = getRandom(1, 35);
                h = getRandom(1, 35);
                l = getRandom(1, 35);
                break;
            case 8:
                BL = BW = BH = 100;
                w = getRandom(1, 100);
                h = getRandom(1, 100);
                l = getRandom(1, 100);
                break;
        }
    
        return new Item3D("Item3D-" + id, 1.0f, w, h, l);
    }
    
    /**
     * Generates a random integer between min and max (inclusive).
     */
    private static int getRandom(int min, int max) {
        System.out.println(max-min);
        return random.nextInt((max - min + 1)) + min;
    }
}
