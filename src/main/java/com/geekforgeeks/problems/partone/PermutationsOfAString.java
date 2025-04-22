package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, which may contain duplicate characters, your task is to generate and return an array of
 * all unique permutations of the string. You can return your answer in any order.
 *
 * Examples:
 *
 * Input: s = "ABC"
 * Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
 * Explanation: Given string ABC has 6 unique permutations.
 * Input: s = "ABSG"
 * Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG",
 *               "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
 * Explanation: Given string ABSG has 24 unique permutations.
 * Input: s = "AAA"
 * Output: ["AAA"]
 * Explanation: No other unique permutations can be formed as all the characters are same.
 * Constraints:
 * 1 <= s.size() <= 9
 * s contains only Uppercase english alphabets
 */
public class PermutationsOfAString {
    public static void main(String[] args) {
        PermutationsOfAString permutations = new PermutationsOfAString();
        String sample1 = "AAA";
        String sample2 = "ABC";
        String sample3 = "ABCA";
        permutations.findPermutation(sample3).forEach(System.out::println);
    }

    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder current = new StringBuilder();
        permute(s, result, map, current);
        if (result.isEmpty()) {
            result.add(s);
        }
        return result;
    }

    private void permute(String s, ArrayList<String> result, Map<Character, Integer> map, StringBuilder current) {
        if (current.length() == s.length()) {
            result.add(current.toString());
            return;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            if (count == 0) {
                continue;
            }
            current.append(ch);
            map.put(ch, count - 1);
            permute(s, result, map, current);
            current.deleteCharAt(current.length() - 1);
            map.put(ch, count);
        }
    }
}
