package com.geekforgeeks.problems;

/**
 * Given an array arr[] of non-negative integers. Each array element represents the maximum length of
 * the jumps that can be made forward from that element. This means if arr[i] = x, then we can jump any
 * distance y such that y ≤ x.
 * <p>
 * Find the minimum number of jumps to reach the end of the array starting from the first element.
 * If an element is 0, then you cannot move through that element.
 * <p>
 * Note:  Return -1 if you can't reach the end of the array.
 * <p>
 * Examples :
 * <p>
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * <p>
 * Output: 3
 * <p>
 * Explanation:First jump from 1st element to 2nd element with value 3. From here we jump to 5th element with value 9,
 * and from here we will jump to the last.
 * <p>
 * Input: arr = {1, 4, 3, 2, 6, 7}
 * <p>
 * Output: 2
 * <p>
 * Explanation: First we jump from the 1st to 2nd element and then jump to the last element.
 * <p>
 * Input: arr = {0, 10, 20}
 * <p>
 * Output: -1
 * <p>
 * Explanation: We cannot go anywhere from the 1st element.
 * <p>
 * Expected Time Complexity: O(n)
 * <p>
 * Expected Space Complexity: O(1)
 */
public class MinimumJumps {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] arr2 = {1, 4, 3, 2, 6, 7};
        int[] arr3 = {0, 10, 20};
        int[] arr4 = {9, 10, 1, 2, 3, 4, 8, 0, 0, 0, 0, 0, 0, 0, 1};
        int[] arr5 = {9, 10, 1, 2, 3, 4, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(minJumps(arr1));
        System.out.println(minJumps(arr2));
        System.out.println(minJumps(arr3));
        System.out.println(minJumps(arr4));
        System.out.println(minJumps(arr5));
    }

    public static int minJumps(int[] arr) {
        // Return -1 if not possible to jump
        if (arr[0] == 0 || (arr[0] == 1 && arr[1] == 0)) {
            return -1;
        }
        //If value of first index guarantee only 1 jump is needed, return 1
        if (arr[0] >= arr.length - 1) {
            return 1;
        }

        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        for (int i = 1; i < arr.length; i++) {
            // Check if we have reached the end of the array
            if (i == arr.length - 1) {
                return jump;
            }
            //Check if value at current index guarantees jump to end
            if (arr[i] >= (arr.length - 1) - i) {
                return ++jump;
            }

            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0) {
                // we must have used a jump
                jump++;
                // Check if the current index/position or lesser index is the maximum reach point from the previous indexes
                if (i >= maxReach) {
                    return -1;
                }
                // re-initialize the steps to the amount of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }
        return -1;
    }
}
