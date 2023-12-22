package com.geekforgeeks.problems;

/**
 * An element is called a peak element if its value is not smaller than the
 * value of its adjacent elements(if they exists). Given an array arr[] of size
 * N, Return the index of any one of its peak elements. Note: The generated
 * output will always be 1 if the index that you return is correct. Otherwise
 * output will be 0.
 * 
 * 
 * Example 1:
 * 
 * Input: N = 3 arr[] = {1,2,3} Possible Answer: 2 Generated Output: 1
 * Explanation: index 2 is 3. It is the peak element as it is greater than its
 * neighbour 2. If 2 is returned then the generated output will be 1 else 0.
 * Example 2:
 * 
 * Input: N = 3 arr[] = {3,4,2} Possible Answer: 1 Output: 1 Explanation: 4 (at
 * index 1) is the peak element as it is greater than it's neighbor elements 3
 * and 2. If 1 is returned then the generated output will be 1 else 0.
 * 
 * 
 * Your Task: You don't have to read input or print anything. Complete the
 * function peakElement() which takes the array arr[] and its size N as input
 * parameters and return the index of any one of its peak elements.
 * 
 * Can you solve the problem in expected time complexity?
 * 
 * 
 * 
 * Expected Time Complexity: O(log N) Expected Auxiliary Space: O(1)
 * 
 * 
 * Constraints: 1 ≤ N ≤ 105 1 ≤ A[] ≤ 106
 */
public class PeakElement {

	public static void main(String[] args) {
//		int N = 3;
//		int N = 2;
//		int arr[] = { 1, 13 };
//		int arr[] = { 1, 2, 3 };
//		int arr[] = { 3, 4, 2 };
		int N = 4;
		int arr[] = { 1, 2, 2, 1 };
		System.out.println(peakElement(arr, N));
	}

	public static int peakElement(int[] arr, int n) {
		int index = 0;
		if (n == 1)
			return index;
		if (n == 0)
			return index;
		for (int i = 0; i < n; i++) {
			if (i == 0 && arr[i] > arr[i + 1]) {
				index = i;
				break;
			}
			if (i == n - 1 && arr[i] > arr[i - 1]) {
				index = i;
				break;
			}
			if ((i > 0 && arr[i] > arr[i - 1]) && (i < n - 1 && arr[i] >= arr[i + 1])) {
				index = i;
				break;
			}
		}
		return index;
	}
}
