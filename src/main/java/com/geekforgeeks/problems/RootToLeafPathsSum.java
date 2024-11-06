package com.geekforgeeks.problems;

/**
 * Given a binary tree, where every node value is a number. Find the sum of all the numbers that are formed
 * from root to leaf paths. The formation of the numbers would be like 10*parent + current (see the examples
 * for more clarification).
 *
 * Examples:
 *
 * Input :
 *                  6
 *                 /  \
 *                3    5
 *               /  \    \
 *              2    5    4
 *                  / \
 *                 7   4
 *
 * Output: 13997
 * Explanation : There are 4 leaves, resulting in leaf path of 632, 6357, 6354, 654 sums to 13997.
 * Input :
 *                   10
 *                  /  \
 *                 20   30
 *                /  \
 *               40   60
 *
 * Output : 2630
 * Explanation: There are 3 leaves, resulting in leaf path of 1240, 1260, 130 sums to 2630.
 * Input :
 *            1
 *           /
 *          2
 * Output : 12
 * Explanation: There is 1 leaf, resulting in leaf path of 12.
 */
public class RootToLeafPathsSum {

    public static int treePathsSum(Node root) {
        Sum sum = new Sum();
        sum.data = 0;
        Total total = new Total();
        total.data = 0;
        traverse(root, sum, total);
        return total.data;
    }

    private static void traverse(Node subTree, Sum sum, Total total) {
        if (subTree != null) {
            sum.data = (sum.data * 10) + subTree.data;

            if (subTree.left == null && subTree.right == null) {
                total.data += sum.data;
            }

            if (subTree.left != null) {
                traverse(subTree.left, sum, total);
                sum.data -= subTree.left.data;
                sum.data /= 10;
            }
            if (subTree.right != null) {
                traverse(subTree.right, sum, total);
                sum.data -= subTree.right.data;
                sum.data /= 10;
            }
        }
    }

    static class Total {
        int data;
    }

    static class Sum {
        int data;
    }

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }
}
