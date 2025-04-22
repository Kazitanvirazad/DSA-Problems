package com.geekforgeeks.problems.partone;

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
    public static void main(String[] args) {
        int[] arr1 = {3, 5, 0, 0, 4};
        pushZerosToEnd2(arr1);
        print(arr1);
        int[] arr2 = {0, 0, 0, 4};
        pushZerosToEnd2(arr2);
        print(arr2);
        int[] arr3 = {10, 2, 4};
        pushZerosToEnd2(arr3);
        print(arr3);
        int[] arr4 = {3, 5, 0, 0, 4, 5, 0, 0, 0, 0, 0, 2, 0};
        pushZerosToEnd2(arr4);
        print(arr4);
    }

    private static void print(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void pushZerosToEnd2(int[] arr) {
        int fastIndex = 0;
        int slowIndex = 0;
        while (fastIndex < arr.length) {
            if (arr[slowIndex] != 0) {
                slowIndex++;
            } else {
                if (arr[fastIndex] != 0) {
                    arr[slowIndex] = arr[fastIndex];
                    arr[fastIndex] = 0;
                    slowIndex++;
                }
            }
            fastIndex++;
        }
    }

    public static void pushZerosToEnd(int[] arr) {
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
