package com.geekforgeeks.problems.partone;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array arr[] and two integers say, x and y, find the number of sub-arrays in which the
 * number of occurrences of x is equal to the number of occurrences of y.
 *
 * Examples:
 *
 * Input: arr[] = [1, 2, 1] , x= 1 , y = 2
 * Output: 2
 * Explanation: The possible sub-arrays have same equal number of occurrences of x and y are:
 * 1) [1, 2], x and y have same occurrence(1).
 * 2) [2, 1], x and y have same occurrence(1).
 * Input: arr[] = [1, 2, 1] , x = 4 , y = 6
 * Output: 6
 * Explanation: The possible sub-arrays have same equal number of occurrences of x and y are:
 * 1) [1], x and y have same occurrence(0).
 * 2) [2], x and y have same occurrence(0).
 * 3) [1], x and y have same occurrence(0).
 * 4) [1, 2], x and y have same occurrence(0).
 * 5) [2, 1], x and y have same occurrence(0).
 * 6) [1, 2, 1], x and y have same occurrence(0).
 * Input: arr[] = [1, 2, 1] , x= 1 , y = 4
 * Output: 1
 * Explanation: The possible sub-array have same equal number of occurrences of x and y is: [2], x and y have
 * same occurrence(1)
 */
public class SubArraysWithEqualNumberOfOccurrences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int x = 1;
        int y = 4;
        System.out.println(sameOccurrence(arr, x, y));
    }

    public static int sameOccurrence(int[] arr, int x, int y) {
        int n = arr.length;
        int[] xCount = new int[n];
        int[] yCount = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                if (i != 0)
                    xCount[i] = xCount[i - 1] + 1;
                else
                    xCount[i] = 1;
            } else {
                if (i != 0)
                    xCount[i] = xCount[i - 1];
                else
                    xCount[i] = 0;
            }
            if (arr[i] == y) {
                if (i != 0)
                    yCount[i] = yCount[i - 1] + 1;
                else
                    yCount[i] = 1;
            } else {
                if (i != 0)
                    yCount[i] = yCount[i - 1];
                else
                    yCount[i] = 0;
            }
            if (map.containsKey(xCount[i] - yCount[i])) {
                map.put(xCount[i] - yCount[i], map.get(xCount[i] - yCount[i]) + 1);
            } else {
                map.put(xCount[i] - yCount[i], 1);
            }
        }

        int occurrence = map.get(0) != null ? map.get(0) : 0;
        for (Map.Entry<Integer, Integer> iterator : map.entrySet()) {
            occurrence = occurrence + ((iterator.getValue()) * ((iterator.getValue()) - 1)) / 2;
        }
        return occurrence;
    }
}
