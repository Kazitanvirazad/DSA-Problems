package com.geekforgeeks.problems.partone;

import java.util.Set;
import java.util.TreeSet;

/**
 * Given an unsorted array arr of of positive integers. One number 'A' from set {1, 2,....,n} is missing
 * and one number 'B' occurs twice in array. Find numbers A and B.
 *
 * Examples
 *
 * Input: arr[] = [2, 2]
 * Output: 2 1
 * Explanation: Repeating number is 2 and smallest positive missing number is 1.
 * Input: arr[] = [1, 3, 3]
 * Output: 3 2
 * Explanation: Repeating number is 3 and smallest positive missing number is 2.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class MissingAndRepeating {
    public static void main(String[] args) {
        int[] arr = {13, 33, 43, 16, 25, 19, 23, 31, 29, 35, 10, 2, 32, 11, 47, 15, 34, 46, 30, 26, 41, 18, 5, 17, 37, 39, 6, 4, 20, 27, 9, 3, 8, 40, 24, 44, 14, 36, 7, 38, 12, 1, 42, 12, 28, 22, 45};
        int[] res = findTwoElement(arr);

        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] findTwoElement(int[] arr) {

        int[] res = new int[2];

        Set<Integer> tree = new TreeSet<>();

        int sum = 0;
        int actualSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            sum += val;
            actualSum += i + 1;
            if (tree.contains(val)) {
                res[0] = val;
                continue;
            }
            tree.add(val);
        }

        res[1] = (actualSum + res[0]) - sum;

        return res;
    }
}
