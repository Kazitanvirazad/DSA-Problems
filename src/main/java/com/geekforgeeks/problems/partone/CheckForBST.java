package com.geekforgeeks.problems.partone;

/**
 * Given the root of a binary tree. Check whether it is a BST or not.
 * Note: We are considering that BSTs can not contain duplicate Nodes.
 * A BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Examples:
 *
 * Input:
 *    2
 *  /    \
 * 1      3
 *         \
 *          5
 * Output: true
 * Explanation:
 * The left subtree of every node contains smaller keys and right subtree of every node contains greater. Hence, the tree is a BST.
 * Input:
 *   2
 *    \
 *     7
 *      \
 *       6
 *        \
 *         9
 * Output: false
 * Explanation:
 * Since the node with value 7 has right subtree nodes with keys less than 7, this is not a BST.
 * Input:
 *    10
 *  /    \
 * 5      20
 *       /   \
 *      9     25
 * Output: false
 * Explanation: The node is present in the right subtree of 10, but it is smaller than 10.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(Height of the tree)
 * where n is the number of nodes in the given tree
 */
public class CheckForBST {
    public static void main(String[] args) {
        Node root = new Node(2);

        Node one = new Node(1);
        Node two = new Node(3);

        Node three = new Node(5);

        one.left = null;
        one.right = null;
        two.left = null;
        two.right = three;
        root.left = one;
        root.right = two;
        System.out.println(isBST(root));
    }

    static Node prev;

    public static boolean isBST(Node root) {
        if (root.left == null && root.right == null) {
            return true;
        }

        return inOrderlyTraverseToCheckBST(root);
    }

    static boolean inOrderlyTraverseToCheckBST(Node subTree) {
        if (subTree != null) {
            if (!inOrderlyTraverseToCheckBST(subTree.left)) {
                return false;
            }

            if (prev != null && subTree.data < prev.data) {
                return false;
            }
            prev = subTree;

            if (!inOrderlyTraverseToCheckBST(subTree.right)) {
                return false;
            }
        }
        return true;
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
