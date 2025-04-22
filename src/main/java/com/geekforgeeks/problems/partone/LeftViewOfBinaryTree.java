package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a Binary Tree, return its Left view. The left view of a Binary Tree is a set of nodes visible
 * when the tree is visited from the Left side. If no left view is possible, return an empty array.
 *
 * Examples :
 *
 * Input: root[] = [1, 2, 3, 4, 5, 6, 7, N, 8]
 *           1
 *        /     \
 *      2        3
 *    /     \    /    \
 *   4     5   6    7
 *    \
 *      8
 * Output: [1, 2, 4, 8]
 * Explanation: When we view the tree from the left side, we can only see the nodes 1, 2, 4, and 8.
 * Input: root[] = [1, 3, N, N, 4]
 * Output: [1, 3, 4]
 * Input: root[] = [N]
 * Output: []
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(n)
 */
public class LeftViewOfBinaryTree {
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> elements = new ArrayList<>();
        if (root == null) {
            return elements;
        }
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node current = queue.poll();

                if (i == 0) {
                    elements.add(current.data);
                }


                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return elements;
    }

    class Node {
        Node left, right;
        int data;

        public Node(int data) {
            left = right = null;
        }
    }
}
