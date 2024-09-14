package com.geekforgeeks.problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Given a string S of distinct character of size N and their corresponding frequency f[ ]
 * i.e. character S[i] has f[i] frequency. Your task is to build the Huffman tree print all
 * the huffman codes in preorder traversal of the tree.
 * Note: While merging if two nodes have the same value, then the node which occurs at first
 * will be taken on the left of Binary Tree and the other one to the right, otherwise Node with
 * less value will be taken on the left of the subtree and other one to the right.
 * <p>
 * Example 1:
 * <p>
 * S = "abcdef"
 * <p>
 * f[] = {5, 9, 12, 13, 16, 45}
 * <p>
 * Output:
 * <p>
 * 0 100 101 1100 1101 111
 * <p>
 * Explanation:
 * <p>
 * Steps to print codes from Huffman Tree
 * <p>
 * HuffmanCodes will be:
 * <p>
 * f : 0
 * <p>
 * c : 100
 * <p>
 * d : 101
 * <p>
 * a : 1100
 * <p>
 * b : 1101
 * <p>
 * e : 111
 * <p>
 * Hence printing them in the PreOrder of Binary Tree.
 * <p>
 * Your Task:
 * <p>
 * You don't need to read or print anything. Your task is to complete the function huffmanCodes()
 * which takes the given string S, frequency array f[ ] and number of characters N as input
 * parameters and returns a vector of strings containing all huffman codes in order of preorder
 * traversal of the tree.
 * <p>
 * Expected Time complexity: O(N * LogN)
 * <p>
 * Expected Space complexity: O(N)
 */
public class HuffmanEncoding {
    public static void main(String[] args) {
        HuffmanEncoding huffmanEncoding = new HuffmanEncoding();
//        int[] f = {5, 9, 12, 13, 16, 45};
        int[] f = {8, 9, 14, 19, 20, 21, 21, 25, 33, 45, 50, 50, 66, 68, 70, 73, 74, 75, 76, 82, 85, 90, 94, 97, 100};
        String str = "qwertyuiopasdfghjklzxcvbn";
//        String str = "abcdef";
        ArrayList<String> codes = huffmanEncoding.huffmanCodes(str, f, f.length);
        codes.forEach(code -> System.out.print(code + " "));
    }


    public ArrayList<String> huffmanCodes(String S, int f[], int N) {
        ArrayList<String> codes = new ArrayList<>();
        PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>();
        char[] charArr = S.toCharArray();
        for (int i = 0; i < N; i++) {
            char currentData = charArr[i];
            int currentFrequency = f[i];
            MinHeapNode node = new MinHeapNode(currentData, currentFrequency);
            minHeap.add(node);
        }

        MinHeapNode tree;
        while (minHeap.size() > 1) {
            MinHeapNode node1 = minHeap.poll();
            MinHeapNode node2 = minHeap.poll();
            MinHeapNode newNode = new MinHeapNode(node1.frequency + node2.frequency);
            newNode.left = node1;
            newNode.right = node2;
            minHeap.add(newNode);
        }

        tree = minHeap.poll();

        preOrderTraverse(tree, "", codes);
        return codes;
    }

    public void preOrderTraverse(MinHeapNode subTree, String s, ArrayList<String> codes) {
        if (subTree.left == null && subTree.right == null) {
            codes.add(s);
            return;
        }
        preOrderTraverse(subTree.left, s + "0", codes);
        preOrderTraverse(subTree.right, s + "1", codes);
    }

    class MinHeapNode implements Comparable<MinHeapNode> {
        char data;
        int frequency;
        MinHeapNode left, right;

        public MinHeapNode(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
            left = right = null;
        }

        public MinHeapNode(int frequency) {
            this.frequency = frequency;
            left = right = null;
        }

        @Override
        public int compareTo(MinHeapNode o) {
            if (o.frequency == this.frequency) {
                return 1;
            }
            return this.frequency - o.frequency;
        }
    }
}
