package com.geekforgeeks.problems;

import java.util.ArrayList;

/**
 * Given a sorted array arr containing n elements with possibly some duplicate, the task is to find the first and last
 * occurrences of an element x in the given array.
 * Note: If the number x is not found in the array then return both the indices as -1.
 *
 *
 * Example 1:
 *
 * Input:
 * n=9, x=5
 * arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
 * Output:
 * 2 5
 * Explanation:
 * First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5.
 * Example 2:
 *
 * Input:
 * n=9, x=7
 * arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
 * Output:
 * 6 6
 * Explanation:
 * First and last occurrence of 7 is at index 6.
 * Your Task:
 * Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code.
 * You just need to complete the function find() that takes array arr, integer n and integer x as parameters and returns the
 * required answer.
 *
 * Expected Time Complexity: O(logN)
 * Expected Auxiliary Space: O(1).
 */
public class FirstAndLastOccurrences {

    // Less accurate 75% +
    public ArrayList<Integer> find1(int[] arr, int n, int x) {
        ArrayList<Integer> res = new ArrayList<>();
        int firstOccIndex = -1;
        int secondOccIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                if (firstOccIndex == -1) {
                    firstOccIndex = i;
                    secondOccIndex = i;
                } else {
                    secondOccIndex = i;
                }
            }
        }
        res.add(firstOccIndex);
        res.add(secondOccIndex);
        return res;
    }

    // More accurate 80% +
    public ArrayList<Integer> find2(int[] arr, int n, int x) {
        ArrayList<Integer> res = new ArrayList<>();
        int firstOccIndex = -1;
        int secondOccIndex = -1;

        int lastIndex = arr.length - 1;
        int startIndex = 0;

        while (startIndex < arr.length && lastIndex >= 0) {
            if (firstOccIndex < 0 && arr[startIndex] == x) {
                firstOccIndex = startIndex;
            }
            if (secondOccIndex < 0 && arr[lastIndex] == x) {
                secondOccIndex = lastIndex;
            }
            if (firstOccIndex >= 0 && secondOccIndex >= 0) {
                break;
            }
            startIndex++;
            lastIndex--;
        }
        res.add(firstOccIndex);
        res.add(secondOccIndex);
        return res;
    }
}
