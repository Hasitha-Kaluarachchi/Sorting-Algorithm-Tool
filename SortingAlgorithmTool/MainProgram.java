package SortingAlgorithmTool;

import java.util.*;

public class MainProgram {
    private static int[] data = new int[0];
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms (performance table)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1 -> enterNumbers();
                case 2 -> generateRandomData();
                case 3 -> performBubbleSort();
                case 4 -> performMergeSort();
                case 5 -> performQuickSort();
                case 6 -> compareAllAlgorithms();
                case 7 -> {
                    System.out.println("Exiting program... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // --- Option 1: Manual input ---
    private static void enterNumbers() {
        sc.nextLine(); // clear input buffer
        System.out.print("Enter numbers separated by spaces: ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        data = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
        System.out.println("✅ Data successfully entered.");
    }

    // --- Option 2: Generate random numbers ---
    private static void generateRandomData() {
        System.out.print("Enter number of elements: ");
        int size = getIntInput();
        System.out.print("Enter maximum value: ");
        int max = getIntInput();

        Random rand = new Random();
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(max + 1);
        }
        System.out.println("✅ Random data generated: " + Arrays.toString(data));
    }

    // --- Option 3: Perform Bubble Sort ---
    private static void performBubbleSort() {
        checkData();
        int[] copy = Arrays.copyOf(data, data.length);
        long startTime = System.nanoTime();
        BubbleSort.bubbleSort(copy);
        long endTime = System.nanoTime();
        double timeTaken = (endTime - startTime) / 1_000_000.0;

        System.out.println("Sorted result: " + Arrays.toString(copy));
        System.out.println("Steps: " + BubbleSort.stepCount + " | Time: " + timeTaken + " ms");
    }

    // --- Option 4: Perform Merge Sort ---
    private static void performMergeSort() {
        checkData();
        int[] copy = Arrays.copyOf(data, data.length);
        long startTime = System.nanoTime();
        long steps = MergeSort.sort(copy);
        long endTime = System.nanoTime();
        double timeTaken = (endTime - startTime) / 1_000_000.0;

        System.out.println("Sorted result: " + Arrays.toString(copy));
        System.out.println("Steps: " + steps + " | Time: " + timeTaken + " ms");
    }

    // --- Option 5: Perform Quick Sort ---
    private static void performQuickSort() {
        checkData();
        int[] copy = Arrays.copyOf(data, data.length);
        QuickSort sorter = new QuickSort();
        sorter.sort(copy);

        double timeTaken = sorter.timeTaken / 1_000_000.0;
        System.out.println("Sorted result: " + Arrays.toString(copy));
        System.out.println("Steps: " + sorter.steps + " | Time: " + timeTaken + " ms");
    }

    // --- Option 6: Compare all algorithms ---
    private static void compareAllAlgorithms() {
        checkData();
        System.out.println("\n--- Algorithm Performance Comparison ---");
        System.out.printf("%-15s %-15s %-15s%n", "Algorithm", "Time (ms)", "Steps");

        // Bubble Sort
        int[] copy1 = Arrays.copyOf(data, data.length);
        long start1 = System.nanoTime();
        BubbleSort.bubbleSort(copy1);
        long end1 = System.nanoTime();
        double time1 = (end1 - start1) / 1_000_000.0;
        System.out.printf("%-15s %-15.3f %-15d%n", "Bubble Sort", time1, BubbleSort.stepCount);

        // Merge Sort
        int[] copy2 = Arrays.copyOf(data, data.length);
        long start2 = System.nanoTime();
        long steps2 = MergeSort.sort(copy2);
        long end2 = System.nanoTime();
        double time2 = (end2 - start2) / 1_000_000.0;
        System.out.printf("%-15s %-15.3f %-15d%n", "Merge Sort", time2, steps2);

        // Quick Sort
        int[] copy3 = Arrays.copyOf(data, data.length);
        QuickSort quickSorter = new QuickSort();
        quickSorter.sort(copy3);
        double time3 = quickSorter.timeTaken / 1_000_000.0;
        System.out.printf("%-15s %-15.3f %-15d%n", "Quick Sort", time3, quickSorter.steps);
    }

    // --- Utility methods ---
    private static void checkData() {
        if (data.length == 0) {
            System.out.println("⚠️ Please enter or generate data first!");
            throw new IllegalStateException("No data available.");
        }
    }

    private static int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }
}