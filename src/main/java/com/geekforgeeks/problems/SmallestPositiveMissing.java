package com.geekforgeeks.problems;

import java.util.PriorityQueue;

/**
 * You are given an array arr[] of N integers. The task is to find the smallest positive number
 * missing from the array.
 *
 * Note: Positive number starts from 1.
 *
 * Example 1:
 *
 * Input:
 * N = 5
 * arr[] = {1,2,3,4,5}
 * Output: 6
 * Explanation: Smallest positive missing
 * number is 6.
 * Example 2:
 *
 * Input:
 * N = 5
 * arr[] = {0,-10,1,3,-20}
 * Output: 2
 * Explanation: Smallest positive missing
 * number is 2.
 * Your Task:
 * The task is to complete the function missingNumber() which returns the smallest positive missing number
 * in the array.
 *
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(1).
 */
public class SmallestPositiveMissing {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {0, -10, 1, 3, -20};
        System.out.println(missingNumber(arr1, arr1.length));
        System.out.println(missingNumber(arr2, arr2.length));
    }

    public static int missingNumber(int arr[], int size) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                minHeap.add(arr[i]);
            }
        }

        if (minHeap.isEmpty() || minHeap.peek() != 1) {
            return 1;
        }

        int top = minHeap.poll();

        int lastElement = top;
        while (!minHeap.isEmpty()) {
            int current = minHeap.poll();
            if (current - lastElement > 1) {
                return ++lastElement;
            }
            lastElement = current;
        }

        return ++lastElement;
    }
}
