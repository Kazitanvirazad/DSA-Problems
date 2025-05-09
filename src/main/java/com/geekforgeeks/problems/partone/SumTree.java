package com.geekforgeeks.problems.partone;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a Binary Tree. Check for the Sum Tree for every node except the leaf node. Return true if it is a Sum Tree
 * otherwise, return false.
 *
 * A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree
 * and right subtree. An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf
 * node is also considered a Sum Tree.
 *
 * Examples :
 *
 * Input:
 *     3
 *   /   \
 *  1     2
 * Output: true
 * Explanation: The sum of left subtree and right subtree is 1 + 2 = 3, which is the value of the root node.
 * Therefore,the given binary tree is a sum tree.
 * Input:
 *           10
 *         /    \
 *       20      30
 *     /   \
 *    10    10
 * Output: false
 * Explanation: The given tree is not a sum tree. For the root node, sum of elements in left subtree is 40 and sum of
 * elements in right subtree is 30. Root element = 10 which is not equal to 30+40.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(Height of the Tree)
 */
public class SumTree {
    public boolean isSumTree(Node root) {
        int sum = 0;
        if (root.left != null) {
            sum += levelOrderTraverse(root.left);
        }
        if (root.right != null) {
            sum += levelOrderTraverse(root.right);
        }

        return root.data == sum;
    }

    public int levelOrderTraverse(Node subTree) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(subTree);
        int sum = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            sum += current.data;
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return sum;
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
