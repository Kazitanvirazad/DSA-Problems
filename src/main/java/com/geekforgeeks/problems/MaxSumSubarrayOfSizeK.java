package com.geekforgeeks.problems;

/**
 * Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.
 *
 * Note: A subarray is a contiguous part of any given array.
 *
 * Examples:
 *
 * Input: arr[] = [100, 200, 300, 400] , k = 2
 * Output: 700
 * Explanation: arr3  + arr4 = 700, which is maximum.
 * Input: arr[] = [100, 200, 300, 400] , k = 4
 * Output: 1000
 * Explanation: arr1 + arr2 + arr3 + arr4 = 1000, which is maximum.
 * Input: arr[] = [100, 200, 300, 400] , k = 1
 * Output: 400
 * Explanation: arr4 = 400, which is maximum.
 * Constraints:
 * 1 <= arr.size() <= 106
 * 1 <= arr[i]<= 106
 * 1 <= k<= arr.size()
 */
public class MaxSumSubarrayOfSizeK {
    public int maximumSumSubarray(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
            right++;
        }

        if (arr.length == k) {
            return maxSum;
        }

        int tempSum = maxSum;
        tempSum -= arr[left++];
        tempSum += arr[right];

        maxSum = Math.max(tempSum, maxSum);

        while (right < arr.length - 1) {
            tempSum = (tempSum - arr[left]) + arr[right + 1];
            maxSum = Math.max(maxSum, tempSum);
            left++;
            right++;
        }
        return maxSum;
    }
}
