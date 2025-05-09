package com.geekforgeeks.problems.partone;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array arr[] containing integers and an integer k, your task is to find the length
 * of the longest subarray where the sum of its elements is equal to the given value k.
 * If there is no subarray with sum equal to k, return 0.
 *
 * Examples:
 *
 * Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
 * Output: 6
 * Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10].
 * The length of the longest subarray with a sum of 15 is 6.
 * Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
 * Output: 5
 * Explanation: Only subarray with sum = 15 is [-5, 8, -14, 2, 4] of length 5.
 * Input: arr[] = [10, -10, 20, 30], k = 5
 * Output: 0
 * Explanation: No subarray with sum = 5 is present in arr[].
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * -104 ≤ arr[i] ≤ 104
 * -109 ≤ k ≤ 109
 */
public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        LongestSubArrayWithSumK subArray = new LongestSubArrayWithSumK();
        int[] arr1 = {10, 5, 2, 7, 1, -10};
        int k1 = 15;
        int[] arr2 = {-5, 8, -14, 2, 4, 12};
        int k2 = -5;
        int[] arr3 = {10, -10, 20, 30};
        int k3 = 5;
        System.out.println(subArray.longestSubarray(arr2, k2));
    }

    public int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int length = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                length = i + 1;
            } else if (map.containsKey(sum - k)) {
                length = Math.max(length, i - map.get(sum - k));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return length;
    }
}
