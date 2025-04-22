package com.geekforgeeks.problems.partone;

/**
 * Given an unsorted array arr[] of size N. Rotate the array to the left
 * (counter-clockwise direction) by D steps, where D is a positive integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: N = 5, D = 2 arr[] = {1,2,3,4,5} Output: 3 4 5 1 2 Explanation: 1 2 3
 * 4 5 when rotated by 2 elements, it becomes 3 4 5 1 2. Example 2:
 * 
 * Input: N = 10, D = 3 arr[] = {2,4,6,8,10,12,14,16,18,20} Output: 8 10 12 14
 * 16 18 20 2 4 6 Explanation: 2 4 6 8 10 12 14 16 18 20 when rotated by 3
 * elements, it becomes 8 10 12 14 16 18 20 2 4 6.
 * 
 * 
 * Your Task: Complete the function rotateArr() which takes the array, D and N
 * as input parameters and rotates the array by D elements. The array must be
 * modified in-place without using extra space.
 * 
 * 
 * 
 * Expected Time Complexity: O(N) Expected Auxiliary Space: O(1)
 * 
 * 
 * 
 * Constraints: 1 <= N <= 106 1 <= D <= 106 0 <= arr[i] <= 105
 */
public class RotateArray {
	public static void main(String[] args) {
//		int N = 5, D = 2;
//		int arr[] = { 1, 2, 3, 4, 5 };
		int N = 10, D = 13;
		int arr[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		rotateArr(arr, D, N);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	// Function to rotate an array by d elements in counter-clockwise direction.
	public static void rotateArr(int arr[], int d, int n) {
		int[] newArr = new int[n];
		for (int i = 0; i < n; i++) {
			int newPositionIndex = rotate(i, n, d);
			newArr[newPositionIndex] = arr[i];
		}

		for (int i = 0; i < n; i++) {
			arr[i] = newArr[i];
		}
	}

	public static int rotate(int i, int n, int c) {
		int count = c;
		if (n >= count) {
			if ((i - count) < 0) {
				return n - count + i;
			} else {
				return i - count;
			}
		}
		int res = i - count;

		while (res < 0) {
			res += n;
			if (res > 0 && res <= n)
				break;
		}
		return res;
	}
}
