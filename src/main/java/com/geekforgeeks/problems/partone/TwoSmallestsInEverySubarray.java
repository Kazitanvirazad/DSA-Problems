package com.geekforgeeks.problems.partone;

import java.util.PriorityQueue;

/**
 * Given an array of integers arr, the task is to find and return the maximum sum of the smallest and
 * second smallest element among all possible subarrays of size greater than one. If it is not possible, then return -1.
 *
 * Examples:
 *
 * Input: arr = [4, 3, 1, 5, 6]
 * Output: 11
 * Explanation: Subarrays with smallest and second smallest are,
 * Subarray: [4, 3], smallest = 3, second smallest = 4, sum = 7
 * Subarray: [4, 3, 1], smallest = 1, second smallest = 3, sum = 4
 * Subarray: [4, 3, 1, 5], smallest = 1, second smallest = 3, sum = 4
 * Subarray: [4, 3, 1, 5, 6], smallest = 1, second smallest = 3, sum = 4
 * Subarray: [3, 1], smallest = 1, second smallest = 3, sum = 4
 * Subarray: [3, 1, 5], smallest = 1, second smallest = 3, sum = 4
 * Subarray: [3, 1, 5, 6], smallest = 1, second smallest = 3, sum = 4
 * Subarray: [1, 5], smallest = 1, second smallest = 5, sum = 6
 * Subarray: [1, 5, 6] ,smallest = 1, second smallest = 5, sum = 6
 * Subarray: [5, 6], smallest = 5, second smallest = 6, sum = 11
 * Maximum sum among all above choices is, 5 + 6 = 11, hence the answer is 11.
 * Input: arr = [1]
 * Output: -1
 * Explanation: Here the size of array is 1, but we need minimum 2 elements. Hence, the answer is -1.
 * Expected Time Complexity: O(n)
 * Expected Space Complexity: O(1)
 */
public class TwoSmallestsInEverySubarray {
    public int pairWithMaxSum(int[] arr) {
        if (arr.length == 1) {
            return -1;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < arr.length - 1; i++) {
            maxHeap.add(arr[i] + arr[i + 1]);
        }
        return !maxHeap.isEmpty() ? maxHeap.peek() : -1;
    }
}
