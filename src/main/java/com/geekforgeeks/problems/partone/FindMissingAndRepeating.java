package com.geekforgeeks.problems.partone;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * Given an unsorted array Arr of size N of positive integers. One number 'A'
 * from set {1, 2,....,N} is missing and one number 'B' occurs twice in array.
 * Find these two numbers.
 * 
 * Example 1:
 * 
 * Input: N = 2 Arr[] = {2, 2} Output: 2 1 Explanation: Repeating number is 2
 * and smallest positive missing number is 1. Example 2:
 * 
 * Input: N = 3 Arr[] = {1, 3, 3} Output: 3 2 Explanation: Repeating number is 3
 * and smallest positive missing number is 2. Your Task: You don't need to read
 * input or print anything. Your task is to complete the function
 * findTwoElement() which takes the array of integers arr and n as parameters
 * and returns an array of integers of size 2 denoting the answer ( The first
 * index contains B and second index contains A.)
 * 
 * Expected Time Complexity: O(N) Expected Auxiliary Space: O(1)
 * 
 * Constraints: 2 ≤ N ≤ 105 1 ≤ Arr[i] ≤ N
 */
public class FindMissingAndRepeating {

	public static void main(String[] args) {
//		int arr[] = { 1, 3, 3 };
//		int arr[] = { 2, 2 };
//		int[] arr = { 13, 33, 43, 16, 25, 19, 23, 31, 29, 35, 10, 2, 32, 11, 47, 15, 34, 46, 30, 26, 41, 18, 5, 17, 37,
//				39, 6, 4, 20, 27, 9, 3, 8, 40, 24, 44, 14, 36, 7, 38, 12, 1, 42, 12, 28, 22, 45 };
		int[] arr = { 12, 7, 5, 1, 13, 10, 8, 11, 9, 2, 4, 3, 6, 1 };
		int resArr[] = findTwoElement(arr, arr.length);
		for (int i : resArr) {
			System.out.print(i + " ");
		}
	}

	public static int[] findTwoElement(int arr[], int n) {
		int resArr[] = new int[2];

		Set<Integer> set = new TreeSet<>();

		int actualSum = 0;
		int elementRangeSum = 0;

		for (int i = 0; i < arr.length; i++) {
			elementRangeSum += (i + 1);

			if (set.contains(arr[i])) {
				// Adding repeating element
				resArr[0] = arr[i];
			} else {
				set.add(arr[i]);
				actualSum += arr[i];// (i + 1);
			}
		}

		// Adding missing element
		resArr[1] = elementRangeSum - actualSum;

		return resArr;
	}
}
