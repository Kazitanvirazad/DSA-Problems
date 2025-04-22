package com.geekforgeeks.problems.partone;

import java.util.Stack;

/**
 * You are given a histogram represented by an array arr, where each element of the array denotes the height of the
 * bars in the histogram. All bars have the same width of 1 unit.
 *
 * Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be
 * formed using a number of contiguous bars.
 *
 * Examples:
 *
 * Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
 *  Largest-Rectangular-Area-in-a-Histogram
 * Output: 100
 * Explanation: We get the maximum by picking bars highlighted above in green (50, and 60). The area is computed
 * (smallest height) * (no. of the picked bars) = 50 * 2 = 100.
 * Input: arr[] = [3, 5, 1, 7, 5, 9]
 * Output: 15
 * Explanation:  We get the maximum by picking bars 7, 5 and 9. The area is computed
 * (smallest height) * (no. of the picked bars) = 5 * 3 = 15.
 * Input: arr[] = [3]
 * Output: 3
 * Explanation: In this example the largest area would be 3 of height 3 and width 1.
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * 0 ≤ arr[i] ≤ 104
 */
public class HistogramMaxRectangularArea {
    public static void main(String[] args) {
        int[] arr1 = {60, 20, 50, 40, 10, 50, 60};
        int[] arr2 = {3, 5, 1, 7, 5, 9};
        int[] arr3 = {3};
        System.out.println(getMaxArea(arr1));
    }

    public static int getMaxArea(int[] arr) {
        int finalArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            // check area for top element of the stack x current index if stack is empty or current index - stack top index - 1
            while (!stack.empty() && arr[stack.peek()] >= arr[i]) {
                int currentIndex = stack.pop();
                int area = arr[currentIndex] * (stack.empty() ? i : (i - stack.peek() - 1));
                finalArea = Math.max(finalArea, area);
            }
            // else push current index in to the stack
            stack.push(i);
        }

        // process remaining elements in the stack
        while (!stack.empty()) {
            int currentIndex = stack.pop();
            int area = arr[currentIndex] * (stack.empty() ? arr.length : (arr.length - stack.peek() - 1));
            finalArea = Math.max(finalArea, area);
        }
        return finalArea;
    }
}
