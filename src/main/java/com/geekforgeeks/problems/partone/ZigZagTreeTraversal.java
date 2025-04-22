package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree with n nodes. Find the zig-zag level order traversal of the binary tree.
 * In zig zag traversal starting from the first level go from left to right for odd-numbered levels and
 * right to left for even-numbered levels.
 *
 * Examples:
 *
 * Input:
 *         1
 *       /   \
 *      2    3
 *     / \    /   \
 *    4   5 6   7
 * Output:
 * 1 3 2 4 5 6 7
 * Explanation:
 * For level 1 going left to right, we get traversal as {1}.
 * For level 2 going right to left, we get traversal as {3,2}.
 * For level 3 going left to right, we get traversal as {4,5,6,7}.
 * Merging all this traversals in single array we get {1,3,2,4,5,6,7}.
 * Input:
 *            7
 *         /     \
 *        9      7
 *      /  \      /
 *     8   8   6
 *    /  \
 *   10  9
 * Output:
 * 7 7 9 8 8 6 9 10
 * Explanation:
 * For level 1 going left to right, we get traversal as {7}.
 * For level 2 going right to left, we get traversal as {7,9}.
 * For level 3 going left to right, we get traversal as {8,8,6}.
 * For level 4 going right to left, we get traversal as {9,10}.
 * Merging all this traversals in single array we get {7,7,9,8,8,6,9,10}.
 */
public class ZigZagTreeTraversal {
    public ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                Node temp = queue.poll();
                if (level % 2 == 0) {
                    stack.add(temp.data);
                } else {
                    list.add(temp.data);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            level++;
        }
        return list;
    }

    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
}
