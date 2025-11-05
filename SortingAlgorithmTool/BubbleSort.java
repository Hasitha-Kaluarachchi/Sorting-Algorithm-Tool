package SortingAlgorithmTool;

public class BubbleSort {

    // Variable to keep track of the number of steps (comparisons or swaps)
    public static int stepCount = 0;

    public static void bubbleSort(int[] arr) {
        stepCount = 0;  // Reset step count before sorting
        int n = arr.length;  // Get the number of elements in the array

        for (int i = 0; i < n - 1; i++) { // Outer loop - runs from the first to the second-last element
            for (int j = 0; j < n - i - 1; j++) {   // Inner loop - compares adjacent elements
                stepCount++;  
                if (arr[j] > arr[j + 1]) {    // Swap if elements are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}