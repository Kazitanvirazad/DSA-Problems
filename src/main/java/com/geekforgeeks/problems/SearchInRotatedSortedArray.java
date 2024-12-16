package com.geekforgeeks.problems;

/**
 * Given a sorted (in ascending order) and rotated array arr of distinct elements which may be rotated at
 * some point and given an element key, the task is to find the index of the given element key in the array arr.
 * The whole array arr is given as the range to search.
 *
 * Rotation shifts elements of the array by a certain number of positions, with elements that fall off one
 * end reappearing at the other end.
 *
 * Note:- 0-based indexing is followed & returns -1 if the key is not present.
 *
 * Examples :
 *
 * Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 10
 * Output: 5
 * Explanation: 10 is found at index 5.
 * Input: arr[] = [3, 5, 1, 2], key = 6
 * Output: -1
 * Explanation: There is no element that has value 6.
 * Input: arr[] = [33, 42, 72, 99], key = 42
 * Output: 1
 * Explanation: 42 is found at index 1.
 * Expected Time Complexity: O(log n)
 * Expected Auxiliary Space: O(1)
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key1 = 10;
        int[] arr2 = {3, 5, 1, 2};
        int key2 = 6;
        int[] arr3 = {33, 42, 72, 99};
        int key3 = 42;
        int[] arr4 = {4, 5, 1, 2, 3};
        int key4 = 6;
        int[] arr5 = {4, 6, 1, 2, 3};
        int key5 = 5;
        int[] arr6 = {5, 6, 7, 1, 2, 3, 4};
        int key6 = 1;

        System.out.println(search(arr1, key1));
    }

    public static int search(int[] arr, int key) {
        if (arr.length == 1) {
            return arr[0] == key ? 0 : -1;
        }
        if (arr[0] < arr[arr.length - 1]) {
            return binarySearch(arr, key, 0, arr.length - 1);
        } else {
            int pivotIndex = searchPivot(arr, 0, arr.length - 1) - 1;
            if (arr[pivotIndex] == key) {
                return pivotIndex;
            }
            if (key < arr[0]) {
                return binarySearch(arr, key, pivotIndex + 1, arr.length - 1);
            } else {
                return binarySearch(arr, key, 0, pivotIndex);
            }
        }
    }

    private static int searchPivot(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;

            if (arr[mid] > arr[right]) {
                return searchPivot(arr, mid + 1, right);
            } else {
                return searchPivot(arr, left, mid);
            }
        } else {
            return left;
        }
    }


    private static int binarySearch(int[] arr, int elementToSearch, int lowIndex, int highIndex) {
        if (lowIndex <= highIndex) {
            int midPosition = (highIndex + lowIndex) / 2;
            if (arr[midPosition] == elementToSearch) {
                return midPosition;
            } else if (arr[midPosition] < elementToSearch) {
                return binarySearch(arr, elementToSearch, midPosition + 1, highIndex);
            } else {
                return binarySearch(arr, elementToSearch, lowIndex, midPosition - 1);
            }
        } else {
            return -1;
        }
    }

    public static int searchAlternate(int[] arr, int key) {
        if (arr[0] <= arr[arr.length - 1]) {
            return binarySearch(arr, 0, arr.length - 1, key);
        } else {
            int start = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    start = i + 1;
                    break;
                }
            }
            int position = binarySearch(arr, key, start, arr.length - 1);
            if (position < 0 || arr[position] != key) {
                return binarySearch(arr, key, 0, start - 1);
            }
            return position;
        }
    }
}
