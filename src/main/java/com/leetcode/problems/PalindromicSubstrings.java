package com.leetcode.problems;

/**
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        if (n < 1) {
            return 0;
        }
        int counter = 0;
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                int low = i;
                int high = i + j;
                while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                    int currentLength = high - low + 1;
                    if (currentLength > maxLength) {
                        counter++;
                    }
                    low--;
                    high++;
                }
            }
        }
        return counter + s.length();
    }
}
