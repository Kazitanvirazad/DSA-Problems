package com.geekforgeeks.problems.partone;

/**
 * A string str is given to represent a positive number. The task is to round str to the nearest multiple of 10.
 * If you have two multiples equally apart from str, choose the smallest element among them.
 *
 * Examples:
 *
 * Input: str = 29
 * Output: 30
 * Explanation: Close multiples are 20 and 30, and 30 is the nearest to 29.
 * Input: str = 15
 * Output: 10
 * Explanation: 10 and 20 are equally distant multiples from 20. The smallest of the two is 10.
 * Expected Time Complexity: O(n).
 * Expected Auxiliary Space: O(1).
 */
public class NearestMultipleOf10 {
    public static void main(String[] args) {
        NearestMultipleOf10 multiple = new NearestMultipleOf10();
        String str1 = "28";
        System.out.println(multiple.roundToNearest(str1));
    }

    public String roundToNearest(String str) {
        int lastDigit = str.charAt(str.length() - 1) - '0';
        if (lastDigit == 0) {
            return str;
        }
        if (str.length() == 1) {
            return lastDigit > 5 ? "10" : "0";
        }
        String res = "";
        int carry;
        if (lastDigit > 5) {
            // go for next multiple of 10
            int diff = lastDigit;
            diff = 10 - diff;
            int sum = diff + lastDigit;
            res = (sum % 10) + res;
            carry = sum / 10;
            for (int i = str.length() - 2; i > -1; i--) {
                sum = carry + (str.charAt(i) - '0');
                res = (sum % 10) + res;
                carry = sum / 10;
            }
            return res;
        } else {
            // go for previous multiple of 10
            str = str.substring(0, str.length() - 1);
            str += "0";
            return str;
        }
    }
}
