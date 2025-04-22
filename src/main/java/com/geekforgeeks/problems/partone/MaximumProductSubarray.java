package com.geekforgeeks.problems.partone;

/**
 * Given an array arr[] that contains positive and negative integers (may contain 0 as well).
 * Find the maximum product that we can get in a subarray of arr.
 *
 * Note: It is guaranteed that the output fits in a 32-bit integer.
 *
 * Examples
 *
 * Input: arr[] = [-2, 6, -3, -10, 0, 2]
 * Output: 180
 * Explanation: The subarray with maximum product is {6, -3, -10} with product = 6 * (-3) * (-10) = 180.
 * Input: arr[] = [-1, -3, -10, 0, 60]
 * Output: 60
 * Explanation: The subarray with maximum product is {60}.
 * Input: arr[] = [2, 3, 4]
 * Output: 24
 * Explanation: For an array with all positive elements, the result is product of all elements.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] arr) {
        int maxProduct = arr[0];
        int left = 1;
        int right = 1;

        for (int i = 0; i < arr.length; i++) {
            if (left == 0) {
                left = 1;
            }
            if (right == 0) {
                right = 1;
            }
            left = arr[i] * left;
            right = arr[arr.length - i - 1] * right;

            maxProduct = Math.max(maxProduct, Math.max(left, right));
        }
        return maxProduct;
    }
}
