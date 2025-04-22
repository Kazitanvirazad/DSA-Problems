package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order:
 *
 * Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node
 * you could reach when you always travel preferring the left subtree over the right subtree.
 * Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
 * Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most
 * node is the leaf node you could reach when you always travel preferring the right subtree over the left
 * subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
 * Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right
 * boundary.
 *
 * Example 1:
 *
 * Input:
 *         1
 *       /   \
 *      2     3
 *     / \   / \
 *    4   5 6   7
 *       / \
 *      8   9
 *
 * Output: 1 2 4 8 9 6 7 3
 * Explanation:
 *
 * Example 2:
 *
 * Input:
 *             1
 *            /
 *           2
 *         /  \
 *        4    9
 *      /  \    \
 *     6    5    3
 *              /  \
 *             7     8
 *
 * Output: 1 2 4 6 5 7 8
 * Explanation:
 *
 *
 * As you can see we have not taken the right subtree.
 * Your Task:
 * This is a function problem. You don't have to take input. Just complete the function boundary() that takes
 * the root node as input and returns an array containing the boundary values in anti-clockwise.
 *
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(Height of the Tree).
 */
public class TreeBoundaryTraversal {
    ArrayList<Integer> elements = new ArrayList<>();

    public ArrayList<Integer> boundary(Node node) {
        if (node != null) {
            elements.add(node.data);
            if (node.left != null) {
                traverseLeftBoundary(node.left);
                traverseLeaf(node.left);
            }
            if (node.right != null) {
                traverseLeaf(node.right);
                traverseRightBoundary(node.right);
            }
        }
        return elements;
    }

    public void traverseLeaf(Node subTree) {
        if (subTree == null) {
            return;
        }
        if (subTree.left == null && subTree.right == null) {
            elements.add(subTree.data);
        }
        if (subTree.left != null) {
            traverseLeaf(subTree.left);
        }
        if (subTree.right != null) {
            traverseLeaf(subTree.right);
        }
    }

    public void traverseLeftBoundary(Node subTree) {
        if (subTree == null) {
            return;
        }
        if (subTree.left == null && subTree.right == null) {
            return;
        }
        if (subTree.left != null) {
            elements.add(subTree.data);
            traverseLeftBoundary(subTree.left);
        } else {
            elements.add(subTree.data);
            traverseLeftBoundary(subTree.right);
        }
    }

    public void traverseRightBoundary(Node subTree) {
        if (subTree == null) {
            return;
        }
        if (subTree.left == null && subTree.right == null) {
            return;
        }
        if (subTree.right != null) {
            traverseRightBoundary(subTree.right);
            elements.add(subTree.data);
        } else {
            traverseRightBoundary(subTree.left);
            elements.add(subTree.data);
        }
    }

    class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
