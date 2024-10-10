package com.geekforgeeks.problems;

/**
 * Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.
 *
 * Example 1:
 *
 * Input:
 * N = 7, X = 2
 * Arr[] = {1, 1, 2, 2, 2, 2, 3}
 * Output: 4
 * Explanation: x = 2 occurs 4 times in the given array so the output is 4.
 * Example 2:
 *
 * Input:
 * N = 7, X = 4
 * Arr[] = {1, 1, 2, 2, 2, 2, 3}
 * Output: 0
 * Explanation: X = 4 is not present in the given array so the output is 0.
 * Your Task:
 * You don't need to read input or print anything.
 * Your task is to complete the function count() which takes the array of integers arr, n, and x as
 * parameters and returns an integer denoting the answer.
 * If x is not present in the array (arr) then return 0.
 *
 * Expected Time Complexity: O(logN)
 * Expected Auxiliary Space: O(1)
 */
public class NumberOfOccurrence {
    public static void main(String[] args) {
        NumberOfOccurrence number = new NumberOfOccurrence();
//        int[] arr = {1, 1, 2, 2, 2, 2, 3};
//        int[] arr = {4, 5, 5, 6, 6, 7, 7, 7, 7, 7, 9, 9};
        int[] arr = {4};
//        System.out.println(number.binarySearch(arr, 2, 0, 3 - 1));
//        System.out.println(number.binarySearch(arr, 2, 3 + 1, arr.length - 1));
        System.out.println(number.count(arr, arr.length, 4));
    }

    public int count(int[] arr, int n, int x) {
        int randomIndexPositionOfTheSearchableElement = binarySearch(arr, x);

        if (randomIndexPositionOfTheSearchableElement < 0) {
            return 0;
        }

        int count = 1;

        int previousElementIndex = randomIndexPositionOfTheSearchableElement - 1;
        int nextElementIndex = randomIndexPositionOfTheSearchableElement + 1;
        while (true) {
            if (previousElementIndex > -1 && arr[previousElementIndex] == x) {
                count++;
                previousElementIndex--;
            }
            if (nextElementIndex < arr.length && arr[nextElementIndex] == x) {
                count++;
                nextElementIndex++;
            }
            if ((previousElementIndex < 0 || arr[previousElementIndex] != x)
                    && (nextElementIndex >= arr.length || arr[nextElementIndex] != x)) {
                break;
            }
        }

        return count;
    }

    public int binarySearch(int[] arr, int element) {
        int low = 0;
        int high = arr.length - 1;
        if (low <= high) {
            return binarySearch(arr, element, low, high);
        }
        return -1;
    }

    public int binarySearch(int[] arr, int element, int lowIndex, int highIndex) {
        if (lowIndex <= highIndex) {
            int midPosition = (highIndex + lowIndex) / 2;
            if (arr[midPosition] == element) {
                return midPosition;
            }
            if (arr[midPosition] < element) {
                return binarySearch(arr, element, midPosition + 1, highIndex);
            } else {
                return binarySearch(arr, element, lowIndex, midPosition - 1);
            }
        } else {
            return -1;
        }
    }
}
