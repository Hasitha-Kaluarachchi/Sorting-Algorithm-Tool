package SortingAlgorithmTool;

public class MergeSort {

    // count how many steps the algorithm performs

    private static long steps;

    // Main method to start sorting and return the total step count

    public static long sort(int[] arr) {
        steps = 0;  // Reset step count before sorting
        mergeSort(arr, 0, arr.length - 1); 
        return steps;  // Return how many steps were done
    }

    // Recursive function to divide the array into halves

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; // Find the middle point
            mergeSort(arr, left, mid);     // Sort the left half
            mergeSort(arr, mid + 1, right); // Sort the right half
            merge(arr, left, mid, right);  // Merge the two sorted halves
        }
    }

    // Function to merge two halves of the array
    
    private static void merge(int[] arr, int left, int mid, int right) {
        // Find sizes of the two subarrays to merge
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays for left and right halves
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // Merge the temporary arrays back into arr[]
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            steps++; // Count every comparison between two elements
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}