package com.geekforgeeks.problems.partone;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of N integers, and an integer K, find the number of pairs of
 * elements in the array whose sum is equal to K.
 * 
 * 
 * Example 1:
 * 
 * Input: N = 4, K = 6 arr[] = {1, 5, 7, 1} Output: 2 Explanation: arr[0] +
 * arr[1] = 1 + 5 = 6 and arr[1] + arr[3] = 5 + 1 = 6.
 * 
 * Example 2:
 * 
 * Input: N = 4, K = 2 arr[] = {1, 1, 1, 1} Output: 6 Explanation: Each 1 will
 * produce sum 2 with any 1.
 * 
 * Your Task: You don't need to read input or print anything. Your task is to
 * complete the function getPairsCount() which takes arr[], n and k as input
 * parameters and returns the number of pairs that have sum K.
 * 
 * 
 * Expected Time Complexity: O(N) Expected Auxiliary Space: O(N)
 * 
 * Constraints: 1 <= N <= 105 1 <= K <= 108 1 <= Arr[i] <= 106
 */
public class CountPairsWithGivenSum {

	public static void main(String[] args) {
//		int N = 4, K = 2;
//		int arr[] = { 1, 1, 1, 1 };
		int N = 4, K = 6;
		int arr[] = { 1, 5, 7, 1 };
		System.out.println(getPairsCount(arr, N, K));

	}

	public static int getPairsCount(int[] arr, int n, int k) {

		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(k - arr[i])) {
				count += map.get(k - arr[i]);
			}
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}

		}
		return count;
	}

}
