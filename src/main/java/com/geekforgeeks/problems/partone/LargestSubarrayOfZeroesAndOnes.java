package com.geekforgeeks.problems.partone;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.
 *
 * Examples:
 *
 * Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
 * Output: 6
 * Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.
 * Input: arr[] = [0, 0, 1, 1, 0]
 * Output: 4
 * Explnation: arr[0...3] or arr[1...4] is the longest subarray with two 0s and two 1s.
 * Input: arr[] = [0]
 * Output: 0
 * Explnation: There is no subarray with an equal number of 0s and 1s.
 * Constraints:
 * 1 <= arr.size() <= 105
 * 0 <= arr[i] <= 1
 */
public class LargestSubarrayOfZeroesAndOnes {
    public static void main(String[] args) {
        LargestSubarrayOfZeroesAndOnes zeroesAndOnes = new LargestSubarrayOfZeroesAndOnes();
        int[] arr1 = {0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0};
        System.out.println(zeroesAndOnes.maxLen(arr1));
    }

    public int maxLen(int[] arr) {
        int prefixSum = 0;
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i] == 0 ? -1 : 1;

            if (prefixSum == 0)
                res = i + 1;

            if (map.containsKey(prefixSum))
                res = Math.max(res, i - map.get(prefixSum));
            else
                map.put(prefixSum, i);
        }
        return res;
    }
}
