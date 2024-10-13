package com.geekforgeeks.problems;

import java.util.ArrayList;

/**
 * Given an array arr of positive integers. Reverse every sub-array group of size k.
 *
 * Note: If at any instance, k is greater or equal to the array size, then reverse the entire array.
 * You shouldn't return any array, modify the given array in place.
 *
 * Examples:
 *
 * Input: k = 3, arr= [1, 2, 3, 4, 5]
 * Output: [3, 2, 1, 5, 4]
 * Explanation: First group consists of elements 1, 2, 3. Second group consists of 4,5.
 * Input: k = 5, arr = [5, 6, 8, 9]
 * Output: [9, 8, 6, 5]
 * Explnation: Since k is greater than array size, the entire array is reversed.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class ReverseArrayInGroups {
    public static void main(String[] args) {
        long[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 10;
        ArrayList<Long> list = new ArrayList<>() {{
            for (long val : arr) {
                add(val);
            }
        }};
        list.forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        reverseInGroups(list, 3);
        list.forEach(ele -> System.out.print(ele + " "));
    }

    public static void reverseInGroups(ArrayList<Long> arr, int k) {
        int startIndex = 0;

        if (k >= arr.size()) {
            reverse(arr, 0, arr.size() - 1);
            return;
        }

        while (startIndex < arr.size()) {
            if (startIndex + (k - 1) > arr.size() - 1) {
                reverse(arr, startIndex, arr.size() - 1);
                break;
            } else {
                reverse(arr, startIndex, startIndex + (k - 1));
            }
            startIndex += k;
        }
    }

    private static void reverse(ArrayList<Long> arr, int start, int end) {
        while (start < end) {
            long temp = arr.get(end);
            arr.set(end, arr.get(start));
            arr.set(start, temp);
            end--;
            start++;
        }
    }
}
