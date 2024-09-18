package com.geekforgeeks.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given below is a binary tree. The task is to print the top view of binary tree. Top view
 * of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree
 *
 *        1
 *     /     \
 *    2       3
 *   /  \    /  \
 * 4    5  6     7
 *
 * Top view will be: 4 2 1 3 7
 * Note: Return nodes from leftmost node to rightmost node. Also, if 2 nodes are outside the shadow of the
 * tree and are at same position then consider the left ones only(i.e. leftmost).
 * For ex - 1 2 3 N 4 5 N 6 N 7 N 8 N 9 N N N N N will give 8 2 1 3 as answer. Here 8 and 9 are on the same
 * position but 9 will get shadowed.
 *
 * Example 1:
 *
 * Input:
 *       1
 *    /    \
 *   2      3
 * Output: 2 1 3
 * Example 2:
 *
 * Input:
 *        10
 *     /      \
 *   20        30
 *  /   \    /    \
 * 40   60  90    100
 * Output: 40 20 10 30 100
 * Your Task:
 * Since this is a function problem. You don't have to take input. Just complete the function topView() that takes root node as parameter and returns a list of nodes visible from the top view from left to right.
 *
 * Expected Time Complexity: O(NlogN)
 * Expected Auxiliary Space: O(N).
 */
public class TopViewOfBinaryTree {
    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();

        traverseLeft(root);

        if (root.right != null) {
            traverseRight(root.right);
        }

        while (true) {
            if (!stack.isEmpty()) {
                res.add(stack.pop());
            } else if (!queue.isEmpty()) {
                res.add(queue.poll());
            } else {
                break;
            }
        }

        //resetting
        leftShadowDepthCount = 0;
        rightShadowDepthCount = 0;
        stack = new Stack<>();
        queue = new LinkedList<>();
        return res;
    }

    static int leftShadowDepthCount = 0;
    static int rightShadowDepthCount = 0;
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void traverseLeft(Node subTree) {
        if (subTree == null) {
            return;
        }
        if (leftShadowDepthCount > 0) {
            leftShadowDepthCount--;
        } else {
            stack.add(subTree.data);
        }
        if (subTree.left != null) {
            traverseLeft(subTree.left);
        } else if (subTree.right != null) {
            if (leftShadowDepthCount == 0) {
                leftShadowDepthCount += 2;
            } else {
                leftShadowDepthCount++;
            }
            traverseLeft(subTree.right);
        }
    }

    public static void traverseRight(Node subTree) {
        if (subTree == null) {
            return;
        }
        if (rightShadowDepthCount > 0) {
            rightShadowDepthCount--;
        } else {
            queue.add(subTree.data);
        }
        if (subTree.right != null) {
            traverseRight(subTree.right);
        } else if (subTree.left != null) {
            if (rightShadowDepthCount == 0) {
                rightShadowDepthCount += 2;
            } else {
                rightShadowDepthCount++;
            }
            traverseRight(subTree.left);
        }
        if (subTree.left != null) {
            rightShadowDepthCount += 3;
            traverseRight(subTree.left);
        }
    }

    class Node {
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
