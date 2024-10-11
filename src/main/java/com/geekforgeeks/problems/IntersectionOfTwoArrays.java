package com.geekforgeeks.problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given two arrays a[] and b[] respectively of size n and m, the task is to print the count of elements in the
 * intersection (or common elements) of the two arrays.
 *
 * For this question, the intersection of two arrays can be defined as the set containing distinct common elements
 * between the two arrays.
 *
 * Example 1:
 *
 * Input:
 * n = 5, m = 3
 * a[] = {89, 24, 75, 11, 23}
 * b[] = {89, 2, 4}
 *
 * Output: 1
 *
 * Explanation:
 * 89 is the only element
 * in the intersection of two arrays.
 * Example 2:
 *
 * Input:
 * n = 6, m = 5
 * a[] = {1, 2, 3, 4, 5, 6}
 * b[] = {3, 4, 5, 6, 7}
 *
 * Output: 4
 *
 * Explanation:
 * 3 4 5 and 6 are the elements
 * in the intersection of two arrays.
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function NumberofElementsInIntersection()
 * which takes two integers n and m and their respective arrays a[] and b[]  as input. The function should return the
 * count of the number of elements in the intersection.
 *
 *
 *
 * Expected Time Complexity: O(n + m).
 * Expected Auxiliary Space: O(n).
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 3};
        int[] arr2 = {3, 4, 5, 6, 7, 3};
        System.out.println(numberOfElementsInIntersection(arr1, arr2, arr1.length, arr2.length));
    }

    public static int numberOfElementsInIntersection(int a[], int b[], int n, int m) {
        int counter = 0;

        Set<Integer> setOne = convertToSet(a);
        Set<Integer> setTwo = convertToSet(b);

        Iterator<Integer> iterator = setTwo.iterator();
        while (iterator.hasNext()) {
            int val = iterator.next();
            if (setOne.contains(val)) {
                counter++;
            }
        }
        return counter;
    }

    public static Set<Integer> convertToSet(int[] arr) {
        Set<Integer> res = new HashSet<>();

        for (int val : arr) {
            res.add(val);
        }
        return res;
    }
}
