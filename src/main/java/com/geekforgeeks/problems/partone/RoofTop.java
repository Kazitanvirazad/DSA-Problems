package com.geekforgeeks.problems.partone;

/**
 * You are given the heights of consecutive buildings. You can move from the roof of a building to the
 * roof of the next adjacent building. You need to find the maximum number of consecutive steps you can
 * put forward such that you gain an increase in altitude with each step.
 *
 * Examples:
 *
 * Input: arr[] = [1, 2, 2, 3, 2]
 * Output: 1
 * Explanation: 1, 2, or 2, 3 are the only consecutive buildings with increasing heights thus maximum number
 * of consecutive steps with an increase in gain in altitude would be 1 in both cases.
 * Input: arr[] = [1, 2, 3, 4]
 * Output: 3
 * Explanation: 1 to 2 to 3 to 4 is the jump of length 3 to have a maximum number of buildings with increasing
 * heights, so maximum steps with increasing altitude becomes 3.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class RoofTop {
    public static void main(String[] args) {
        int[] arr1 = {20, 6, 5, 10, 7, 17, 19, 4, 17, 2, 18, 12, 16, 11};
        int[] arr2 = {18, 10, 5, 10, 3, 14, 7, 6, 5};
        int[] arr3 = {10, 11, 2, 15, 7, 11, 16, 19};
        System.out.println(maxStep(arr1));
    }

    public static int maxStep(int arr[]) {
        int lastMaxElement = arr[0];
        int steps = 0;
        int maxSteps = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > lastMaxElement) {
                lastMaxElement = arr[i];
                steps++;
            } else if (arr[i] <= lastMaxElement) {
                if (maxSteps <= steps) {
                    maxSteps = steps;
                }
                lastMaxElement = arr[i];//Integer.MIN_VALUE;
                steps = 0;
            }
        }
        if (maxSteps <= steps) {
            maxSteps = steps;
        }
        return maxSteps;
    }
}
