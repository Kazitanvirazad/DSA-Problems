package com.geekforgeeks.problems.partone;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array arr[] of positive integers where every element appears even times except for one.
 * Find that number occurring an odd number of times.
 *
 * Examples:
 *
 * Input: arr[] = [1, 1, 2, 2, 2]
 * Output: 2
 * Explanation: In the given array all element appear two times except 2 which appears thrice.
 * Input: arr[] = [8, 8, 7, 7, 6, 6, 1]
 * Output: 1
 * Explanation: In the given array all element appear two times except 1 which appears once.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] arr = {1, 1, 2, 2, 2};
        int[] arr2 = {8, 8, 7, 7, 6, 6, 1};
        System.out.println(singleNumber.getSingle(arr2));
    }

    public int getSingle(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int element : arr) {
            if (map.containsKey(element)) {
                map.remove(element);
            } else {
                map.put(element, 0);
            }
        }
        return map.keySet().iterator().hasNext() ? map.keySet().iterator().next() : 0;
    }
}
