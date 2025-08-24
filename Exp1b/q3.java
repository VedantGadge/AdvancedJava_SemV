import java.util.Arrays;

interface SortStrategy {
    void sort(int[] array);
}

// Concrete strategy - Bubble Sort
class BubbleSort implements SortStrategy {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}

// Concrete strategy - Merge Sort
class MergeSort implements SortStrategy {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length < 2) return;
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] a, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }
        while (i <= mid) temp[k++] = a[i++];
        while (j <= right) temp[k++] = a[j++];
        System.arraycopy(temp, 0, a, left, temp.length);
    }
}

// Concrete strategy - Quick Sort
class QuickSort implements SortStrategy {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length < 2) return;
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
    }

    private int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        int tmp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = tmp;
        return i + 1;
    }
}

// Context that uses a SortStrategy
class Sorter {
    private SortStrategy strategy;

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] array) {
        if (strategy == null) throw new IllegalStateException("SortStrategy not set");
        strategy.sort(array);
    }
}

public class q3 {
    private static void printArray(String label, int[] a) {
        System.out.println(label + Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] original = {9, 3, 7, 1, 5, 4, 8, 2, 6, 0};

        // Prepare sorter and run each strategy
        Sorter sorter = new Sorter(new BubbleSort());

        int[] arr1 = Arrays.copyOf(original, original.length);
        printArray("Original:", arr1);
        sorter.setStrategy(new BubbleSort());
        sorter.sort(arr1);
        printArray("BubbleSorted:", arr1);

        int[] arr2 = Arrays.copyOf(original, original.length);
        sorter.setStrategy(new MergeSort());
        sorter.sort(arr2);
        printArray("MergeSorted:", arr2);

        int[] arr3 = Arrays.copyOf(original, original.length);
        sorter.setStrategy(new QuickSort());
        sorter.sort(arr3);
        printArray("QuickSorted:", arr3);
    }
}

