package com.geekforgeeks.problems.parttwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array of integers arr[] where, every element appears thrice except for one which occurs once.
 * Find that element which occurs once.
 *
 * Examples:
 *
 * Input: arr[] = [1, 10, 1, 1]
 * Output: 10
 * Explanation: 10 occurs once in the array while the other element 1 occurs thrice.
 * Input: arr[] = [3, 2, 1, 34, 34, 1, 2, 34, 2, 1]
 * Output: 3
 * Explanation: All elements except 3 occurs thrice in the array.
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * arr.size() % 3 = 1
 * -109 ≤ arr[i] ≤ 109
 */
public class UniqueNumber_III {
    public int getSingleFunctional(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() < 3)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    public int getSingle(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.getOrDefault(num, 1) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 3) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
