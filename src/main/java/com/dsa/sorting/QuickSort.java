package com.dsa.sorting;

public class QuickSort {
    public void sort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    private void quickSort(int[] input, int start, int end) {
        // Recursion break condition
        if (end <= start) {
            return;
        }

        int partitionIndex = getPartitionIndex(input, start, end);

        // split left array
        quickSort(input, start, partitionIndex - 1);
        // split right array
        quickSort(input, partitionIndex + 1, end);
    }

    private int getPartitionIndex(int[] input, int start, int end) {
        int j = start, i = j - 1;

        int partition = input[end];

        while (j <= end) {
            if (input[j] <= partition) {
                i++;
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
            j++;
        }

        return i;
    }
}
