package com.dsa.sorting;

public class MergeSort {

    public void mergeSort(int[] input) {
        mergeSort(input, 0, input.length);
    }

    private void mergeSort(int[] input, int start, int end) {
        // recursion break condition
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        // split left part of the array
        mergeSort(input, start, mid);
        // split right part of the array
        mergeSort(input, mid, end);

        // merge and sort the divided arrays
        merge(input, start, mid, end);
    }

    private void merge(int[] input, int start, int mid, int end) {
        // if the last element of the left array lesser than first element of right array
        // then we can confirm that both arrays together are sorted and no merge required
        if (input[mid - 1] <= input[mid]) {
            return;
        }
        int i = start;
        int j = mid;

        int[] tempArray = new int[end - start];
        int tempIndex = 0;

        while (i < mid && j < end) {
            tempArray[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // copying the remaining elements from either left or right array to the tempArray
        while (true) {
            if (i < mid) {
                tempArray[tempIndex++] = input[i++];
            } else if (j < end) {
                tempArray[tempIndex++] = input[j++];
            } else {
                break;
            }
        }

        // copying tempArray to the original array
        System.arraycopy(tempArray, 0, input, start, end - start);
    }
}
