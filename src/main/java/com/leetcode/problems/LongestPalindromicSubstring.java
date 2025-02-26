package com.leetcode.problems;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        int start = 0;
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                int low = i;
                int high = i + j;
                while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                    int currentLength = high - low + 1;
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        start = low;
                    }
                    low--;
                    high++;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}
