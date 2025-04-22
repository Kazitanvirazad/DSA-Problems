package com.geekforgeeks.problems.partone;

import java.util.ArrayList;

/**
 * Given an array arr of distinct integers. Rearrange the array in such a way that the first element
 * is the largest and the second element is the smallest, the third element is the second largest and
 * the fourth element is the second smallest, and so on.
 *
 * Examples:
 *
 * Input: arr[] = [7, 1, 2, 3, 4, 5, 6]
 * Output: [7, 1, 6, 2, 5, 3, 4]
 * Explanation: The first element is first maximum and second element is first minimum and so on.
 * Input: arr[] = [1, 6, 9, 4, 3, 7, 8, 2]
 * Output: [9, 1, 8, 2, 7, 3, 6, 4]
 * Explanation: The first element is first maximum and second element is first minimum and so on.
 * Expected Time Complexity: O(nlogn).
 * Expected Auxiliary Space: O(n).
 */
public class AlternativeSorting {
    public static ArrayList<Integer> alternateSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        ArrayList<Integer> list = new ArrayList<>();

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            if (start == end) {
                list.add(arr[start]);
                break;
            }
            list.add(arr[end--]);
            list.add(arr[start++]);
        }
        return list;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = getPivotIndex(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    private static int getPivotIndex(int[] arr, int start, int end) {
        int j = start;
        int i = j - 1;

        while (j <= end) {
            if (arr[j] <= arr[end]) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            j++;
        }
        return i;
    }
}
