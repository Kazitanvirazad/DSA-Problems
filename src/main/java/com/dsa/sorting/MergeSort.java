package com.dsa.sorting;

public class MergeSort {

    public void mergeSort(int[] arr) {

        //declaring the length of the original array
        int inputLength = arr.length;

        //checking the length of the array should be greater than 1 otherwise it is considered as already sorted
        if (inputLength >= 2) {
            int midIndex = inputLength / 2;

            //creating left array
            int[] leftArray = new int[midIndex];
            //creating right array
            int[] rightArray = new int[inputLength - midIndex];

            //populating elements into left array
            for (int i = 0; i < midIndex; i++) {
                leftArray[i] = arr[i];
            }

            //populating elements into right array
            for (int i = midIndex; i < inputLength; i++) {
                rightArray[i - midIndex] = arr[i];
            }

            //recursively divide left array
            mergeSort(leftArray);

            //recursively divide right array
            mergeSort(rightArray);

            //merge the sorted arrays
            merge(arr, leftArray, rightArray);
        }
    }

    private void merge(int[] arr, int[] leftArray, int[] rightArray) {

        //declaring size of left array
        int leftSize = leftArray.length;

        //declaring size of right array
        int rightSize = rightArray.length;

        //declaring iterating counts for leftArray i, rightArray j and originalArray k
        int i = 0, j = 0, k = 0;

        //comparing left and right array and adding the elements into the original array in sorted order
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //cleaning the left array with remaining elements by putting it into the original array
        while (i < leftSize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        //cleaning the right array with remaining elements by putting it into the original array
        while (j < rightSize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}
