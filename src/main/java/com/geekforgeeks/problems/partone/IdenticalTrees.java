package com.geekforgeeks.problems.partone;

import com.dsa.practice.util.TreeBuilder;
import com.dsa.practice.util.TreeNode;

/**
 * Given two binary trees, the task is to find if both of them are identical or not.
 * Note: You need to return true or false, the printing is done by the driver code.
 *
 * Example 1:
 *
 * Input:
 *      1          1
 *    /   \      /   \
 *   2     3    2     3
 * Output:
 * Yes
 * Explanation:
 * There are two trees both having 3 nodes and 2 edges, both trees are identical having the root as 1, left child of 1 is 2 and right child of 1 is 3.
 * Example 2:
 *
 * Input:
 *     1       1
 *   /  \     /  \
 *  2    3   3    2
 * Output:
 * No
 * Explanation: There are two trees both having 3 nodes and 2 edges, but both trees are not identical.
 * Your task:
 * Since this is a functional problem you don't have to worry about input, you just have to complete the function isIdentical() that takes two roots as parameters and returns true or false. The printing is done by the driver code.
 *
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(Height of the Tree).
 */
public class IdenticalTrees {
    public static void main(String[] args) {
        String tree1 = "1 2 3 4 6 7";
        String tree2 = "1 2 3 4 6 8";
        TreeNode root1 = TreeBuilder.buildTree(tree1);
        TreeNode root2 = TreeBuilder.buildTree(tree2);

        IdenticalTrees identicalTrees = new IdenticalTrees();
        System.out.println(identicalTrees.isIdentical(root1, root2));
    }

    public boolean isIdentical(TreeNode root1, TreeNode root2) {
        if (root1.data != root2.data) {
            return false;
        }
        Identical identical = new Identical();
        identical.isIdenticalTree = true;
        inOrderlyTraverse(root1, root2, identical);
        return identical.isIdenticalTree;
    }

    public void inOrderlyTraverse(TreeNode subTree1, TreeNode subTree2, Identical identical) {
        if (!identical.isIdenticalTree) {
            identical.isIdenticalTree = false;
            return;
        }
        System.out.println(subTree1.data + " " + subTree2.data);
        if (subTree1.data != subTree2.data) {
            identical.isIdenticalTree = false;
            return;
        }
        if (subTree1.left != null || subTree2.left != null) {
            if (subTree1.left == null || subTree2.left == null) {
                identical.isIdenticalTree = false;
                return;
            }
            inOrderlyTraverse(subTree1.left, subTree2.left, identical);
        }
        if (subTree1.right != null || subTree2.right != null) {
            if (subTree1.right == null || subTree2.right == null) {
                identical.isIdenticalTree = false;
                return;
            }
            inOrderlyTraverse(subTree1.right, subTree2.right, identical);
        }
    }

    class Identical {
        boolean isIdenticalTree;
    }

   /* class TreeNode {
        public int data;
        public com.dsa.practice.util.TreeNode left, right;

        public TreeNode(int d) {
            data = d;
            left = right = null;
        }
    }*/
}
