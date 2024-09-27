package com.geekforgeeks.problems;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given an array arr[] and an integer k. Find the maximum for each and every contiguous subarray of size k.
 *
 * Examples:
 *
 * Input: k = 3, arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6]
 * Output: [3, 3, 4, 5, 5, 5, 6]
 * Explanation:
 * 1st contiguous subarray = [1 2 3] max = 3
 * 2nd contiguous subarray = [2 3 1] max = 3
 * 3rd contiguous subarray = [3 1 4] max = 4
 * 4th contiguous subarray = [1 4 5] max = 5
 * 5th contiguous subarray = [4 5 2] max = 5
 * 6th contiguous subarray = [5 2 3] max = 5
 * 7th contiguous subarray = [2 3 6] max = 6
 *
 * Input: k = 4, arr[] = [8, 5, 10, 7, 9, 4, 15, 12, 90, 13]
 * Output: [10, 10, 10, 15, 15, 90, 90]
 * Explanation:
 * 1st contiguous subarray = [8 5 10 7], max = 10
 * 2nd contiguous subarray = [5 10 7 9], max = 10
 * 3rd contiguous subarray = [10 7 9 4], max = 10
 * 4th contiguous subarray = [7 9 4 15], max = 15
 * 5th contiguous subarray = [9 4 15 12], max = 15
 * 6th contiguous subarray = [4 15 12 90], max = 90
 * 7th contiguous subarray = {15 12 90 13}, max = 90
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(k)
 */
public class KSizedSubarrayMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int[] arr1 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int k = 3;
        int k1 = 4;
        max_of_subarrays(arr, k).forEach(ele -> System.out.print(ele + " "));
    }

    public static ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue queue = new Queue();

        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }

        res.add(queue.maxElement);

        for (int i = k; i < arr.length; i++) {
            queue.add(arr[i]);
            queue.poll();
            res.add(queue.maxElement);
        }

        return res;
    }

    static class Queue {
        private LinkedList<Integer> queue;
        private int maxElement;

        Queue() {
            this.queue = new LinkedList<>();
            this.maxElement = Integer.MIN_VALUE;
        }

        void add(int value) {
            if (value > maxElement) {
                maxElement = value;
            }
            queue.addLast(value);
        }

        int poll() {
            int value = queue.removeFirst();
            if (value == maxElement) {
                maxElement = Integer.MIN_VALUE;
                queue.forEach(element -> {
                    if (element > maxElement) {
                        maxElement = element;
                    }
                });
            }
            return value;
        }
    }
}
