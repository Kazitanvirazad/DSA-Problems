package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array, arr[], determine if arr can be split into three consecutive parts such that the sum
 * of each part is equal. If possible, return any index pair(i, j) in an array such
 * that sum(arr[0..i]) = sum(arr[i+1..j]) = sum(arr[j+1..n-1]), otherwise return an array {-1,-1}.
 *
 * Note: Driver code will print true if arr can be split into three equal sum subarrays, otherwise, it is false.
 *
 * Examples :
 *
 * Input:  arr[] = [1, 3, 4, 0, 4]
 * Output: true
 * Explanation: [1, 2] is valid pair as sum of subarray arr[0..1] is equal to sum of subarray arr[2..3] and
 * also to sum of subarray arr[4..4]. The sum is 4.
 * Input: arr[] = [2, 3, 4]
 * Output: false
 * Explanation: No three subarrays exist which have equal sum.
 * Input: arr[] = [0, 1, 1]
 * Output: false
 */
public class SplitArrayInThreeEqualSumSubarrays {
    public static void main(String[] args) {
        SplitArrayInThreeEqualSumSubarrays split = new SplitArrayInThreeEqualSumSubarrays();
        int[] arr1 = {1, 3, 4, 0, 4};
        int[] arr2 = {2, 3, 4};
        int[] arr3 = {0, 1, 1};
        int[] arr4 = {0, 0, 0};
        System.out.println(split.findSplit(arr1));
    }

    public List<Integer> findSplit(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        for (int ele : arr) {
            sum += ele;
        }

        if (sum % 3 != 0) {
            return new ArrayList<>(Arrays.asList(-1, -1));
        }

        int partSum = 0;
        for (int i = 0; i < arr.length; i++) {
            partSum += arr[i];
            if (partSum == sum / 3) {
                res.add(i);
                partSum = 0;
            }
            if (res.size() == 2) {
                return res;
            }
        }
        return new ArrayList<>(Arrays.asList(-1, -1));
    }
}
