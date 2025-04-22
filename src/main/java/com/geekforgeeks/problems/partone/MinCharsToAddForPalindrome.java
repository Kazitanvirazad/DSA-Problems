package com.geekforgeeks.problems.partone;

/**
 * Given a string s, the task is to find the minimum characters to be added at the front to make the
 * string palindrome.
 *
 * Note: A palindrome string is a sequence of characters that reads the same forward and backward.
 *
 * Examples:
 *
 * Input: s = "abc"
 * Output: 2
 * Explanation: Add 'b' and 'c' at front of above string to make it palindrome : "cbabc"
 * Input: s = "aacecaaaa"
 * Output: 2
 * Explanation: Add 2 a's at front of above string to make it palindrome : "aaaacecaaaa"
 * Constraints:
 * 1 <= s.size() <= 106
 */
public class MinCharsToAddForPalindrome {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "aacecaaaa";
        String s3 = "cbabc";
        String s4 = "aacecaaa";
        String s5 = "fxtlsgypsfa";
        System.out.println(minChar(s5));
    }

    public static int minChar(String s) {
        int n = s.length();
        String reverse = new StringBuilder(s).reverse().toString();
        s = s + "$" + reverse;
        int[] lps = getLpsArray(s);
        return n - lps[lps.length - 1];
    }

    private static int[] getLpsArray(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];

        int lengthOfLongestPrefixSuffix = 0;
        int i = 1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(lengthOfLongestPrefixSuffix)) {
                lengthOfLongestPrefixSuffix++;
                lps[i] = lengthOfLongestPrefixSuffix;
                i++;
            } else {
                if (lengthOfLongestPrefixSuffix != 0) {
                    lengthOfLongestPrefixSuffix = lps[lengthOfLongestPrefixSuffix - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
