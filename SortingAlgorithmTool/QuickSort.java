package SortingAlgorithmTool;

public class QuickSort {

    public long steps = 0;
    public long timeTaken = 0;

    public void sort(int[] arr) {

        long start = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        timeTaken = System.nanoTime() - start;

    }

    private void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);

        }
    }

    private int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            steps++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
