package com.leetcode.problems;

/**
 * Given a string s, check if it can be constructed by taking a substring of it and appending multiple
 * copies of the substring together.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 * Example 2:
 *
 * Input: s = "aba"
 * Output: false
 * Example 3:
 *
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() < 2) {
            return false;
        }
        char lastChar = s.charAt(s.length() - 1);
        boolean isRepeated = false;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == lastChar && s.charAt(i + 1) == s.charAt(0)) {
                String currentString = s.substring(0, i + 1);
                if (s.length() % currentString.length() != 0) {
                    continue;
                }
                int index = currentString.length();
                while (index < s.length()) {
                    if ((index + currentString.length()) <= s.length() &&
                            !currentString.equals(s.substring(index, index + currentString.length()))) {
                        isRepeated = false;
                        break;
                    } else {
                        isRepeated = true;
                    }
                    index += index;
                }
                if (isRepeated) {
                    break;
                }
            }
        }
        return isRepeated;
    }
}
