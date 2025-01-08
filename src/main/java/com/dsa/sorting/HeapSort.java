package com.dsa.sorting;

public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;
        // heapify the unsorted array
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // swap with root element and heapify till the i'th index
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    /* Max Heap */
    private void heapify(int[] arr, int index, int n) {
        int largest = index;
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        // setting largest to left child index if it's greater than it's parent
        if (leftChildIndex < n && arr[leftChildIndex] > arr[largest]) {
            largest = leftChildIndex;
        }

        // setting largest to right child index if it's greater than it's parent
        if (rightChildIndex < n && arr[rightChildIndex] > arr[largest]) {
            largest = rightChildIndex;
        }

        // No need to swap as the current index is the larger than it's children
        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;

            // recursively heapify the tree till the leaf
            heapify(arr, largest, n);
        }
    }

    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }
}
