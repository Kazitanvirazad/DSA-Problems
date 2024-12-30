package com.geekforgeeks.problems;

import java.util.Arrays;

/**
 * Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such that
 * elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 *
 * Examples:
 *
 * Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
 * Output: 6
 * Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest
 * consecutive subsequence.
 * Input: arr[] = [1, 9, 3, 10, 4, 20, 2]
 * Output: 4
 * Explanation: 1, 2, 3, 4 is the longest consecutive subsequence.
 * Input: arr[] = [15, 13, 12, 14, 11, 10, 9]
 * Output: 7
 * Explanation: The longest consecutive subsequence is 9, 10, 11, 12, 13, 14, 15, which has a length of 7.
 * Constraints:
 * 1 <= arr.size() <= 105
 * 0 <= arr[i] <= 105
 */
public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        LongestConsecutiveSubsequence subsequence = new LongestConsecutiveSubsequence();
        int[] arr1 = {2, 6, 1, 9, 4, 5, 3};
        int[] arr2 = {1, 9, 3, 10, 4, 20, 2};
        int[] arr3 = {15, 13, 12, 14, 11, 10, 9};
        int[] arr4 = {2, 5, 7, 9, 15, 22};
        int[] arr5 = {99, 80, 60, 33, 44, 86, 34, 64, 77, 18, 39, 3, 27, 16, 29, 60, 67, 23, 7, 87, 6, 75, 92, 11, 59, 13, 88, 24, 98, 4, 26, 6};
        int[] arr6 = {53, 57, 77, 15, 78, 58, 17, 63, 90, 73, 68, 82, 40, 68, 22, 52, 81, 92, 80, 37, 62, 17, 76, 67, 55, 56, 20, 22, 37, 71, 65, 7, 30, 93, 1, 1, 90, 46, 36, 74, 0, 37, 76, 69, 39, 97, 39, 30, 14, 89, 74, 71, 27, 79, 51, 45, 51, 54, 90, 35, 68, 38, 7, 82, 55, 65, 14, 40, 20, 64, 89, 95, 8, 43, 14, 88, 5, 24, 72, 9, 56, 17, 60, 91, 16, 94, 47, 15, 33};
        System.out.println(subsequence.longestConsecutive(arr1));
    }

    public int longestConsecutive(int[] arr) {
        Arrays.sort(arr);
        int prevElement = arr[0];
        int longestConsecutiveSubsequence = 1;
        int tempConsecutiveSubsequence = 1;
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            if (current == prevElement) {
                continue;
            }
            if (current == prevElement + 1) {
                tempConsecutiveSubsequence++;
            } else {
                tempConsecutiveSubsequence = 1;
            }
            prevElement = current;
            if (tempConsecutiveSubsequence > longestConsecutiveSubsequence) {
                longestConsecutiveSubsequence = tempConsecutiveSubsequence;
            }
        }
        return longestConsecutiveSubsequence;
    }
}
