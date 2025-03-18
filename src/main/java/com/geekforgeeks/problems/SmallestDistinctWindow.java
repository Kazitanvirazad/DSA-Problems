package com.geekforgeeks.problems;

/**
 * Given a string s, your task is to find the smallest window length that contains all the characters of
 * the given string at least one time.
 *
 * Example:
 *
 * Input: s = "AABBBCBBAC"
 * Output: 3
 * Explanation: Sub-string -> "BAC"
 * Input: s = "aaab"
 * Output: 2
 * Explanation: Sub-string -> "ab"
 * Input: s = "GEEKSGEEKSFOR"
 * Output: 8
 * Explanation: Sub-string -> "GEEKSFOR"
 * Constraints:
 * 1 ≤ s.size() ≤ 105
 * String may contain both types of English Alphabet.
 */
public class SmallestDistinctWindow {
    public static void main(String[] args) {
        SmallestDistinctWindow distinctWindow = new SmallestDistinctWindow();
        String sample1 = "AABBBCBBAC";      //3
        String sample2 = "aaab";            //2
        String sample3 = "GEEKSGEEKSFOR";   //8
        System.out.println(distinctWindow.findSubString(sample1));
    }

    public int findSubString(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }

        boolean[] visited = new boolean[256];
        int distinctCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[s.charAt(i)]) {
                visited[s.charAt(i)] = true;
                distinctCount++;
            }
        }

        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int count = 0;
        int[] currentCount = new int[256];

        for (int i = 0; i < n; i++) {
            currentCount[s.charAt(i)]++;

            if (currentCount[s.charAt(i)] == 1) {
                count++;
            }
            if (count == distinctCount) {
                while (currentCount[s.charAt(start)] > 1) {
                    if (currentCount[s.charAt(start)] > 1) {
                        currentCount[s.charAt(start)]--;
                    }
                    start++;
                }
                int windowLength = i - start + 1;
                if (minLength > windowLength) {
                    minLength = windowLength;
                }
            }
        }
        return minLength;
    }
}
