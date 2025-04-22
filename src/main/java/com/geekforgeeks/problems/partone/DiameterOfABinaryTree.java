package com.geekforgeeks.problems.partone;

/**
 * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between
 * two end nodes. The diagram below shows two trees each with diameter nine, the leaves that form the ends
 * of the longest path are shaded (note that there is more than one path in each tree of length nine,
 * but no path longer than nine nodes).
 *
 *
 * Example 1:
 *
 * Input:
 *        1
 *      /  \
 *     2    3
 * Output: 3
 * Example 2:
 *
 * Input:
 *          10
 *         /   \
 *       20    30
 *     /   \
 *    40   60
 * Output: 4
 * Your Task:
 * You need to complete the function diameter() that takes root as parameter and returns the diameter.
 *
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(Height of the Tree).
 */
public class DiameterOfABinaryTree {
    public int diameter(Node root) {
        Height height = new Height();
        return diameterOpt(root, height);
    }

    public int diameterOpt(Node subTree, Height height) {
        if (subTree == null) {
            height.height = 0;
            return 0;
        }
        Height leftHeight = new Height();
        Height rightHeight = new Height();
        int leftDiameter = diameterOpt(subTree.left, leftHeight);
        int rightDiameter = diameterOpt(subTree.right, rightHeight);

        height.height = Math.max(leftHeight.height, rightHeight.height) + 1;

        return Math.max(leftHeight.height + rightHeight.height + 1, Math.max(leftDiameter, rightDiameter));
    }

    class Height {
        int height;
    }

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
}
