package com.geekforgeeks.problems.parttwo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a binary tree, and the task is to determine whether it satisfies the properties of a max-heap.
 *
 * A binary tree is considered a max-heap if it satisfies the following conditions:
 *
 * Completeness: Every level of the tree, except possibly the last, is completely filled, and all nodes are as
 * far left as possible.
 * Max-Heap Property: The value of each node is greater than or equal to the values of its children.
 * Examples:
 *
 * Input: root[] = [97, 46, 37, 12, 3, 7, 31, 6, 9]
 *
 * Output: true
 * Explanation: The tree is complete and satisfies the max-heap property.
 * Input: root[] = [97, 46, 37, 12, 3, 7, 31, N, 2, 4]
 *
 * Output: false
 * Explanation: The tree is not complete and does not follow the Max-Heap Property, hence it is not a max-heap.
 * Constraints:
 * 1 ≤ number of nodes ≤ 103
 * 1 ≤ node->data ≤ 103
 */
public class IsBinaryTreeHeap {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public boolean isHeap(Node tree) {
        Queue<Node> queue = new LinkedList<>();
        Node head = tree;
        queue.add(head);
        boolean flag = false;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                if (flag || current.left.data > current.data) {
                    return false;
                }
                queue.add(current.left);
            } else {
                flag = true;
            }
            if (current.right != null) {
                if (flag || current.right.data > current.data) {
                    return false;
                }
                queue.add(current.right);
            } else {
                flag = true;
            }
        }
        return true;
    }
}
