package com.geekforgeeks.problems;

/**
 * Given an array arr[] of integers, the task is to count the number of ways to split given array elements
 * into two non-empty subsets such that the XOR of elements of each group is equal.
 * Each element should belong to exactly one subset.
 * Note:
 *
 * The answer could be very large so print it by doing modulo with 109 + 7.
 * Subsets with the same elements but derived from different indices are different.
 * Examples:
 *
 * Input : arr[] = [1, 2, 3]
 * Output : 3
 * Explanation: {(1),(2, 3)}, {(2),(1, 3)}, {(3),(1, 2)} are three ways with equal XOR value of two groups.
 * Input : arr[] = [5, 2, 3, 2]
 * Output : 0
 * Explanation: No way to split into  two groups whose XOR is equal.
 * Input : arr[] = [2, 2, 2, 2]
 * Output : 7
 * Explanation: There are 7 ways to split the array into two groups with equal XOR, such that there are
 * multiple combinations of {(2), (2,2,2)},{(2,2),(2,2)}.
 */
public class SplitTheArray {
    public static int countgroup(int arr[]) {
        int xor = 0;
        int mod = 1000000007;

        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        if (xor == 0) {
            return ((1 << (arr.length - 1)) - 1) % mod;
        }

        return 0;
    }
}
