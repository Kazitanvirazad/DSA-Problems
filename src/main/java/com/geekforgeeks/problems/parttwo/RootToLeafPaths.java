package com.geekforgeeks.problems.parttwo;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a Binary Tree, you need to find all the possible paths from the root node to all the leaf nodes
 * of the binary tree.
 *
 * Note: The paths should be returned such that paths from the left subtree of any node are listed first,
 * followed by paths from the right subtree.
 *
 * Examples:
 *
 * Input: root[] = [1, 2, 3, 4, 5, N, N]
 * ex-3
 * Output: [[1, 2, 4], [1, 2, 5], [1, 3]]
 * Explanation: All the possible paths from root node to leaf nodes are: 1 -> 2 -> 4, 1 -> 2 -> 5 and 1 -> 3
 * Input: root[] = [1, 2, 3]
 *
 * Output: [[1, 2], [1, 3]]
 * Explanation: All the possible paths from root node to leaf nodes are: 1 -> 2 and 1 -> 3
 * Input: root[] = [10, 20, 30, 40, 60, N, N]
 *
 * Output: [[10, 20, 40], [10, 20, 60], [10, 30]]
 * Explanation: All the possible paths from root node to leaf nodes are: 10 -> 20 -> 40, 10 -> 20 -> 60 and 10 -> 30
 * Constraints:
 * 1 <= number of nodes <= 104
 * 1 <= node->data <= 104
 */
public class RootToLeafPaths {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        if (root.left == null && root.right == null) {
            new ArrayList<>();
        }
        Node current = root;
        Stack<Integer> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        preOrderTraverse(current, stack, paths);
        return paths;
    }

    private static void preOrderTraverse(Node subTree, Stack<Integer> stack, ArrayList<ArrayList<Integer>> paths) {
        stack.add(subTree.data);
        if (subTree.left == null && subTree.right == null) {
            paths.add(new ArrayList<>(stack));
            stack.pop();
            return;
        }
        if (subTree.left != null) {
            preOrderTraverse(subTree.left, stack, paths);
        }
        if (subTree.right != null) {
            preOrderTraverse(subTree.right, stack, paths);
        }
        stack.pop();
    }
}
