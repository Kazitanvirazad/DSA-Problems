package com.geekforgeeks.problems.partone;

import java.util.HashMap;

/**
 * Given an array arr[] of positive integers. Find the number of pairs of integers whose difference equals
 * a given number k.
 * Note: (a, b) and (b, a) are considered the same. Also, the same numbers at different indices are
 * considered different.
 *
 * Examples:
 *
 * Input: arr[] = [1, 5, 3, 4, 2], k = 3
 * Output: 2
 * Explanation: There are 2 pairs with difference 3,the pairs are {1, 4} and {5, 2}
 * Input: arr[] = [8, 12, 16, 4, 0, 20], k = 4
 * Output: 5
 * Explanation: There are 5 pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}.
 */
public class PairsWithDifferenceK {
    public static void main(String[] args) {
        PairsWithDifferenceK pairs = new PairsWithDifferenceK();
        int[] arr1 = {1, 5, 3, 4, 2};
        int k1 = 3;
        int[] arr2 = {8, 12, 16, 4, 0, 20};
        int k2 = 4;
        System.out.println(pairs.countPairsWithDiffK(arr1, k1));
    }

    public int countPairsWithDiffK(int[] arr, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] - k)) {
                count += map.get(arr[i] - k);
            }
            if (map.containsKey(arr[i] + k)) {
                count += map.get(arr[i] + k);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
}
