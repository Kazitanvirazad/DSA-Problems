package com.geekforgeeks.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given an array arr[] with repeated elements, the task is to find the maximum distance between two occurrences of an element.
 *
 * Note: You may assume that every input array has repetitions.
 *
 * Examples:
 *
 * Input: arr = [1, 1, 2, 2, 2, 1]
 * Output: 5
 * Explanation: distance for 1 is: 5-0 = 5, distance for 2 is : 4-2 = 2, So max distance is 5.
 * Input: arr = [3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2]
 * Output: 10
 * Explanation: maximum distance for 2 is 11-1 = 10, maximum distance for 1 is 4-2 = 2 ,maximum distance
 * for 4 is 10-5 = 5, So max distance is 10.
 * Expected Time Complexity :  O(n)
 * Expected Auxilliary Space : O(n)
 */
public class MaxDistanceBetweenSameElements {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 1};
        int[] arr1 = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        int[] arr2 = {3};
        int[] arr3 = {3, 1, 5, 7, 8, 9, 12};
        System.out.println(maxDistance(arr3));
    }

    public static int maxDistance(int[] arr) {
        Map<Integer, Element> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                Element element = map.get(arr[i]);
                element.distance = i - element.initialIndex;
                map.put(arr[i], element);
            } else {
                Element element = new Element();
                element.initialIndex = i;
                element.distance = 0;
                map.put(arr[i], element);
            }
        }

        int maxDistance = 0;
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Element element = map.get(iterator.next());
            if (element.distance > maxDistance) {
                maxDistance = element.distance;
            }
        }

        return maxDistance;
    }

    static class Element {
        int distance;
        int initialIndex;
    }
}
