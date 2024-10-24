package com.geekforgeeks.problems;

/**
 * Given an array arr[]. Push all the zeros of the given array to the right end of the array while
 * maintaining the order of non-zero elements. Do the mentioned change in the array in place.
 *
 * Examples:
 *
 * Input: arr[] = [3, 5, 0, 0, 4]
 * Output: [3, 5, 4, 0, 0]
 * Explanation: The non-zero elements preserve their order while the 0 elements are moved to the right.
 * Input: arr[] = [0, 0, 0, 4]
 * Output: [4, 0, 0, 0]
 * Explanation: 4 is the only non-zero element and it gets moved to the left.
 * Input: arr[] = [10, 2, 4]
 * Output: [10, 2, 4]
 * Explanation: Since there are no 0s, the array does not change.
 */
public class MoveAllZeroesToEnd {
    public void pushZerosToEnd(int[] arr) {
        // code here
        int i = 0;
        int j = 0;

        while (i < arr.length) {
            if (arr[j] != 0) {
                j++;
            } else {
                if (arr[i] != 0) {
                    arr[j] = arr[i];
                    arr[i] = 0;
                    j++;
                }
            }
            i++;
        }

        while (j < arr.length) {
            arr[j++] = 0;
        }
    }
}
