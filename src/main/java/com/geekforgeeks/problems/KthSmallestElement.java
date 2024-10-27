package com.geekforgeeks.problems;

import java.util.Random;

/**
 * Given an array arr[] and an integer K where K is smaller than size of array,
 * the task is to find the Kth smallest element in the given array. It is given
 * that all array elements are distinct.
 * <p>
 * Note :- l and r denotes the starting and ending index of the array.
 * <p>
 * Example 1:
 * <p>
 * Input: N = 6 arr[] = 7 10 4 3 20 15 K = 3 Output : 7 Explanation : 3rd
 * smallest element in the given array is 7.
 * <p>
 * Example 2:
 * <p>
 * Input: N = 5 arr[] = 7 10 4 20 15 K = 4 Output : 15 Explanation : 4th
 * smallest element in the given array is 15. Your Task: You don't have to read
 * input or print anything. Your task is to complete the function kthSmallest()
 * which takes the array arr[], integers l and r denoting the starting and
 * ending index of the array and an integer K as input and returns the Kth
 * smallest element.
 * <p>
 * <p>
 * Expected Time Complexity: O(n) Expected Auxiliary Space: O(log(n))
 * Constraints: 1 <= N <= 105 1 <= arr[i] <= 105 1 <= K <= N
 */
public class KthSmallestElement {

    public static void main(String[] args) {
//        int arr[] = {7, 10, 4, 3, 20, 15}; // 7
//        int k = 3;
        int arr[] = {7, 10, 4, 20, 15}; // 15
        int k = 4;
        System.out.println(kthSmallest(arr, k));
    }

    public static int kthSmallest(int[] arr, int k) {
        return kthSmallest(arr, 0, arr.length - 1, k - 1);
    }

    private static int kthSmallest(int[] arr, int l, int r, int k) {
        int pivot = getPartitionIndex(arr, l, r);
        if (pivot > k) {
            return kthSmallest(arr, l, pivot - 1, k);
        } else if (pivot < k) {
            return kthSmallest(arr, pivot + 1, r, k);
        }
        return arr[pivot];
    }

    private static int getPartitionIndex(int arr[], int firstIndex, int lastIndex) {
        int randomPivotIndex = new Random().nextInt(lastIndex - firstIndex + 1) + firstIndex;
        // swap
        int temp = arr[randomPivotIndex];
        arr[randomPivotIndex] = arr[lastIndex];
        arr[lastIndex] = temp;

        for (int i = firstIndex; i < lastIndex; i++) {
            if (arr[i] < arr[lastIndex]) {
                int current = arr[firstIndex];
                arr[firstIndex] = arr[i];
                arr[i] = current;
                firstIndex++;
            }
        }
        // re-swap
        temp = arr[firstIndex];
        arr[firstIndex] = arr[lastIndex];
        arr[lastIndex] = temp;
        return firstIndex;
    }
}