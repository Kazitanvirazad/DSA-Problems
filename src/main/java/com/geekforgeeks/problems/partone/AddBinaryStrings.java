package com.geekforgeeks.problems.partone;

/**
 * Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after
 * adding the two Binary Strings.
 * Note: The input strings may contain leading zeros but the output string should not have any leading zeros.
 *
 * Input: s1 = "1101", s2 = "111"
 * Output: 10100
 * Explanation:
 *  1101
 * + 111
 * 10100
 * Input: s1 = "00100", s2 = "010"
 * Output: 110
 * Explanation:
 *   100
 * +  10
 *   110
 */
public class AddBinaryStrings {
    public static void main(String[] args) {
        String s1 = "1101", s2 = "111";
//        String s1 = "00100", s2 = "010";
        System.out.println(addBinary(s1, s2));
    }

    public static String addBinary(String s1, String s2) {
        int s1Index = s1.length() - 1;
        int s2Index = s2.length() - 1;
        int carry = 0;
        String totalSum = "";
        while (s1Index >= 0 || s2Index >= 0) {
            int s1Val = s1Index >= 0 ? s1.charAt(s1Index--) - '0' : 0;
            int s2Val = s2Index >= 0 ? s2.charAt(s2Index--) - '0' : 0;
            int sum = s1Val + s2Val + carry;
            if (sum == 0 || sum == 1) {
                carry = 0;
                totalSum = sum + totalSum;
            } else if (sum == 2) {
                carry = 1;
                totalSum = "0" + totalSum;
            } else {
                carry = 1;
                totalSum = "1" + totalSum;
            }
        }
        if (carry == 1) {
            totalSum = carry + totalSum;
        }
        return trimLeadingZeros(totalSum);
    }

    private static String trimLeadingZeros(String binary) {
        int index = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                index++;
            } else {
                return binary.substring(index);
            }
        }
        return binary;
    }
}
