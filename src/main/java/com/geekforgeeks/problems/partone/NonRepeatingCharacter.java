package com.geekforgeeks.problems.partone;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string s consisting of lowercase Latin Letters. Return the first non-repeating character in s.
 * If there is no non-repeating character, return '$'.
 *
 * Note: When you return '$' driver code will output -1.
 *
 * Examples:
 *
 * Input: s = "hello"
 * Output: h
 * Explanation: In the given string, the first character which is non-repeating is h, as it appears first and
 * there is no other 'h' in the string.
 * Input: s = "zxvczbtxyzvy"
 * Output: c
 * Explanation: In the given string, 'c' is the character which is non-repeating.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(no. of distinct characters)
 */
public class NonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "zxvczbtxyzvy";
        String str1 = "hello";
        System.out.println(nonrepeatingCharacter(str1));
    }

    public static char nonrepeatingCharacter(String s) {
        if (s.length() == 1) {
            return s.charAt(0);
        }

        Map<Character, Integer> map = new LinkedHashMap<>();

        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                continue;
            }
            map.put(c, 1);
        }

        Iterator<Character> iterator = map.keySet().iterator();
        char res = '$';
        while (iterator.hasNext()) {
            char c = iterator.next();
            if (map.get(c) == 1) {
                res = c;
                break;
            }
        }
        return res;
    }
}
