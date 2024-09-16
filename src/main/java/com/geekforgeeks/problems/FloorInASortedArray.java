package com.geekforgeeks.problems;

/**
 * Given a sorted array arr[] of size n without duplicates, and given a value x. Floor of x is defined as
 * the largest element k in arr[] such that k is smaller than or equal to x. Find the index of k(0-based indexing).
 *
 * Examples
 *
 * Input: n = 7, x = 0 arr[] = {1,2,8,10,11,12,19}
 * Output: -1
 * Explanation: No element less than 0 is found. So output is "-1".
 * Input: n = 7, x = 5 arr[] = {1,2,8,10,11,12,19}
 * Output: 1
 * Explanation: Largest Number less than 5 is 2 (i.e k = 2), whose index is 1(0-based indexing).
 * Your Task:
 * The task is to complete the function findFloor() which returns an integer denoting the index value
 * of K or return -1 if there isn't any such number.
 *
 * Expected Time Complexity: O(log N).
 * Expected Auxiliary Space: O(1).
 */
public class FloorInASortedArray {
    public static int findFloor(long arr[], int n, long x) {
        if (arr[0] > x) {
            return -1;
        }
        if (arr[arr.length - 1] < x) {
            return arr.length - 1;
        }

        if (arr[0] == x) {
            return 0;
        }

        int lastElementIndex = 0;
        for (int i = 1; i < n; i++) {
            long current = arr[i];
            if (current == x) {
                return i;
            }
            if (current > x) {
                return lastElementIndex;
            }
            lastElementIndex++;
        }
        return -1;
    }
}
