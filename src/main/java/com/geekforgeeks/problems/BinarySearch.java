package com.geekforgeeks.problems;

/**
 * Given a sorted array of size N and an integer K, find the position(0-based
 * indexing) at which K is present in the array using binary search.
 * 
 * Example 1:
 * 
 * Input: N = 5 arr[] = {1 2 3 4 5} K = 4 Output: 3 Explanation: 4 appears at
 * index 3.
 * 
 * Example 2:
 * 
 * Input: N = 5 arr[] = {11 22 33 44 55} K = 445 Output: -1 Explanation: 445 is
 * not present.
 * 
 * Your Task: You dont need to read input or print anything. Complete the
 * function binarysearch() which takes arr[], N and K as input parameters and
 * returns the index of K in the array. If K is not present in the array, return
 * -1.
 * 
 * 
 * Expected Time Complexity: O(LogN) Expected Auxiliary Space: O(LogN) if
 * solving recursively and O(1) otherwise.
 * 
 * 
 * Constraints:
 * 
 * 1 <= N <= 105 1 <= arr[i] <= 106 1 <= K <= 106
 */
public class BinarySearch {

	public static void main(String[] args) {

		int[] sortedArray = { 2, 6, 7, 9, 13, 44, 56, 78, 88, 89, 92 };
		int k = 13;
		System.out.println(binarysearch(sortedArray, sortedArray.length, k));
	}

	public static int binarysearch(int arr[], int n, int k) {

		int low = 0;
		int mid = (arr.length - 1) / 2;
		int high = arr.length;

		if (arr[low] == k) {
			return low;
		}
		if (arr[high-1] == k) {
			return high-1;
		}
		if (arr[mid] == k) {
			return mid;
		}
		if (k < arr[low] || k > arr[high - 1])
			return -1;

		for (int i = 0; i < arr.length; i++) {

			if (arr[mid] != k && mid - 1 == low && mid + 1 == high)
				return -1;

			if (arr[mid] == k) {
				return mid;
			}
			if (arr[mid] > k) {
				high = mid;
				mid = (mid - low) / 2;
			} else {
				low = mid;
				mid = (high + low) / 2;
			}
		}

		return -1;
	}
}
