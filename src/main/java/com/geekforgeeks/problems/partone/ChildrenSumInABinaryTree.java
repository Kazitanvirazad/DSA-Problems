package com.geekforgeeks.problems.partone;

/**
 * Given a binary tree having n nodes. Check whether all of its nodes have the value equal to the sum of
 * their child nodes. Return 1 if all the nodes in the tree satisfy the given properties, else it return 0.
 *
 * For every node, data value must be equal to the sum of data values in left and right children.
 * Consider data value as 0 for NULL child.  Also, leaves are considered to follow the property.
 *
 * Example 1:
 *
 * Input:
 * Binary tree
 *        35
 *       /   \
 *      20    15
 *     /  \  /  \
 *    15  5 10   5
 * Output:
 * 1
 * Explanation:
 * Here, every node is sum of its left and right child.
 * Example 2:
 *
 * Input:
 * Binary tree
 *        1
 *      /   \
 *     4     3
 *    /
 *   5
 * Output:
 * 0
 * Explanation:
 * Here, 1 is the root node and 4, 3 are its child nodes. 4 + 3 = 7 which is not equal to the value of root node.
 * Hence, this tree does not satisfy the given condition.
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function isSumProperty() that
 * takes the root Node of the binary tree as input and returns 1 if all the nodes in the tree satisfy the
 * following properties, else it returns 0.
 *
 * Expected Time Complexiy: O(n).
 * Expected Auxiliary Space: O(Height of the Tree).
 */
public class ChildrenSumInABinaryTree {
    public static int isSumProperty(Node root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        traversePostOrder(root);
        int res = isSum ? 1 : 0;
        isSum = true;
        return res;
    }

    private static boolean isSum = true;

    private static void traversePostOrder(Node subRoot) {
        if (subRoot.left != null) traversePostOrder(subRoot.left);
        if (subRoot.right != null) traversePostOrder(subRoot.right);
        if (subRoot.left != null || subRoot.right != null) {
            int left = subRoot.left != null ? subRoot.left.data : 0;
            int right = subRoot.right != null ? subRoot.right.data : 0;
            if (subRoot.data != (left + right)) {
                isSum = false;
            }
        }
    }

    class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }
}
