package com.geekforgeeks.problems.partone;

import java.util.PriorityQueue;

/**
 * Given two strings a and b consisting of lowercase characters. The task is to check whether two given
 * strings are an anagram of each other or not. An anagram of a string is another string that contains the
 * same characters, only the order of characters can be different. For example, act and tac are an anagram
 * of each other. Strings a and b can only contain lowercase alphabets.
 *
 * Note:-
 *
 * If the strings are anagrams you have to return True or else return False
 *
 * |s| represents the length of string s.
 *
 *
 * Example 1:
 *
 * Input:a = geeksforgeeks, b = forgeeksgeeks
 * Output: YES
 * Explanation: Both the string have same characters with same frequency. So, they are anagrams.
 * Example 2:
 *
 * Input:a = allergy, b = allergic
 * Output: NO
 * Explanation: Characters in both the strings are not same, so they are not anagrams.
 * Expected Time Complexity:O(|a|+|b|).
 * Expected Auxiliary Space: O(Number of distinct characters).
 */
public class Anagram {
    public static void main(String[] args) {
        String str1 = "allergy";
        String str2 = "allergi";
        System.out.println(isAnagram(str1, str2));
    }

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        if (a.length() == 1) {
            return a.charAt(0) == b.charAt(0);
        }

        PriorityQueue<Integer> minHeapA = new PriorityQueue<>();
        PriorityQueue<Integer> minHeapB = new PriorityQueue<>();

        for (int i = 0; i < a.length(); i++) {
            minHeapA.add((int) a.charAt(i));
            minHeapB.add((int) b.charAt(i));
        }

        while (!minHeapA.isEmpty()) {
            if (minHeapA.poll() != minHeapB.poll()) {
                return false;
            }
        }
        return true;
    }
}
