package com.geekforgeeks.problems.partone;

/**
 *Given an array of integers. Find the Inversion Count in the array.  Two elements arr[i] and arr[j] form
 * an inversion if arr[i] > arr[j] and i < j.
 *
 * Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted.
 * If the array is already sorted then the inversion count is 0.
 * If an array is sorted in the reverse order then the inversion count is the maximum.
 *
 * Examples:
 *
 * Input: arr[] = {2, 4, 1, 3, 5}
 * Output: 3
 * Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 * Input: arr[] = {2, 3, 4, 5, 6}
 * Output: 0
 * Explanation: As the sequence is already sorted so there is no inversion count.
 * Input: arr[] = {10, 10, 10}
 * Output: 0
 * Explanation: As all the elements of array are same, so there is no inversion count.
 * Expected Time Complexity: O(n*logn).
 * Expected Auxiliary Space: O(n).
 */
public class CountInversion {
    public static void main(String[] args) {
        long[] arr = {2, 4, 1, 6, 3, 5};
        System.out.println(inversionCount(arr));
    }

    public static long inversionCount(long[] arr) {
        mergeSort(arr, 0, arr.length);
        long res = inversionCounter;
        inversionCounter = 0;
        return res;
    }

    static long inversionCounter = 0;

    public static void mergeSort(long[] arr, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    public static void merge(long[] arr, int start, int mid, int end) {
        if (arr[mid - 1] <= arr[mid]) {
            return;
        }

        int tempIndex = 0;
        long[] tempArray = new long[end - start];
        int i = start, j = mid;

        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                tempArray[tempIndex++] = arr[i++];
            } else {
                int k = mid - i;
                inversionCounter += k;
                tempArray[tempIndex++] = arr[j++];
            }
        }

        while (true) {
            if (i < mid) {
                tempArray[tempIndex++] = arr[i++];
            } else if (j < end) {
                tempArray[tempIndex++] = arr[j++];
            } else {
                break;
            }
        }
        System.arraycopy(tempArray, 0, arr, start, end - start);
    }
}
