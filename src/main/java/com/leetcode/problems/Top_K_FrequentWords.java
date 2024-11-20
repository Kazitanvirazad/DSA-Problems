package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same
 * frequency by their lexicographical order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 *
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of
 * occurrence being 4, 3, 2 and 1 respectively.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 500
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * k is in the range [1, The number of unique words[i]]
 *
 *
 * Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
 */
public class Top_K_FrequentWords {
    public static void main(String[] args) {
        Top_K_FrequentWords frequentWords = new Top_K_FrequentWords();
        String[] arr1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        frequentWords.topKFrequent(arr1, k1).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        String[] arr2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;
        frequentWords.topKFrequent(arr2, k2).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        String[] arr3 = {"the", "day", "is", "sunny", "the", "the", "the", "che", "the", "sunny", "is", "is"};
        int k3 = 4;
        frequentWords.topKFrequent(arr3, k3).forEach(ele -> System.out.print(ele + " "));
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        PriorityQueue<Frequency> maxHeap = new PriorityQueue<>(words.length, new FrequencyComparator());
        map.keySet().forEach(key -> {
            maxHeap.add(new Frequency(key, map.get(key)));
        });
        for (int i = 0; i < k; i++) {
            if (!maxHeap.isEmpty()) {
                res.add(maxHeap.poll().word);
            }
        }
        return res;
    }

    class FrequencyComparator implements Comparator<Frequency> {
        @Override
        public int compare(Frequency a, Frequency b) {
            if (a.frequency < b.frequency) {
                return 1;
            } else if (a.frequency > b.frequency) {
                return -1;
            } else {
                return a.word.compareTo(b.word);
            }
        }
    }

    class Frequency {
        String word;
        int frequency;

        public Frequency(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }
}
