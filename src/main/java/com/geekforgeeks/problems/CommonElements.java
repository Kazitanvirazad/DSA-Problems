package com.geekforgeeks.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 * Given three arrays sorted in increasing order. Find the elements that are
 * common in all three arrays. Note: can you take care of the duplicates without
 * using any additional Data Structure?
 * 
 * Example 1:
 * 
 * Input: n1 = 6; A = {1, 5, 10, 20, 40, 80} n2 = 5; B = {6, 7, 20, 80, 100} n3
 * = 8; C = {3, 4, 15, 20, 30, 70, 80, 120} Output: 20 80 Explanation: 20 and 80
 * are the only common elements in A, B and C.
 * 
 * 
 * Your Task: You don't need to read input or print anything. Your task is to
 * complete the function commonElements() which take the 3 arrays A[], B[], C[]
 * and their respective sizes n1, n2 and n3 as inputs and returns an array
 * containing the common element present in all the 3 arrays in sorted order. If
 * there are no such elements return an empty array. In this case the output
 * will be printed as -1.
 * 
 * 
 * 
 * Expected Time Complexity: O(n1 + n2 + n3) Expected Auxiliary Space: O(n1 + n2
 * + n3)
 * 
 * 
 * 
 * Constraints: 1 <= n1, n2, n3 <= 10^5 The array elements can be both positive
 * or negative integers.
 */
public class CommonElements {

	public static void main(String[] args) {
		int[] A = { 1, 5, 10, 20, 40, 80 };
		int[] B = { 6, 7, 20, 80, 100 };
		int[] C = { 3, 4, 15, 20, 30, 70, 80, 120 };
		List<Integer> res = commonElements(A, B, C, A.length, B.length, C.length);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	public static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
		ArrayList<Integer> list = new ArrayList<>();

		SortedSet<Integer> setA = new TreeSet<>();
		SortedSet<Integer> setB = new TreeSet<>();
		SortedSet<Integer> setC = new TreeSet<>();

		int lengthA = 0;
		int lengthB = 0;
		int lengthC = 0;

		while (lengthA < n1 || lengthB < n2 || lengthC < n3) {
			if (lengthA < n1) {
				setA.add(A[lengthA]);
				lengthA++;
			}

			if (lengthB < n2) {
				setB.add(B[lengthB]);
				lengthB++;
			}

			if (lengthC < n3) {
				setC.add(C[lengthC]);
				lengthC++;
			}

		}

		Iterator<Integer> iterator = setA.iterator();

		while (iterator.hasNext()) {
			Integer currentElement = iterator.next();
			if (setA.contains(currentElement) && setB.contains(currentElement) && setC.contains(currentElement)) {
				list.add(currentElement);
			}
		}

		if (list.size() == 0) {
			list.add(-1);
		}
		return list;
	}

}
