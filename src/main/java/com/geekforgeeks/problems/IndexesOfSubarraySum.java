package com.geekforgeeks.problems;

import java.util.ArrayList;

/**
 * Given an unsorted array arr of size n that contains only non negative integers, find a sub-array
 * (continuous elements) that has sum equal to s. You mainly need to return the left and right
 * indexes(1-based indexing) of that subarray.
 *
 * In case of multiple subarrays, return the subarray indexes which come first on moving from left to right.
 * If no such subarray exists return an array consisting of element -1.
 *
 * Examples:
 *
 * Input: arr[] = [1,2,3,7,5], n = 5, s = 12
 * Output: 2 4
 * Explanation: The sum of elements from 2nd to 4th position is 12.
 * Input: arr[] = [1,2,3,4,5,6,7,8,9,10], n = 10, s = 15,
 * Output: 1 5
 * Explanation: The sum of elements from 1st to 5th position is 15.
 * Input: arr[] = [7,2,1], n = 3, s = 2
 * Output: 2 2
 * Explanation: The sum of elements from 2nd to 2nd position is 2.
 * Input: arr[] = [5,3,4], n = 3, s = 2
 * Output: -1
 * Explanation: There is no subarray with sum 2
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class IndexesOfSubarraySum {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 7, 5};
        int sum = 12;
        subarraySum(arr1, arr1.length, sum).forEach(ele -> System.out.print(ele + " "));
    }

    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> res = new ArrayList<>();
        int currentSum = 0;
        int last = 0, start = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum >= s) {
                last = i;

                while (s < currentSum && start < last) {
                    currentSum -= arr[start];
                    ++start;
                }

                if (currentSum == s) {
                    res.add(start + 1);
                    res.add(last + 1);
                    break;
                }
            }
        }
        if (res.isEmpty()) {
            res.add(-1);
        }
        return res;
    }
}
