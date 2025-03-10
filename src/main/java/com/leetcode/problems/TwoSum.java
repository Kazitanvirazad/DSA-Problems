package com.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that
 * they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    // Same problem with boolean return
    public boolean findTwoSum(int arr[], int target) {
        // code here
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (binarySearch(arr, i + 1, arr.length - 1, target - arr[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int start, int end, int target) {
        if (start <= end) {
            int mid = (end + start) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] < target) {
                return binarySearch(arr, mid + 1, end, target);
            } else {
                return binarySearch(arr, start, mid - 1, target);
            }
        } else {
            return false;
        }
    }
}
