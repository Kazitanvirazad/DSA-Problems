package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Given two sorted arrays of size n and m respectively, find their union. The Union of two arrays can be
 * defined as the common and distinct elements in the two arrays. Return the elements in sorted order.
 *
 * Example 1:
 *
 * Input:
 * n = 5, arr1[] = {1, 2, 3, 4, 5}
 * m = 5, arr2 [] = {1, 2, 3, 6, 7}
 * Output:
 * 1 2 3 4 5 6 7
 * Explanation:
 * Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
 * Example 2:
 *
 * Input:
 * n = 5, arr1[] = {2, 2, 3, 4, 5}
 * m = 5, arr2[] = {1, 1, 2, 3, 4}
 * Output:
 * 1 2 3 4 5
 * Explanation:
 * Distinct elements including both the arrays are: 1 2 3 4 5.
 * Example 3:
 *
 * Input:
 * n = 5, arr1[] = {1, 1, 1, 1, 1}
 * m = 5, arr2[] = {2, 2, 2, 2, 2}
 * Output:
 * 1 2
 * Explanation:
 * Distinct elements including both the arrays are: 1 2.
 * Your Task:
 * You do not need to read input or print anything. Complete the function findUnion() that takes two
 * arrays arr1[], arr2[], and their size n and m as input parameters and returns a list containing the
 * union of the two arrays.
 *
 * Expected Time Complexity: O(n+m).
 * Expected Auxiliary Space: O(n+m).
 */
public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int arr1[] = {2, 2, 3, 4, 5}, arr2[] = {1, 1, 2, 3, 4};
        findUnion(arr1, arr2, arr1.length, arr2.length).forEach(val -> System.out.print(val + " "));
    }

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> union = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int i = 0;
        int j = 0;

        while (i < n || j < m) {
            if (i < n) {
                minHeap.add(arr1[i]);
                i++;
            }
            if (j < m) {
                minHeap.add(arr2[j]);
                j++;
            }
        }

        if (!minHeap.isEmpty()) {
            union.add(minHeap.poll());
        }

        while (!minHeap.isEmpty()) {
            int current = minHeap.poll();
            if (current != union.get(union.size() - 1)) {
                union.add(current);
            }
        }

        return union;
    }
}
