package com.geekforgeeks.problems;

/**
 * Given two integers a and b, write a function lcmAndGcd() to compute their LCM and GCD.
 * The function takes two integers a and b as input and returns a list containing their LCM and GCD.
 *
 * Example 1:
 *
 * Input: a = 5 , b = 10
 * Output: 10 5
 * Explanation: LCM of 5 and 10 is 10, while their GCD is 5.
 * Input: a = 14 , b = 8
 * Output: 56 2
 * Explanation: LCM of 14 and 8 is 56, while their GCD is 2.
 * Expected Time Complexity: O(log(min(a, b))
 * Expected Auxiliary Space: O(1)
 */
public class LCMAndGCD {
    public static void main(String[] args) {
        Long[] lcmAndGcd = lcmAndGcd(14L, 8L);
        System.out.println(lcmAndGcd[0] + " " + lcmAndGcd[1]);
    }

    public static Long[] lcmAndGcd(Long A, Long B) {
        Long[] res = new Long[2];
        res[1] = gcd(A, B);
//        res[1] = gcd_iteration(A, B);
        res[0] = (A * B) / res[1];
        return res;
    }

    // recursion
    public static Long gcd(Long A, Long B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

    // iteration
    public static Long gcd_iteration(Long A, Long B) {
        long temp = 0;
        while (B != 0) {
            temp = B;
            B = A % B;
            A = temp;
        }
        return A;
    }
}
