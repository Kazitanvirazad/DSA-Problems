package com.geekforgeeks.problems;

/**
 * Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order without
 * using any extra space. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains
 * the last M elements.
 *
 * Example 1:
 *
 * Input:
 * n = 4, arr1[] = [1 3 5 7]
 * m = 5, arr2[] = [0 2 6 8 9]
 * Output:
 * arr1[] = [0 1 2 3]
 * arr2[] = [5 6 7 8 9]
 * Explanation:
 * After merging the two
 * non-decreasing arrays, we get,
 * 0 1 2 3 5 6 7 8 9.
 * Example 2:
 *
 * Input:
 * n = 2, arr1[] = [10 12]
 * m = 3, arr2[] = [5 18 20]
 * Output:
 * arr1[] = [5 10]
 * arr2[] = [12 18 20]
 * Explanation:
 * After merging two sorted arrays
 * we get 5 10 12 18 20.
 * Your Task:
 * You don't need to read input or print anything. You only need to complete the function merge() that
 * takes arr1, arr2, n and m as input parameters and modifies them in-place so that they look like the sorted merged
 * array when concatenated.
 *
 * Expected Time Complexity:  O((n+m) log(n+m))
 * Expected Auxilliary Space: O(1)
 */
public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
//        long[] arr1 = {1, 3, 5, 7};
//        long[] arr2 = {0, 2, 6, 8, 9};
        long[] arr1 = {10, 12};
        long[] arr2 = {5, 18, 20};
        merge(arr1, arr2, arr1.length, arr2.length);
        for (long i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (long i : arr2) {
            System.out.print(i + " ");
        }
    }

    public static void merge(long arr1[], long arr2[], int n, int m) {
        long[] tempArray = new long[m + n];
        int tempIndex = 0;

        int i = 0, j = 0;

        while (i < n && j < m) {
            tempArray[tempIndex++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
        }
        while (true) {
            if (i < n) {
                tempArray[tempIndex++] = arr1[i++];
            } else if (j < m) {
                tempArray[tempIndex++] = arr2[j++];
            } else {
                break;
            }
        }
        System.arraycopy(tempArray, 0, arr1, 0, n);
        System.arraycopy(tempArray, n, arr2, 0, m);
    }
}
