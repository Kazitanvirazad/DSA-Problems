package com.codility.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * class Solution { public int solution(int[] A); } that, given an array A of N
 * integers, returns the smallest positive integer (greater than 0) that does
 * not occur in A. For example, given A = [1, 3, 6, 4, 1, 2], the function
 * should return 5. Given A = [1, 2, 3], the function should return 4. Given A =
 * [−1, −3], the function should return 1. Write an efficient algorithm for the
 * following assumptions: N is an integer within the range [1..100,000]; each
 * element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class SmallestPositiveInteger {

	public static void main(String[] args) {
		int[] A = { 1, 3, 6, 4, 1, 2 };
//		int[] A = { 1, 2, 3 };
//		int[] A = { -1, -3 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {

		List<Integer> sorted = new ArrayList<>() {
			{
				for (Integer i : A) {
					if (isEligible(i) && !contains(i))
						add(i);
				}
			}
		};

		Collections.sort(sorted);

		int smallestNum = 1;
		for (int i = 1; i <= sorted.size() + 1; i++) {
			if (!sorted.contains(i)) {
				smallestNum = i;
			}
		}

		if (sorted.size() == 0)
			return 1;

		return smallestNum;
	}

	public static boolean isEligible(int num) {
		if (num > 0)
			return true;
		return false;
	}

}
