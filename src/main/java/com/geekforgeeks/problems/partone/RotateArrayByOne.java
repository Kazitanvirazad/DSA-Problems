package com.geekforgeeks.problems.partone;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array arr, rotate the array by one position in clock-wise direction.
 *
 * Examples:
 *
 * Input: arr = [1, 2, 3, 4, 5]
 * Output: [5, 1, 2, 3, 4]
 * Explanation: If we rotate arr by one position in clockwise 5 come to the front and remaining those
 * are shifted to the end.
 * Input: arr = [9, 8, 7, 6, 4, 2, 1, 3]
 * Output: [3, 9, 8, 7, 6, 4, 2, 1]
 * Explanation: After rotating clock-wise 3 comes in first position.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class RotateArrayByOne {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
//        int[] arr1 = {31549};
        rotate(arr1);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }

    public static void rotate(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int rotateBy = 1;

        Queue<Integer> queue = new LinkedList<>();
        int startIndex = (arr.length) - rotateBy;

        for (int i = startIndex; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        for (int i = 0; i < startIndex; i++) {
            queue.add(arr[i]);
            arr[i] = queue.poll();
        }
        for (int i = startIndex; i < arr.length && !queue.isEmpty(); i++) {
            arr[i] = queue.poll();
        }
    }
}
