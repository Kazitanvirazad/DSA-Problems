package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of elements arr[] with indices ranging from 0 to arr.size() - 1, your task is to write a program
 * that rearranges the elements of the array such that arr[i] = i. If an element i is not present in the array,
 * -1 should be placed at the corresponding index.
 *
 * Examples:
 *
 * Input: arr[] = [-1, -1, 6, 1, 9, 3, 2, -1, 4, -1]
 * Output: [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
 * Explanation: Here We can see there are 10 elements. So, the sorted array will look like [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 * but in our array we are not having 0, 5, 7 and 8. So, at there places we will be printing -1 and otherplaces will
 * be having elements.
 * Input: arr[] = [2, 0, 1]
 * Output: [0, 1, 2]
 * Explanation: Here We can see all the elements are present so no -1 is returned in array.
 * Expected Time Complexity: O(n).
 * Expected Auxiliary Space: O(1).
 */
public class ReorganizeTheArray {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(-1, -1, 6, 1, 9, 3, 2, -1, 4, -1);
//        List<Integer> arr = Arrays.asList(0, 4);
        rearrange(arr).forEach(ele -> System.out.print(ele + " "));
    }

    public static List<Integer> rearrange(List<Integer> arr) {
        Collections.sort(arr);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (binarySearch(arr, i)) {
                res.add(i);
            } else {
                res.add(-1);
            }
        }
        return res;
    }

    private static boolean binarySearch(List<Integer> arr, int elementToSearch) {
        return binarySearch(arr, elementToSearch, 0, arr.size() - 1);
    }

    private static boolean binarySearch(List<Integer> arr, int elementToSearch, int lowIndex, int highIndex) {
        if (lowIndex <= highIndex) {
            int midIndex = (highIndex + lowIndex) / 2;
            if (arr.get(midIndex) == elementToSearch) {
                return true;
            }
            if (arr.get(midIndex) > elementToSearch) {
                return binarySearch(arr, elementToSearch, 0, midIndex - 1);
            } else {
                return binarySearch(arr, elementToSearch, midIndex + 1, highIndex);
            }
        } else {
            return false;
        }
    }
}
