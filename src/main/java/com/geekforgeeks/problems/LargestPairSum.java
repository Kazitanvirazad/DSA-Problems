package com.geekforgeeks.problems;

/**
 * Find the largest pair sum in an array of distinct integers.
 *
 * Examples :
 *
 * Input: arr[] = [12, 34, 10, 6, 40]
 * Output: 74
 * Explanation: Sum of 34 and 40 is the largest, i.e, 34 + 40 = 74.
 * Input: arr[] = [10, 20, 30]
 * Output: 50
 * Explanation: 20 + 30 = 50.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class LargestPairSum {

    public static int pairsum(int[] arr) {
        if (arr.length == 2) {
            return arr[0] + arr[1];
        }

        quickSort(arr, 0, arr.length - 1);

        return arr[arr.length - 1] + arr[arr.length - 2];
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivotElementIndex = getPivotElementIndex(arr, start, end);
        quickSort(arr, start, pivotElementIndex - 1);
        quickSort(arr, pivotElementIndex + 1, end);
    }

    private static int getPivotElementIndex(int[] arr, int start, int end) {
        int j = start, i = j - 1;

        while (j <= end) {
            if (arr[j] <= arr[end]) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        return i;
    }

}
