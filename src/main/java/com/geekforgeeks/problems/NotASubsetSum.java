package com.geekforgeeks.problems;

/**
 * Given a sorted array arr[] of positive integers, find the smallest positive integer such that it cannot be represented
 * as the sum of elements of any subset of the given array set.
 *
 * Examples:
 *
 * Input: arr[] = [1, 2, 3]
 * Output: 7
 * Explanation: 7 is the smallest positive number for which no subset is there with sum 7.
 * Input: arr[] = [3, 6, 9, 10, 20, 28]
 * Output: 1
 * Explanation: 1 is the smallest positive number for which no subset is there with sum 1.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class NotASubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 5, 5, 6, 6, 6, 11, 11, 15, 17};
        NotASubsetSum notASubsetSum = new NotASubsetSum();
        System.out.println(notASubsetSum.findSmallest(arr));
    }

    public long findSmallest(int[] arr) {
        long smallestNonSubsetSum = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > smallestNonSubsetSum) {
                return smallestNonSubsetSum;
            } else {
                smallestNonSubsetSum += arr[i];
            }
        }
        return smallestNonSubsetSum;
    }
}
