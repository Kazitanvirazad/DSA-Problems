package com.geekforgeeks.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given two arrays a[] and b[] of size n and m respectively. The task is to
 * find the number of elements in the union between these two arrays.
 * 
 * Union of the two arrays can be defined as the set containing distinct
 * elements from both the arrays. If there are repetitions, then only one
 * occurrence of element should be printed in the union.
 * 
 * Note : Elements are not necessarily distinct.
 * 
 * Example 1:
 * 
 * Input: 5 3 1 2 3 4 5 1 2 3 Output: 5 Explanation: 1, 2, 3, 4 and 5 are the
 * elements which comes in the union set of both arrays. So count is 5. Example
 * 2:
 * 
 * Input: 6 2 85 25 1 32 54 6 85 2 Output: 7 Explanation: 85, 25, 1, 32, 54, 6,
 * and 2 are the elements which comes in the union set of both arrays. So count
 * is 7. Your Task: Complete doUnion function that takes a, n, b, m as
 * parameters and returns the count of union elements of the two arrays. The
 * printing is done by the driver code.
 * 
 * Constraints: 1 ≤ n, m ≤ 105 0 ≤ a[i], b[i] < 105
 * 
 * Expected Time Complexity : O(n+m) Expected Auxilliary Space : O(n+m)
 */
public class UnionOfTwoArrays {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 1, 2, 3 };
//		int[] arr1 = { 85, 25, 1, 32, 54, 6 };
//		int[] arr2 = { 85, 2 };
		System.out.println(doUnion(arr1, arr1.length, arr2, arr2.length));
	}

	public static int doUnion(int a[], int n, int b[], int m) {
		int len1 = 0;
		int len2 = 0;
		Set<Integer> set = new HashSet<>();

		while (len1 < n || len2 < m) {
			if (len1 < n) {
				set.add(a[len1]);
				len1++;
			}
			if (len2 < m) {
				set.add(b[len2]);
				len2++;
			}
		}
		return set.size();

	}
}
