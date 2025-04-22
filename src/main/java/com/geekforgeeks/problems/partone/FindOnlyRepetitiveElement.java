package com.geekforgeeks.problems.partone;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Given an array arr[] of size n, filled with numbers from 1 to n-1 in random order. The array has only one
 * repetitive element. Your task is to find the repetitive element.
 *
 * Note: It is guaranteed that there is a repeating element present in the array.
 *
 * Examples:
 *
 * Input: arr[] = [1, 3, 2, 3, 4]
 * Output: 3
 * Explanation: The number 3 is the only repeating element.
 * Input: arr[] = [1, 5, 1, 2, 3, 4]
 * Output: 1
 * Explanation: The number 1 is the only repeating element.
 * Input: arr[] = [1, 1]
 * Output: 1
 * Explanation: The array is of size 2 with both elements being 1, making 1 the repeating element.
 * Constraints:
 * 2 ≤ arr.size() ≤ 105
 * 1 ≤ arr[i] ≤ n-1
 */
public class FindOnlyRepetitiveElement {
    public static void main(String[] args) {
        int[] sample1 = {1, 3, 2, 3, 4};
        int[] sample2 = {1, 5, 1, 2, 3, 4};
        int[] sample3 = {1, 1};
        System.out.println(findDuplicate(sample3));
    }

    /* Better approach */
    public static int findDuplicate(int[] arr) {
        int n = arr.length;
        int sum = IntStream.range(1, n + 1).sum();
        int actualSum = IntStream.of(arr).sum();
        int diff = sum - actualSum;
        return n - diff;
    }

    public static int findDuplicate_1(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int ele : arr) {
            if (set.contains(ele)) {
                return ele;
            }
            set.add(ele);
        }
        return -1;
    }
}
