package com.leetcode.problems;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no
 * common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dynamicTable = new Integer[text1.length()][text2.length()];
        return lcs(text1, text2, text1.length() - 1, text2.length() - 1, dynamicTable);
    }

    private int lcs(String textA, String textB, int positionA, int positionB, Integer[][] dynamicTable) {
        if (positionA < 0 || positionB < 0) {
            return 0;
        }
        if (dynamicTable[positionA][positionB] != null) {
            return dynamicTable[positionA][positionB];
        }
        if (textA.charAt(positionA) == textB.charAt(positionB)) {
            dynamicTable[positionA][positionB] = 1 + lcs(textA, textB,
                    positionA - 1, positionB - 1, dynamicTable);
        } else {
            dynamicTable[positionA][positionB] = Math.max(
                    lcs(textA, textB, positionA - 1, positionB, dynamicTable),
                    lcs(textA, textB, positionA, positionB - 1, dynamicTable));
        }
        return dynamicTable[positionA][positionB];
    }
}
