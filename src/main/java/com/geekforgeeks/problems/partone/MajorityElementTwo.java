package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given an array of integer arr[] where each number represents a vote to a candidate.
 * Return the candidates that have votes greater than one-third of the total votes, If there's not a
 * majority vote, return an empty array.
 *
 * Note: The answer should be returned in an increasing format.
 *
 * Examples:
 *
 * Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
 * Output: [5, 6]
 * Explanation: 5 and 6 occur more n/3 times.
 * Input: arr[] = [1, 2, 3, 4, 5]
 * Output: []
 * Explanation: no candidate occur more than n/3 times.
 */
public class MajorityElementTwo {
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 3};
        findMajority(arr2).forEach(ele -> System.out.print(ele + " "));
    }

    public static List<Integer> findMajority(int[] nums) {
        List<Integer> candidates = new ArrayList<>();
        int oneThirdVoteCount = nums.length / 3;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int voteCount = map.get(nums[i]);
                if (voteCount < 0) {
                    continue;
                }
                map.put(nums[i], voteCount + 1);
                if (voteCount + 1 > oneThirdVoteCount) {
                    candidates.add(nums[i]);
                    map.put(nums[i], -1);
                }
            } else {
                map.put(nums[i], 1);
                if (oneThirdVoteCount < 1) {
                    candidates.add(nums[i]);
                    map.put(nums[i], -1);
                }
            }
        }
        Collections.sort(candidates);
        return candidates;
    }
}
