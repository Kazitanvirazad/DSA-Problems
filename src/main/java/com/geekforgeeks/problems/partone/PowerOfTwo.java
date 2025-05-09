package com.geekforgeeks.problems.partone;

/**
 * Given a non-negative integer N. The task is to check if N is a power of 2.
 * More formally, check if N can be expressed as 2x for some integer x.
 * 
 * Example 1:
 * 
 * Input: N = 8 Output: YES Explanation: 8 is equal to 2 raised to 3 (23 = 8).
 * Example 2:
 * 
 * Input: N = 98 Output: NO Explanation: 98 cannot be obtained by any power of
 * 2. Your Task:Your task is to complete the function isPowerofTwo() which takes
 * n as a parameter and returns true or false by checking if the given number
 * can be represented as a power of two or not.
 * 
 * Expected Time Complexity:O(log N). Expected Auxiliary Space:O(1).
 * 
 * Constraints: 0 ≤ N ≤1018
 */
public class PowerOfTwo {

	public static void main(String[] args) {
//		int n = 8;
		int n = 98;
//		int n = 0;
		System.out.println(isPowerofTwo(n));
	}

	public static boolean isPowerofTwo(long n) {
		if (n == 0 || n < 1) {
			return false;
		}
		long logValue = (long) (Math.log(n) / Math.log(2));

		if (Math.pow(2, logValue) == n) {
			return true;
		}
		return false;

	}

}
