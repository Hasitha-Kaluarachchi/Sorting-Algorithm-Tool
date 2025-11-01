package SortingAlgorithmTool;

public class QuickSort {
    // Count how many comparisons or swaps happen
    public long steps = 0;
    public long timeTaken = 0;
    /**
     * Public method to start sorting the array.
     * It also records the start and end time to measure performance.
     */
    public void sort(int[] arr) {
        long start = System.nanoTime(); // Start measuring time
        quickSort(arr, 0, arr.length - 1); // Call recursive quicksort
        timeTaken = System.nanoTime() - start; // Calculate time taken
    }

    private void quickSort(int[] arr, int low, int high) {
        
        if (low < high) {
            int pivotIndex = partition(arr, low, high);// Partition the array and get the pivot index
            quickSort(arr, low, pivotIndex - 1);// Recursively sort the elements before and after partition
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the last element as pivot
        int i = low - 1; // Pointer for the smaller element group

        // Traverse through all elements and compare each with pivot
        for (int j = low; j < high; j++) {

            steps++; 
            if (arr[j] < pivot) {
                i++; 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1]; // Place the pivot element in the correct position
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1; // Return the index of the pivot element after sorting

    }
}
