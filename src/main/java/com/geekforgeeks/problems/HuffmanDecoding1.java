package com.geekforgeeks.problems;

/**
 * Given a string S, implement Huffman Encoding and Decoding.
 * <p>
 * Example 1:
 * <p>
 * Input : abc
 * Output : abc
 * Example 2:
 * <p>
 * Input : geeksforgeeks
 * Output : geeksforgeeks
 * <p>
 * <p>
 * Your task:
 * You don't need to read input or print anything. Your task is to complete the function decode_file(),
 * which takes root of the tree formed while encoding and the encoded string as the input parameters and
 * returns the decoded string.
 */
public class HuffmanDecoding1 {
    public String decode_file(MinHeapNode root, String encodedStr) {
        String ans = "";

        MinHeapNode current = root;
        for (int i = 0; i < encodedStr.length(); i++) {
            if (encodedStr.charAt(i) == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current.left == null && current.right == null) {
                ans += current.data;
                current = root;
            }
        }
        return ans;
    }

    class MinHeapNode {
        char data;
        int freq;
        MinHeapNode left, right;

        MinHeapNode(char data, int freq) {
            left = right = null;
            this.data = data;
            this.freq = freq;
        }
    }
}
