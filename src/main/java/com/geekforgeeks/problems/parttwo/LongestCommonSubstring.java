package com.geekforgeeks.problems.parttwo;

/**
 * You are given two strings s1 and s2. Your task is to find the length of the longest common substring
 * among the given strings.
 *
 * Examples:
 *
 * Input: s1 = "ABCDGH", s2 = "ACDGHR"
 * Output: 4
 * Explanation: The longest common substring is "CDGH" with a length of 4.
 * Input: s1 = "abc", s2 = "acb"
 * Output: 1
 * Explanation: The longest common substrings are "a", "b", "c" all having length 1.
 * Input: s1 = "YZ", s2 = "yz"
 * Output: 0
 * Constraints:
 * 1 <= s1.size(), s2.size() <= 103
 * Both strings may contain upper and lower case alphabets.
 */
public class LongestCommonSubstring {

    // Dynamic Programming
    public int longestCommonSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a 1D array to store the previous row's results
        int[] prevRowData = new int[n + 1];

        int res = 0;
        for (int i = 1; i <= m; i++) {
            // Create a temporary array to store the current row
            int[] currentRowData = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    currentRowData[j] = prevRowData[j - 1] + 1;
                    res = Math.max(res, currentRowData[j]);
                } else {
                    currentRowData[j] = 0;
                }
            }
            // Move the current row's data to the previous row
            prevRowData = currentRowData;
        }
        return res;
    }
}
