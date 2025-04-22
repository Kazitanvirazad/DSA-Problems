package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an unsorted array arr containing both positive and negative numbers. Your task is to create an
 * array of alternate positive and negative numbers without changing the relative order of positive
 * and negative numbers.
 * <p>
 * Note: Array should start with a positive number and 0 (zero) should be considered a positive element.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = [9, 4, -2, -1, 5, 0, -5, -3, 2]
 * <p>
 * Output: 9 -2 4 -1 5 -5 0 -3 2
 * <p>
 * Explanation: Positive elements : [9,4,5,0,2]
 * <p>
 * Negative elements : [-2,-1,-5,-3]
 * <p>
 * As we need to maintain the relative order of postive elements and negative elements we will pick
 * each element from the positive and negative and will store them. If any of the positive and negative
 * numbers are completed. we will continue with the remaining signed elements.
 * <p>
 * The output is 9,-2,4,-1,5,-5,0,-3,2.
 * <p>
 * Input: arr[] = [-5, -2, 5, 2, 4, 7, 1, 8, 0, -8]
 * <p>
 * Output: 5 -5 2 -2 4 -8 7 1 8 0
 * <p>
 * Explanation : Positive elements : [5,2,4,7,1,8,0]
 * <p>
 * Negative elements : [-5,-2,-8]
 * <p>
 * The output is 5, -5, 2, -2, 4, -8, 7, 1, 8, 0.
 * <p>
 * Expected Time Complexity: O(n)
 * <p>
 * Expected Auxiliary Space: O(n)
 */
public class AlternatePositiveAndNegativeNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(9, 4, -2, -1, 5, 0, -5, -3, 2));
        print(list1);
        System.out.println("After Rearrange");
        rearrange(list1);
        print(list1);
        System.out.println("====================================");
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(-5, -2, 5, 2, 4, 7, 1, 8, 0, -8));
        print(list2);
        System.out.println("After Rearrange");
        rearrange(list2);
        print(list2);
    }

    public static void rearrange(ArrayList<Integer> arr) {
        Queue<Integer> positiveQueue = new LinkedList<>();
        Queue<Integer> negativeQueue = new LinkedList<>();

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < 0) {
                negativeQueue.add(arr.get(i));
            } else {
                positiveQueue.add(arr.get(i));
            }
        }

        arr.clear();

        while (!positiveQueue.isEmpty() || !negativeQueue.isEmpty()) {
            if (positiveQueue.peek() != null) {
                arr.add(positiveQueue.poll());
            }
            if (negativeQueue.peek() != null) {
                arr.add(negativeQueue.poll());
            }
        }
    }

    public static void print(ArrayList<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
