package com.geekforgeeks.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its height.
 *
 * Example 1:
 *
 * Input:
 *      1
 *     /  \
 *    2    3
 * Output: 2
 * Example 2:
 *
 * Input:
 *   2
 *    \
 *     1
 *    /
 *  3
 * Output: 3
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function height() which takes root
 * node of the tree as input parameter and returns an integer denoting the height of the tree.
 * If the tree is empty, return 0.
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(N)
 */
public class HeightOfBinaryTree {
    public int height(Node node) {
        if (node.left == null && node.right == null) {
            return 1;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int height = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node temp = queue.poll();
                if (i == 0) {
                    height++;
                }

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return height;
    }

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
