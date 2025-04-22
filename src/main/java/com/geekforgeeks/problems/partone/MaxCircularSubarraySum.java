package com.geekforgeeks.problems.partone;

/**
 * Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get
 * if we assume the array to be circular.
 *
 * Examples:
 *
 * Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
 * Output: 22
 * Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion,
 * we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
 * Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
 * Output: 23
 * Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].
 * Input: arr[] = [-1, 40, -14, 7, 6, 5, -4, -1]
 * Output: 52
 * Explanation: Circular Subarray [7, 6, 5, -4, -1, -1, 40] has the maximum sum, which is 52.
 */
public class MaxCircularSubarraySum {
    public static void main(String[] args) {
        int[] arr1 = {8, -8, 9, -9, 10, -11, 12};
        int[] arr2 = {10, -3, -4, 7, 6, 5, -4, -1};
        int[] arr3 = {-1, 40, -14, 7, 6, 5, -4, -1};
        System.out.println(circularSubarraySum(arr1));
    }

    public static int circularSubarraySum(int[] arr) {
        int maxSum = arr[0];
        int currentMaxSum = 0;
        int minSum = arr[0];
        int currentMinSum = 0;
        int totalSum = 0;
        int index = 0;
        while (index < arr.length) {
            currentMaxSum = Math.max(arr[index] + currentMaxSum, arr[index]);
            maxSum = Math.max(currentMaxSum, maxSum);
            currentMinSum = Math.min(arr[index] + currentMinSum, arr[index]);
            minSum = Math.min(currentMinSum, minSum);
            totalSum += arr[index++];
        }

        int normalSum = maxSum;
        int circularSum = totalSum - minSum;

        if (minSum == totalSum) {
            return normalSum;
        }

        return Math.max(normalSum, circularSum);
    }
}
