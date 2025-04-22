package com.geekforgeeks.problems.partone;

/**
 * Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.
 *
 * NOTE: Prefix and suffix can be overlapping but they should not be equal to the entire string.
 *
 * Examples :
 *
 * Input: str = "abab"
 * Output: 2
 * Explanation: "ab" is the longest proper prefix and suffix.
 * Input: str = "aaaa"
 * Output: 3
 * Explanation: "aaa" is the longest proper prefix and suffix.
 * Expected Time Complexity: O(|str|)
 * Expected Auxiliary Space: O(|str|)
 */
public class LongestPrefixSuffix {
    public static void main(String[] args) {
        String str1 = "abab";
        String str2 = "aaaa";
        String str3 = "blablabla";
        System.out.println(lps(str1));
    }

    public static int lps(String str) {
        if (str.length() <= 1) {
            return 0;
        } else if (str.length() == 2) {
            return str.charAt(0) != str.charAt(1) ? 0 : 1;
        }

        char[] chars = str.toCharArray();

        int j = 0;
        int i = 1;
        int[] lps = new int[chars.length];
        while (i < chars.length) {
            if (chars[i] == chars[j]) {
                lps[i] = j + 1;
                j++;
                i++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        return lps[lps.length - 1];
    }
}