package com.geekforgeeks.problems.partone;

/**
 * Given two numbers as strings s1 and s2. Calculate their Product.
 *
 * Note: The numbers can be negative and You are not allowed to use any built-in function or convert the strings to integers.
 * There can be zeros in the begining of the numbers. You don't need to specify '+' sign in the begining of positive numbers.
 *
 * Example 1:
 *
 * Input:
 * s1 = "0033"
 * s2 = "2"
 * Output:
 * 66
 * Example 2:
 *
 * Input:
 * s1 = "11"
 * s2 = "23"
 * Output:
 * 253
 * Your Task: You don't need to read input or print anything. Your task is to complete the function multiplyStrings()
 * which takes two strings s1 and s2 as input and returns their product as a string.
 *
 * Expected Time Complexity: O(n1* n2)
 * Expected Auxiliary Space: O(n1 + n2); where n1 and n2 are sizes of strings s1 and s2 respectively.
 */
public class MultiplyTwoStrings {
    public static void main(String[] args) {
        MultiplyTwoStrings multiply = new MultiplyTwoStrings();
        System.out.println(multiply.multiplyStrings("00000", "-24"));
    }

    public String multiplyStrings(String s1, String s2) {
        boolean isNegativeNumOne = s1.charAt(0) == '-';
        boolean isNegativeNumTwo = s2.charAt(0) == '-';

        if (isNegativeNumOne) {
            s1 = s1.substring(1);
        }
        if (isNegativeNumTwo) {
            s2 = s2.substring(1);
        }

        int[] n1 = new int[s1.length()];
        int[] n2 = new int[s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            n1[i] = s1.charAt(s1.length() - 1 - i) - '0';
        }

        for (int i = 0; i < s2.length(); i++) {
            n2[i] = s2.charAt(s2.length() - 1 - i) - '0';
        }

        int[] result = new int[n1.length + n2.length];

        for (int i = 0; i < n2.length; i++) {
            int carry = 0;
            for (int j = 0; j < n1.length; j++) {
                int product = n1[j] * n2[i] + carry + result[i + j];
                carry = product / 10;
                result[i + j] = product % 10;
            }
            result[i + n1.length] = carry;
        }

        String res = "";
        int i = result.length - 1;
        while (i > 0 && result[i] == 0) {
            i--;
        }
        while (i >= 0) {
            res += result[i--];
        }
        if (res.length() == 1 && res.charAt(0) == '0') {
            return "0";
        }
        return isNegativeNumOne != isNegativeNumTwo ? "-" + res : res;
    }
}