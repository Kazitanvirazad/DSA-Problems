package com.geekforgeeks.problems.partone;

/**
 * Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array(In Place).
 * In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....
 * If there are multiple solutions, find the lexicographically smallest one.
 *
 * Note: The given array is sorted in ascending order, and you don't need to return anything to change the original array.
 *
 * Examples:
 *
 * Input: n = 5, arr[] = {1,2,3,4,5}
 * Output: 2 1 4 3 5
 * Explanation: Array elements after sorting it in the waveform are 2 1 4 3 5.
 * Input: n = 6, arr[] = {2,4,7,8,9,10}
 * Output: 4 2 8 7 10 9
 * Explanation: Array elements after sorting it in the waveform are 4 2 8 7 10 9.
 * Expected Time Complexity: O(n).
 * Expected Auxiliary Space: O(1).
 */
public class WaveArray {
    public static void convertToWave(int n, int[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (index == arr.length - 1) {
                break;
            }
            int temp = arr[index];
            arr[index] = arr[index + 1];
            arr[index + 1] = temp;

            index += 2;
        }
    }
}
