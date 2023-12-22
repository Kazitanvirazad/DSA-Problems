package com.geekforgeeks.problems;

/**
 * 
 * Given an array A of n positive numbers. The task is to find the first
 * equilibrium point in an array. Equilibrium point in an array is a position
 * such that the sum of elements before it is equal to the sum of elements after
 * it.
 * 
 * Note: Return equilibrium point in 1-based indexing. Return -1 if no such
 * point exists.
 * 
 * Example 1:
 * 
 * Input: n = 5 A[] = {1,3,5,2,2} Output: 3 Explanation: equilibrium point is at
 * position 3 as sum of elements before it (1+3) = sum of elements after it
 * (2+2). Example 2:
 * 
 * Input: n = 1 A[] = {1} Output: 1 Explanation: Since there's only element
 * hence its only the equilibrium point. Your Task: The task is to complete the
 * function equilibriumPoint() which takes the array and n as input parameters
 * and returns the point of equilibrium.
 * 
 * Expected Time Complexity: O(n) Expected Auxiliary Space: O(1)
 * 
 * Constraints: 1 <= n <= 105 1 <= A[i] <= 109
 *
 */
public class EquilibriumPoint {

	public static void main(String[] args) {
		int arr[] = { 1, 7, 3, 6, 5, 6 };
//		int[] arr = { 1, 3, 5, 2, 2 };
//		int[] arr = { 1 };
		System.out.println(equilibriumPoint(arr));
	}

	public static int equilibriumPoint(int[] arr) {

		int equilibriumPoint = -1;
		if (arr.length == 1) {
			return arr.length;
		}

		int sum = getSum(arr);
		int rightSum = sum;
		int leftSum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				leftSum = 0;
			} else {
				leftSum += arr[i - 1];
			}
			rightSum = i == 0 ? sum : (sum - (leftSum + arr[i]));

			if (leftSum == rightSum) {
				equilibriumPoint = i + 1;
				break;
			}
		}

		return equilibriumPoint;
	}

	public static int getSum(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}

}
