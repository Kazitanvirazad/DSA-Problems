package com.geekforgeeks.problems.partone;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array arr and a number k which is smaller than size of the array.
 * Find if the array contains duplicates within k distance.
 *
 * Examples:
 *
 * Input: arr[] = [1, 2, 3, 4, 1, 2, 3, 4] and k = 3
 * Output: false
 * Explanation: All duplicates are more than k distance away.
 * Input: arr[] = [1, 2, 3, 1, 4, 5] and k = 3
 * Output: true
 * Explanation: 1 is repeated at distance 3.
 */
public class KthDistance {
    public static void main(String[] args) {
        KthDistance distance = new KthDistance();
        int[] arr1 = {1, 2, 3, 4, 1, 2, 3, 4};
        int k1 = 3;
        int[] arr2 = {1, 2, 3, 1, 4, 5};
        int k2 = 3;
        int[] arr3 = {1, 2, 3, 4, 6, 7, 8, 7};
        int k3 = 3;
        System.out.println(distance.checkDuplicatesWithinK(arr3, k3));
    }

    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                if (map.get(arr[i]) + k >= i) {
                    return true;
                }
            }
            map.put(arr[i], i);
        }
        return false;
    }
}
