package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 */
public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram anagram = new ValidAnagram();
        String[] sampleA = {"anagram", "nagaram"};
        String[] sampleB = {"rat", "car"};
        System.out.println(anagram.isAnagram(sampleA[0], sampleA[1]));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (map.containsKey(character)) {
                int count = map.get(character);
                count++;
                map.put(character, count);
            } else {
                map.put(character, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            if (map.containsKey(character)) {
                int count = map.get(character);
                count--;
                map.put(character, count);
            } else {
                return false;
            }
        }
        for (var entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
