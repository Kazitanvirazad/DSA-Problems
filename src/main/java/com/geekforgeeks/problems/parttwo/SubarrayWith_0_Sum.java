package com.geekforgeeks.problems.parttwo;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, arr[]. Find if there is a subarray (of size at least one) with 0 sum.
 * Return true/false depending upon whether there is a subarray present with 0-sum or not.
 *
 * Examples:
 *
 * Input: arr[] = [4, 2, -3, 1, 6]
 * Output: true
 * Explanation: 2, -3, 1 is the subarray with a sum of 0.
 * Input: arr = [4, 2, 0, 1, 6]
 * Output: true
 * Explanation: 0 is one of the element in the array so there exist a subarray with sum 0.
 * Input: arr = [1, 2, -1]
 * Output: false
 * Constraints:
 * 1 <= arr.size <= 104
 * -105 <= arr[i] <= 105
 */
public class SubarrayWith_0_Sum {
    public static boolean findsum(int arr[]) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0 || arr[i] == 0 || set.contains(sum)) {
                return true;
            }

            set.add(sum);
        }
        return false;
    }
}
