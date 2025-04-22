package com.geekforgeeks.problems.parttwo;

/**
 * Given an unsorted array, Arr[] of size N and that contains even number of occurrences for all numbers except
 * two numbers. Find the two numbers in decreasing order which has odd occurrences.
 *
 * Example 1:
 *
 * Input:
 * N = 8
 * Arr = {4, 2, 4, 5, 2, 3, 3, 1}
 * Output: {5, 1}
 * Explanation: 5 and 1 have odd occurrences.
 *
 * Example 2:
 *
 * Input:
 * N = 8
 * Arr = {1 7 5 7 5 4 7 4}
 * Output: {7, 1}
 * Explanation: 7 and 1 have odd occurrences.
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function twoOddNum() which
 * takes the array Arr[] and its size N as input parameters and returns the two numbers in decreasing order
 * which have odd occurrences.
 *
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(1)
 *
 *
 * Constraints:
 * 2 ≤ N ≤ 106
 * 1 ≤ Arri ≤ 1012
 */
public class TwoNumbersWithOddOccurrences {
    public int[] twoOddNum(int[] Arr, int N) {
        int xorVal = 0;
        for (int i : Arr) {
            xorVal ^= i;
        }

        xorVal &= -xorVal;
        int[] res = new int[2];

        for (int num : Arr) {
            if ((num & xorVal) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        if (res[0] < res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        return res;
    }
}
