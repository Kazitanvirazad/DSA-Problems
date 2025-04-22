package com.geekforgeeks.problems.partone;

/**
 * Given a number x and an array of integers arr, find the smallest subarray with sum greater than the given
 * value. If such a subarray do not exist return 0 in that case.
 *
 * Examples:
 *
 * Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
 * Output: 3
 * Explanation: Minimum length subarray is [4, 45, 6]
 * Input: x = 100, arr[] = [1, 10, 5, 2, 7]
 * Output: 0
 * Explanation: No subarray exist
 * Constraints:
 * 1 ≤ arr.size, x ≤ 105
 * 0 ≤ arr[] ≤ 104
 */
public class SmallestSubarrayWithSumGreaterThanX {
    public static void main(String[] args) {
        int[] sample1 = {100000, 99999, 0};
        int x1 = 5;
        System.out.println(smallestSubWithSum(x1, sample1));
    }

    public static int smallestSubWithSum(int x, int[] arr) {
        int left = 0;
        int right = 0;

        int tempSum = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < arr.length) {
            while (right < arr.length && tempSum <= x) {
                tempSum += arr[right++];
            }
            if (right == arr.length && tempSum <= x) {
                break;
            }
            while (left < right && tempSum - arr[left] > x) {
                tempSum -= arr[left++];
            }
            minLength = Math.min(minLength, right - left);

            tempSum -= arr[left++];
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
