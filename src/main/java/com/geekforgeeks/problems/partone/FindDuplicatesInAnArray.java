package com.geekforgeeks.problems.partone;

import java.util.ArrayList;

/**
 * Given an array a[] of size N which contains elements from 0 to N-1, you need
 * to find all the elements occurring more than once in the given array. Return
 * the answer in ascending order.
 * 
 * Note: The extra space is only for the array to be returned. Try and perform
 * all operations within the provided array.
 * 
 * Example 1:
 * 
 * Input: N = 4 a[] = {0,3,1,2} Output: -1 Explanation: N=4 and all elements
 * from 0 to (N-1 = 3) are present in the given array. Therefore output is -1.
 *
 * Example 2:
 * 
 * Input: N = 5 a[] = {2,3,1,2,3} Output: 2 3 Explanation: 2 and 3 occur more
 * than once in the given array.
 * 
 * Your Task: Complete the function duplicates() which takes array a[] and n as
 * input as parameters and returns a list of elements that occur more than once
 * in the given array in a sorted manner. If no such element is found, return
 * list containing [-1].
 * 
 * Expected Time Complexity: O(n). Expected Auxiliary Space: O(n).
 * 
 * Constraints: 1 <= N <= 105 0 <= A[i] <= N-1, for each valid i
 */
public class FindDuplicatesInAnArray {
	public static void main(String[] args) {
		int a[] = { 0, 3, 1, 2 };
		int[] b = { 2, 3, 1, 2, 3 };
		int m = 5;
		int n = 4;
		ArrayList<Integer> list = duplicates(b, m);
		for (Integer i : list) {
			System.out.print(i + " ");
		}

	}

	public static ArrayList<Integer> duplicates(int arr[], int n) {
		ArrayList<Integer> reslist = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			arr[arr[i] % n] = arr[arr[i] % n] + n;
		}

		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int i = 0; i < n; i++) {
			if (arr[i] >= n * 2) {
				reslist.add(i);
			}
		}

		if (reslist.size() == 0) {
			reslist.add(-1);
		}
		return reslist;
	}
}
