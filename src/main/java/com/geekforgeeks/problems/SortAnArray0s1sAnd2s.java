package com.geekforgeeks.problems;

//import java.util.*;

/**
 * Given an array of size N containing only 0s, 1s, and 2s; sort the array in
 * ascending order. Input: N = 5 arr[]= {0 2 1 2 0} Output: 0 0 1 2 2
 * Explanation: 0s 1s and 2s are segregated into ascending order. Expected Time
 * Complexity: O(N) Expected Auxiliary Space: O(1)
 */
public class SortAnArray0s1sAnd2s {
	public static void main(String[] args) {
		int arr[] = { 0, 2, 1, 2, 0 };
		int n = 5;
		sort012(arr, n);
		for (int i : arr)
			System.out.print(i + " ");
	}

	public static void sort012(int a[], int n) {
		int lowcount = 0;
		int midcount = 0;
		int highcount = 0;

		for (int i = 0; i < n; i++) {
			if (a[i] < 1) {
				lowcount++;
			} else if (a[i] == 1) {
				midcount++;
			} else {
				highcount++;
			}
		}
		for (int i = 0; i < n; i++) {
			if (lowcount != 0) {
				a[i] = 0;
				lowcount--;
				continue;
			}
			if (midcount != 0) {
				a[i] = 1;
				midcount--;
				continue;
			}
			if (highcount != 0) {
				a[i] = 2;
				highcount--;
				continue;
			}
		}

//		for (int i = 0; i < n; i++) {
//			if (a[i] < mid) {
//
//			} else if (a[i] == mid) {
//
//			} else {
//
//			}
//		}

	}
}
