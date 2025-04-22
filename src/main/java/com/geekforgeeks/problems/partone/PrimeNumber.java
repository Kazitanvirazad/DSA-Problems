package com.geekforgeeks.problems.partone;

/**
 * For a given number n check if it is prime or not. A prime number is a number which is only divisible by 1 and itself.
 *
 * Examples :
 *
 * Input: n = 5
 * Output: 1
 * Explanation: 5 has 2 factors 1 and 5 only.
 * Input: n = 25
 * Output: 0
 * Explanation: 25 has 3 factors 1, 5, 25
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function isPrime() which takes
 * an integer n as input parameters and returns an integer, 1 if n is a prime number or 0 otherwise.
 *
 * Expected Time Complexity: O(sqrt(n))
 * Expected Space Complexity: O(1)
 */
public class PrimeNumber {
    public static int isPrime(int N) {
        if (N == 0 || N == 1) {
            return 0;
        }

        if (N == 2 || N == 3) {
            return 1;
        }

        boolean isPrime = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                isPrime = false;
                break;
            }
        }

        return !isPrime ? 0 : 1;
    }
}
