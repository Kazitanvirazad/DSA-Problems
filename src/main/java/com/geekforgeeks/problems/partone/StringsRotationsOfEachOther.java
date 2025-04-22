package com.geekforgeeks.problems.partone;

/**
 * You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of
 * the string s1.
 *
 * Note: The characters in the strings are in lowercase.
 *
 * Examples :
 *
 * Input: s1 = "abcd", s2 = "cdab"
 * Output: true
 * Explanation: After 2 right rotations, s1 will become equal to s2.
 * Input: s1 = "aab", s2 = "aba"
 * Output: true
 * Explanation: After 1 left rotation, s1 will become equal to s2.
 * Input: s1 = "abcd", s2 = "acbd"
 * Output: false
 * Explanation: Strings are not rotations of each other.
 * Constraints:
 * 1 <= s1.size(), s2.size() <= 105
 *
 * Company Tags
 */
public class StringsRotationsOfEachOther {
    public static void main(String[] args) {
        String
//                s1 = "abcd", s2 = "cdab";
//                s1 = "aab", s2 = "aba";
                s1 = "abcd", s2 = "acbd";
//                s1 = "ncwuvtaxcygwghcvrfpwfdlhyrszzcqxkdfmcvwscytvdnmmmdnkranafryefhhuoccpcukyfesucuanxjtupwsluadxrmujbgdmkyvmjcbpcgfhpcrwrqkeoryrdivyxvjzhxwjvrbrlgipoyxhgzjamrvhqzhguuwuapqi", s2 = "mmdnkranafryefhhuoccpcukyfesucuanxjtupwsluadxrmujbgdmkyvmjcbpcgfhpcrwrqkeoryrdivyxvjzhxwjvrbrlgipoyxhgzjamrvhqzhguuwuapqincwuvtaxcygwghcvrfpwfdlhyrszzcqxkdfmcvwscytvdnm";
        System.out.println(areRotations(s1, s2));
    }

    public static boolean areRotations(String s1, String s2) {
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        s1 = s1 + s1;
        int startIndexS1 = 0;
        int startIndexS2 = 0;
        int[] lps = getLpsArray(s2);
        while (startIndexS1 < s1.length()) {
            if (s1.charAt(startIndexS1) == s2.charAt(startIndexS2)) {
                startIndexS2++;
                startIndexS1++;
                if (startIndexS2 == s2.length()) {
                    return true;
                }
            } else {
                if (startIndexS2 == 0) {
                    startIndexS1++;
                } else {
                    startIndexS2 = lps[startIndexS2 - 1];
                }
            }
        }
        return false;
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
