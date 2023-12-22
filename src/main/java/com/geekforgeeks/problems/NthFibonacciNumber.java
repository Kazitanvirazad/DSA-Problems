package com.geekforgeeks.problems;

import java.math.BigInteger;

/**
 * 
 * Given a positive integer n, find the nth fibonacci number. Since the answer
 * can be very large, return the answer modulo 1000000007.
 * 
 * Example 1:
 * 
 * Input: n = 2 Output: 1 Explanation: 1 is the 2nd number of fibonacci series.
 * Example 2:
 * 
 * Input: n = 5 Output: 5 Explanation: 5 is the 5th number of fibonacci series.
 * Your Task: You dont need to read input or print anything. Complete the
 * function nthFibonacci() which takes n as input parameter and returns nth
 * fibonacci number.
 * 
 * Expected Time Complexity: O(n) Expected Auxiliary Space: O(n)
 * 
 * Constraints: 1<= n <=105
 *
 */
public class NthFibonacciNumber {

	public static void main(String[] args) {
		int n = 14521;
		System.out.println(nthFibonacci(n));

	}

	/**
	 * 
	 * Formula for finding nth fibonacci number => Xn = [φn – (1-φ)n]/√5 where, φ =
	 * 1.618
	 */
	public static int nthFibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}

		double phi = (1 + Math.sqrt(5)) / 2; // 1.618

//		double fib = Math.round((Math.pow(phi, n) - Math.pow((1 - phi), n)) / Math.sqrt(5));
		Long longValue = Math.round((Math.pow(phi, n) - Math.pow((1 - phi), n)) / Math.sqrt(5));

		System.out.println(longValue);
		System.out.println(Long.MAX_VALUE);
		int ans = longValue.intValue();
		return ans;

	}
}
