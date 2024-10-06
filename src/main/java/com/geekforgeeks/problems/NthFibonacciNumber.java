package com.geekforgeeks.problems;

/**
 * Given a positive integer n, find the nth fibonacci number. Since the answer can be very large,
 * return the answer modulo 1000000007.
 *
 * Note: for the reference of this question take first fibonacci number to be 1.
 *
 * Examples :
 *
 * Input: n = 2
 * Output: 1
 * Explanation: 1 is the 2nd number of fibonacci series.
 * Input: n = 5
 * Output: 5
 * Explanation: 5 is the 5th number of fibonacci series.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(n)
 */
public class NthFibonacciNumber {

    public static void main(String[] args) {
        int n = 14521;
        System.out.println(nthFibonacci(n));
    }

    public static int nthFibonacci(int n) {
        if (n < 3) {
            return 1;
        }
        int n1 = 1, n2 = 1, n3 = 0, mod = 1000000007;

        for (int i = 2; i < n; ++i) {
            n3 = (n1 + n2) % mod;
            n1 = n2;
            n2 = n3;
        }
        return n3 % mod;
    }
}
