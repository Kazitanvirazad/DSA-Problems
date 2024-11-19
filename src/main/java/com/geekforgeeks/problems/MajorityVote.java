package com.geekforgeeks.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of integer nums[] where each number represents a vote to a candidate. Return the candidates
 * that have votes greater than one-third of the total votes, If there's not a majority vote, return -1.
 *
 * Examples:
 *
 * Input: nums = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
 * Output: [5, 6]
 * Explanation: 5 and 6 occur more n/3 times.
 * Input: nums = [1, 2, 3, 4, 5]
 * Output: [-1]
 * Explanation: no candidate occur more than n/3 times.
 * Expected Time Complexity: O(n)
 * Expected Space Complexity: O(1)
 */
public class MajorityVote {
    public static void main(String[] args) {
        List<Integer> nums1 = Arrays.asList(2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6);
        List<Integer> nums2 = Arrays.asList(1, 2, 3);
        List<Integer> nums3 = Arrays.asList(1, 3);
        List<Integer> nums4 = Arrays.asList(2, 1, 6, 6, 6, 6, 6, 5, 5, 5, 5);
        MajorityVote vote = new MajorityVote();
        List<Integer> res = vote.findMajority(nums4);
        res.forEach(ele -> System.out.print(ele + " "));
    }

    public List<Integer> findMajority(List<Integer> nums) {
        List<Integer> res = new ArrayList<>();

        int nth = 3;

        int[][] candidates = new int[nth - 1][2];

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            boolean found = false;
            for (int j = 0; j < nth - 1; j++) {
                if (candidates[j][0] == num) {
                    candidates[j][1]++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                for (int j = 0; j < nth - 1; j++) {
                    if (candidates[j][1] == 0) {
                        candidates[j][0] = num;
                        candidates[j][1] = 1;
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                for (int j = 0; j < nth - 1; j++) {
                    candidates[j][1]--;
                }
            }
        }

        for (int[] candidate : candidates) {
            int count = 0;
            for (int num : nums) {
                if (num == candidate[0]) {
                    count++;
                }
            }
            if (count > nums.size() / nth) {
                res.add(candidate[0]);
            }
        }
        if (res.isEmpty()) {
            res.add(-1);
        }
        return res;
    }
}
