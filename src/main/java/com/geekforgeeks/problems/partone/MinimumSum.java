package com.geekforgeeks.problems.partone;

import java.util.Arrays;

/**
 * Given an array arr[] such that each element is in the range [0 - 9], find the minimum possible sum of
 * two numbers formed using the elements of the array. All digits in the given array must be used to form
 * the two numbers. Return a string without leading zeroes.
 *
 * Examples :
 *
 * Input: arr[] = [6, 8, 4, 5, 2, 3]
 * Output: 604
 * Explanation: The minimum sum is formed by numbers 358 and 246.
 * Input: arr[] = [5, 3, 0, 7, 4]
 * Output: 82
 * Explanation: The minimum sum is formed by numbers 35 and 047.
 * Input: arr[] = [9, 4]
 * Output: 13
 * Explanation: The minimum sum is formed by numbers 9 and 4.
 */
public class MinimumSum {
    public static void main(String[] args) {
        MinimumSum minimumSum = new MinimumSum();
        int[] arr1 = {6, 8, 4, 5, 2, 3};
        int[] arr2 = {5, 3, 0, 7, 4};
        int[] arr3 = {9, 4};
        int[] arr4 = {9};
        int[] arr5 = {2, 4, 3, 5, 0, 0, 0, 8, 2, 9, 2};
        System.out.println(minimumSum.minSum(arr1));
        System.out.println(minimumSum.minSum(arr2));
        System.out.println(minimumSum.minSum(arr3));
        System.out.println(minimumSum.minSum(arr4));
        System.out.println(minimumSum.minSum(arr5));
    }

    String minSum(int[] arr) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(arr);

        int indexOne = arr.length - 1;
        int indexTwo = arr.length - 2;

        int carry = 0;
        while (indexOne >= 0 || indexTwo >= 0) {
            int sum = carry;
            if (indexOne >= 0) {
                sum += arr[indexOne];
            }
            if (indexTwo >= 0) {
                sum += arr[indexTwo];
            }
            if (sum < 1) {
                indexOne -= 2;
                indexTwo -= 2;
                continue;
            }
            if (sum > 9) {
                result.insert(0, (sum % 10));
                carry = sum / 10;
            } else {
                result.insert(0, sum);
                carry = 0;
            }
            indexOne -= 2;
            indexTwo -= 2;
        }
        return carry > 0 ? result.insert(0, carry).toString() : result.toString();
    }
}
