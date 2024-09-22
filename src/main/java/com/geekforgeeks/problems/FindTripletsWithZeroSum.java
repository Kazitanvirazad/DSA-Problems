package com.geekforgeeks.problems;

import java.util.Arrays;

/**
 * Given an array arr[] of n integers. Check whether it contains a triplet that sums up to zero.
 * Return true, if there is at least one triplet following the condition else return false.
 *
 * Examples:
 *
 * Input: n = 5, arr[] = {0, -1, 2, -3, 1}
 * Output: 1
 * Explanation: 0, -1, and 1 form a triplet with a sum equal to 0.
 * Input: n = 3, arr[] = {1, 2, 3}
 * Output: 0
 * Explanation: No triplet with zero sum exists.
 * Expected Time Complexity: O(n2)
 * Expected Auxiliary Space: O(1)
 */
public class FindTripletsWithZeroSum {
    public static void main(String[] args) {
        int[] arr1 = {0, -1, 2, -3, 1};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {97, -27, 2, -34, 61, -39};
        System.out.println(findTriplets(arr3, arr3.length));
    }

    public static boolean findTriplets(int arr[], int n) {
        boolean isTripletsSumZero = false;
        int[][] mat = new int[2][3];

        for (int i = 0; i < arr.length - 1 && !isTripletsSumZero; i++) {
            int target = -arr[i];
            int[] sortedArr = Arrays.copyOfRange(arr, i + 1, arr.length);
            Arrays.sort(sortedArr);

            int l = 0;
            int r = sortedArr.length - 1;
            while (l < r) {
                int sum = sortedArr[l] + sortedArr[r];
                if (sum == target) {
                    isTripletsSumZero = true;
                    break;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return isTripletsSumZero;
    }
}
