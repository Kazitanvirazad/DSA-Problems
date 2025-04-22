package com.geekforgeeks.problems.partone;

import java.util.PriorityQueue;

/**
 * Given an array arr[], where each element is at most k away from its target position, you need to sort
 * the array optimally.
 * Note: You need to change the given array arr[] in place.
 *
 * Examples:
 *
 * Input: arr[] = [6, 5, 3, 2, 8, 10, 9], k = 3
 * Output: [2, 3, 5, 6, 8, 9, 10]
 * Explanation: The sorted array will be 2 3 5 6 8 9 10
 * Input: arr[]= [1, 4, 5, 2, 3, 6, 7, 8, 9, 10], k = 2
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * Explanation: The sorted array will be 1 2 3 4 5 6 7 8 9 10
 * DO NOT use the direct library sort() function for this question.
 */
public class NearlySorted {
    public static void main(String[] args) {
        int[] arr1 = {6, 5, 3, 2, 8, 10, 9};
        int k1 = 3;
        print(arr1);
        nearlySorted(arr1, k1);
        print(arr1);
        int[] arr2 = {1, 4, 5, 2, 3, 6, 7, 8, 9, 10};
        int k2 = 2;
        print(arr2);
        nearlySorted(arr2, k2);
        print(arr2);
    }

    public static void nearlySorted(int[] arr, int k) {
        if (k == 0) {
            return;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < Math.min(arr.length, k + 1); i++) {
            minHeap.add(arr[i]);
        }

        int index = 0;

        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }

        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }

    private static void print(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}
