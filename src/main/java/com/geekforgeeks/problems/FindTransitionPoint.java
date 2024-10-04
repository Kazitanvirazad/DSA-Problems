package com.geekforgeeks.problems;

/**
 * Given a sorted array containing only 0s and 1s, find the transition point, i.e., the first index where 1 was observed,
 * and before that, only 0 was observed.
 *
 * Example 1:
 *
 * Input:
 * N = 5
 * arr[] = {0,0,0,1,1}
 * Output: 3
 * Explanation: index 3 is the transition
 * point where 1 begins.
 * Example 2:
 *
 * Input:
 * N = 4
 * arr[] = {0,0,0,0}
 * Output: -1
 * Explanation: Since, there is no "1",
 * the answer is -1.
 * Your Task:
 * You don't need to read input or print anything. The task is to complete the function transitionPoint() that takes array
 * arr and N as input parameters and returns the 0-based index of the position where 0 ends and 1 begins. If array does not
 * have any 1, return -1. If array does not have any 0, return 0.
 *
 * Expected Time Complexity: O(Log(N))
 * Expected Auxiliary Space: O(1)
 */
public class FindTransitionPoint {
    public static void main(String[] args) {
        int arr[] = {0, 0, 0, 0};
        FindTransitionPoint findTransitionPoint = new FindTransitionPoint();
        System.out.println(findTransitionPoint.transitionPoint(arr, arr.length));
    }

    int transitionPoint(int arr[], int n) {
        if (n == 1) {
            if (arr[0] == 1) {
                return 0;
            } else {
                return -1;
            }
        }
        if (arr[n - 1] == 0) {
            return -1;
        }

        int startIndex = 0;
        int lastIndex = n - 1;

        while (startIndex < n && lastIndex >= 0) {
            if (arr[startIndex] == 1) {
                return startIndex;
            }
            if (arr[lastIndex] == 0) {
                return lastIndex + 1;
            }
            startIndex++;
            lastIndex--;
        }
        return -1;
    }
}
