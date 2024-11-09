package com.geekforgeeks.problems;

import java.util.ArrayList;

/**
 * Given two sorted arrays a[] and b[], where each array contains distinct elements , the task is to
 * return the elements in the union of the two arrays in sorted order.
 *
 * Union of two arrays can be defined as the set containing distinct common elements that are present
 * in either of the arrays.
 * Examples:
 *
 * Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
 * Output: 1 2 3 4 5 6 7
 * Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
 * Input: a[] = [2, 3, 4, 5], b[] = [1, 2, 3, 4]
 * Output: 1 2 3 4 5
 * Explanation: Distinct elements including both the arrays are: 1 2 3 4 5.
 * Input: a[] = [1], b[] = [2]
 * Output: 1 2
 * Explanation: Distinct elements including both the arrays are: 1 2.
 */
public class UnionOfTwoSortedArraysWithDistinctElements {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] b1 = {1, 2, 3, 6, 7};

        int[] a2 = {2, 3, 4, 5};
        int[] b2 = {1, 2, 3, 4};

        int[] a3 = {1};
        int[] b3 = {2};
        findUnion(a1, b1).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        findUnion(a2, b2).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        findUnion(a3, b3).forEach(ele -> System.out.print(ele + " "));
    }

    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            int num = a[i] <= b[j] ? a[i++] : b[j++];
            if (!res.isEmpty()) {
                if (res.get(res.size() - 1) != num) {
                    res.add(num);
                }
            } else {
                res.add(num);
            }
        }
        while (true) {
            int num;
            if (i < a.length) {
                num = a[i++];
                if (res.get(res.size() - 1) != num) {
                    res.add(num);
                }
            } else if (j < b.length) {
                num = b[j++];
                if (res.get(res.size() - 1) != num) {
                    res.add(num);
                }
            } else {
                break;
            }
        }
        return res;
    }
}
