package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a string s and a dictionary of n words dictionary, find out if "s" can be segmented into a
 * space-separated sequence of dictionary words.
 * Return 1 if it is possible to break the s into a sequence of dictionary words, else return 0.
 *
 * Note: From the dictionary each word can be taken any number of times and in any order.
 *
 * Examples :
 *
 * Input: n = 6, s = "ilike", dictionary = { "i", "like", "sam", "sung", "samsung", "mobile"}
 * Output: 1
 * Explanation: The string can be segmented as "i like".
 * Input: n = 6, s = "ilikesamsung", dictionary = { "i", "like", "sam", "sung", "samsung", "mobile"}
 * Output: 1
 * Explanation: The string can be segmented as "i like samsung" or "i like sam sung".
 * Expected Time Complexity: O(len(s)2)
 * Expected Space Complexity: O(len(s))
 */
public class WordBreak {
    public static void main(String[] args) {
        String str1 = "catsandog";
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("cats", "cat", "and", "sand", "dog"));
        System.out.println(wordBreak(list1.size(), str1, list1));
        String str2 = "catsanddog";
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("cats", "cat", "and", "sand", "dog"));
        System.out.println(wordBreak(list2.size(), str2, list2));
    }

    public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        int length = s.length();
        boolean[] wordsFoundFlags = new boolean[length + 1];
        wordsFoundFlags[0] = true;

        for (int i = 0; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (wordsFoundFlags[j] && dictionary.contains(s.substring(j, i))) {
                    wordsFoundFlags[i] = true;
                    break;
                }
            }
        }
        return wordsFoundFlags[length] ? 1 : 0;
    }
}
