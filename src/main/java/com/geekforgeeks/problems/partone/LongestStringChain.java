package com.geekforgeeks.problems.partone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of words where each word consists of lowercase English letters.
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without
 * changing the order of the other characters to make it equal to wordB. For example, "abc" is a predecessor of "abac",
 * while "cba" is not a predecessor of "bcad".
 *
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2,
 * word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k = 1.
 *
 * Return the length of the longest possible word chain with words chosen from the given list of words in any order.
 *
 * Examples:
 *
 * Input: words[] = ["ba", "b", "a", "bca", "bda", "bdca"]
 * Output: 4
 * Explanation: One of the longest word chains is ["a", "ba", "bda", "bdca"].
 * Input: words[] = ["abc", "a", "ab"]
 * Output: 3
 * Explanation: The longest chain is {"a", "ab" "abc"}
 * Input: words[] = ["abcd", "dbqca"]
 * Output: 1
 * Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
 * Constraint:
 * 1 <= words.length <= 104
 * 1 <= words[i].length <= 10
 *  words[i] only consists of lowercase English letters.
 */
public class LongestStringChain {
    public static void main(String[] args) {
        LongestStringChain lcs = new LongestStringChain();
        String[] sample1 = {"ba", "b", "a", "bca", "bda", "bdca"};
        String[] sample2 = {"abc", "a", "ab"};
        String[] sample3 = {"abcd", "dbqca"};
        String[] sample4 = {"d", "aw", "vzwoqyk", "rcivl", "aod", "hvftcyowaa", "ioyffk", "bndardbw", "cbsqxxxe", "hvtcyowaa", "ijgij", "hvtowa", "hjtwmx", "qqeam", "hvtcyowa", "weyrv", "idyiav", "uxoyu", "dcikf", "vauwb", "hvtyowa", "qlhvebncie", "yqkjc", "rp", "zchqgl", "pr", "vfwnqv", "bmqpvf", "y", "twwp", "zks", "urzczwv", "nm", "tlx", "cg", "cqc", "nm", "syetxuqsl", "kyept", "j", "nwuwwlro", "gx", "qkmqxun", "irb", "aqs", "gxdzy", "mpatnl", "ion", "ntcxbewk", "aosznshlrh", "eodlsev", "pqqscb", "p"};

        System.out.println(lcs.longestStringChain(sample4));
    }

    public int longestStringChain(String[] words) {
        if (words.length == 1) {
            return 1;
        }
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        // Map to store the maximum chain length for each word
        Map<String, Integer> dp = new HashMap<>();
        int highestLength = 1;
        for (String word : words) {
            dp.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(predecessor)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(predecessor) + 1));
                }
            }
            highestLength = Math.max(highestLength, dp.get(word));
        }
        return highestLength;
    }
}
