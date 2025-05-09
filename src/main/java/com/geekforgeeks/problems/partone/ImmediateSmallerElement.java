package com.geekforgeeks.problems.partone;

/**
 * 
 * Given an integer array Arr of size N. For each element in the array, check
 * whether the right adjacent element (on the next immediate position) of the
 * array is smaller. If next element is smaller, update the current index to
 * that element. If not, then -1.
 * 
 * Example 1:
 * 
 * Input: N = 5 Arr[] = {4, 2, 1, 5, 3} Output: 2 1 -1 3 -1 Explanation: Array
 * elements are 4, 2, 1, 5 3. Next to 4 is 2 which is smaller, so we print 2.
 * Next of 2 is 1 which is smaller, so we print 1. Next of 1 is 5 which is
 * greater, so we print -1. Next of 5 is 3 which is smaller, so we print 3. Note
 * that for last element, output is always going to be -1 because there is no
 * element on right. Example 2:
 * 
 * Input: N = 6 Arr[] = {5, 6, 2, 3, 1, 7} Output: -1 2 -1 1 -1 -1 Explanation:
 * Next to 5 is 6 which is greater, so we print -1.Next of 6 is 2 which is
 * smaller, so we print 2. Next of 2 is 3 which is greater, so we print -1. Next
 * of 3 is 1 which is smaller, so we print 1. Next of 1 is 7 which is greater,
 * so we print -1. Note that for last element, output is always going to be -1
 * because there is no element on right. Your Task: You don't need to read input
 * or print anything. Your task is to complete the function immediateSmaller()
 * which takes the array of integers arr and n as parameters. You need to change
 * the array itself.
 * 
 * Expected Time Complexity: O(N) Expected Auxiliary Space: O(1)
 *
 */
public class ImmediateSmallerElement {
	public static void main(String[] args) {
//		int n = 5;
//		int arr[] = { 4, 2, 1, 5, 3 };
		int n = 6;
		int arr[] = { 5, 6, 2, 3, 1, 7 };
		immediateSmaller(arr, n);
		for (int i : arr)
			System.out.print(i + " ");
	}

	public static void immediateSmaller(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			if (i + 1 == n) {
				arr[i] = -1;
				break;
			}
			if (arr[i] > arr[i + 1]) {
				arr[i] = arr[i + 1];
			} else {
				arr[i] = -1;
			}
		}
	}
}
