package com.geekforgeeks.problems.partone;

/**
 * Given a number and its reverse. Find that number raised to the power of its own reverse.
 * Note: As answers can be very large, print the result modulo 109 + 7.
 *
 * Example 1:
 *
 * Input:
 * N = 2, R = 2
 * Output: 4
 * Explanation: The reverse of 2 is 2 and after raising power of 2 by 2 we get 4 which gives remainder as 4
 * when divided by 1000000007.
 * Example 2:
 *
 * Input:
 * N = 12, R = 21
 * Output: 864354781
 * Explanation: The reverse of 12 is 21and 1221 when divided by 1000000007 gives remainder as 864354781.
 * Your Task:
 * You don't need to read input or print anything. You just need to complete the function pow() that takes two
 * parameters N and R denoting the input number and its reverse and returns power of (N to R)mod(109 + 7).
 *
 * Expected Time Complexity: O(LogN).
 * Expected Auxiliary Space: O(LogN).
 */
public class PowerOfNumbers {
    public static void main(String[] args) {
        PowerOfNumbers powerOfNumbers = new PowerOfNumbers();
        System.out.println(powerOfNumbers.power(12, 21));
    }

    public long power(int N, int R) {
        int mod = 1000000007;
        long temp;
        if (R == 0)
            return 1L;
        temp = power(N, R / 2);
        if (R % 2 == 0)
            return (temp * temp) % mod;
        else
            return (((temp * temp) % mod) * N) % mod;

//        long res = 1;
//        long base = N;
//        long exponent = R;
//
//        if (exponent < 3) {
//            return (long) Math.pow(base, exponent);
//        }
//
//        while (exponent >= 3) {
//            System.out.println("loop");
//            long power = (long) Math.pow(base, 3) % mod;
//            res = (res * power) % mod;
//            exponent -= 3;
//        }
//
//        if (exponent > 0) {
//            long power = (long) Math.pow(base, exponent);
//            res = (res * power) % mod;
//        }
//
//        return res % mod;
    }
}
