package com.leetcode.problems;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value
 * to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int input = 1534236469;
        System.out.println(reverseInteger.reverse(input));
    }

    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        boolean isNegative = x < 0;
        if (isNegative) {
            x = x * -1;
        }
        x = removeZeroes(x);
        int res;
        res = x % 10;
        x = x / 10;
        try {
            while (x != 0) {
                int nextDecimal = Math.multiplyExact(res, 10);
                res = Math.addExact(nextDecimal, (x % 10));
                x = x / 10;
            }
        } catch (ArithmeticException exception) {
            return 0;
        }
        return isNegative ? res * -1 : res;
    }

    private int removeZeroes(int num) {
        while (num % 10 == 0) {
            num = num / 10;
        }
        return num;
    }
}
