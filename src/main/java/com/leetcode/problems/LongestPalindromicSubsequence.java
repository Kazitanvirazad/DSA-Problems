package com.leetcode.problems;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without
 * changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        Integer[][] dynamicTable = new Integer[s.length()][s.length()];
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return lcs(s, reversed.toString(), s.length() - 1, s.length() - 1, dynamicTable);
    }

    private int lcs(String textA, String textB, int positionA, int positionB, Integer[][] dynamicTable) {
        if (positionA < 0 || positionB < 0) {
            return 0;
        }
        if (dynamicTable[positionA][positionB] != null) {
            return dynamicTable[positionA][positionB];
        }
        if (textA.charAt(positionA) == textB.charAt(positionB)) {
            dynamicTable[positionA][positionB] = 1 + lcs(textA, textB, positionA - 1, positionB - 1, dynamicTable);
        } else {
            dynamicTable[positionA][positionB] = Math.max(
                    lcs(textA, textB, positionA - 1, positionB, dynamicTable),
                    lcs(textA, textB, positionA, positionB - 1, dynamicTable));
        }
        return dynamicTable[positionA][positionB];
    }
}
