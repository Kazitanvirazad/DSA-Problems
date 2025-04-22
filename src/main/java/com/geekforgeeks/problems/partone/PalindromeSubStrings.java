package com.geekforgeeks.problems.partone;

/**
 * Given a string s, count all palindromic sub-strings present in the string. The length of the palindromic
 * sub-string must be greater than or equal to 2.
 *
 * Examples
 *
 * Input: s = "abaab"
 * Output: 3
 * Explanation: All palindromic substrings are : "aba" , "aa" , "baab".
 * Input: s = "aaa"
 * Output: 3
 * Explanation: All palindromic substrings are : "aa", "aa", "aaa".
 * Input: s = "abbaeae"
 * Output: 4
 * Explanation: All palindromic substrings are : "bb" , "abba" , "aea", "eae".
 * Constraints:
 * 2 ≤ s.size() ≤ 103
 * string contains only lowercase english characters
 */
public class PalindromeSubStrings {
    public static void main(String[] args) {
        PalindromeSubStrings ps = new PalindromeSubStrings();
        String sample1 = "abaab"; //3
        String sample2 = "aaa"; //3
        String sample3 = "abbaeae"; //4
        System.out.println(ps.countPS(sample1));
    }

    public int countPS(String s) {
        int n = s.length();
        if (n == 2) {
            return n;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int low = i - 1;
            int high = i + 1;
            while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                count++;
                low--;
                high++;
            }
        }
        for (int i = 0; i < n; i++) {
            int low = i;
            int high = i + 1;
            while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                count++;
                low--;
                high++;
            }
        }
        return count;
    }
}
