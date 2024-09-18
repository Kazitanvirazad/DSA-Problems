package com.geekforgeeks.problems;

import java.util.Arrays;

/**
 * Given an array arr[] denoting heights of N towers and a positive integer K.
 * <p>
 * For each tower, you must perform exactly one of the following operations exactly once.
 * <p>
 * Increase the height of the tower by K
 * Decrease the height of the tower by K
 * Find out the minimum possible difference between the height of the shortest and tallest towers
 * after you have modified each tower.
 * <p>
 * You can find a slight modification of the problem here.
 * Note: It is compulsory to increase or decrease the height by K for each tower. After the operation,
 * the resultant array should not contain any negative integers.
 * <p>
 * Examples :
 * <p>
 * Input: k = 2, arr[] = {1, 5, 8, 10}
 * Output: 5
 * Explanation: The array can be modified as {1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}.The difference between
 * the largest and the smallest is 8-3 = 5.
 * Input: k = 3, arr[] = {3, 9, 12, 16, 20}
 * Output: 11
 * Explanation: The array can be modified as {3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}.The difference
 * between the largest and the smallest is 17-6 = 11.
 * Expected Time Complexity: O(n*logn)
 * Expected Auxiliary Space: O(n)
 */
public class MinimizeTheHeights {
    public static void main(String[] args) {
//        int[] arr = {1, 5, 8, 10};
//        int[] arr = {1, 8, 10, 6, 4, 6, 9, 1};
        int[] arr = {8, 1, 5, 4, 7, 5, 7, 9, 4, 6};
//        int k = 2;
        int k = 5;
//        int k = 7;
        System.out.println(getMinDiff(arr, k));
    }

    public static int getMinDiff(int[] arr, int k) {
        if (arr.length == 1) {
            return 0;
        }

        Arrays.sort(arr);

        int ans = arr[arr.length - 1] - arr[0];

        int minHeight = arr[0];
        int maxHeight = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - k < 0) {
                continue;
            }

            minHeight = Math.min(arr[0] + k, arr[i] - k);

            maxHeight = Math.max(arr[arr.length - 1] - k, arr[i - 1] + k);

            ans = Math.min(ans, maxHeight - minHeight);
        }
        return ans;
    }
}
