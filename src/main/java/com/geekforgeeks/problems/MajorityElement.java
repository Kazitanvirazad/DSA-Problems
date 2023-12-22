package com.geekforgeeks.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given an array A of N elements. Find the majority element in the array. A
 * majority element in an array A of size N is an element that appears strictly
 * more than N/2 times in the array.
 * 
 * 
 * Example 1:
 * 
 * Input: N = 3 A[] = {1,2,3} Output: -1 Explanation: Since, each element in
 * {1,2,3} appears only once so there is no majority element. Example 2:
 * 
 * Input: N = 5 A[] = {3,1,3,3,2} Output: 3 Explanation: Since, 3 is present
 * more than N/2 times, so it is the majority element.
 * 
 * Your Task: The task is to complete the function majorityElement() which
 * returns the majority element in the array. If no majority exists, return -1.
 * 
 * 
 * Expected Time Complexity: O(N). Expected Auxiliary Space: O(1).
 * 
 * 
 * Constraints: 1 ≤ N ≤ 107 0 ≤ Ai ≤ 106
 */
public class MajorityElement {

	public static void main(String[] args) {

//		int A[] = {3,1,3,3,2};	//3
//		int N=5;
//		int A[] = { 1, 2, 3 }; // -1
//		int N = 3;
		int[] A = { 15 };
		int N = 1;

		System.out.println(majorityElement(A, N));
	}

	public static int majorityElement(int a[], int size) {
		int threshold = size / 2;
		int majorityElement = -1;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else {
				map.put(a[i], 1);
			}
			if (map.get(a[i]) > threshold) {
				majorityElement = a[i];
				return majorityElement;
			}
		}

		Iterator<Integer> itr = map.keySet().iterator();

		while (itr.hasNext()) {
			int key = itr.next();
			if (map.get(key) > threshold) {
				majorityElement = key;
				return majorityElement;
			}
		}
		return majorityElement;
	}

}
