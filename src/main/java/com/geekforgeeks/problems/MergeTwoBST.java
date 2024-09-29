package com.geekforgeeks.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given two BSTs, return elements of merged BSTs in sorted form.
 *
 * Examples :
 *
 * Input:
 * BST1:
 *        5
 *      /   \
 *     3     6
 *    / \
 *   2   4
 * BST2:
 *         2
 *       /   \
 *      1     3
 *             \
 *              7
 *             /
 *            6
 * Output: 1 2 2 3 3 4 5 6 6 7
 * Explanation: After merging and sorting the two BST we get 1 2 2 3 3 4 5 6 6 7.
 * Input:
 * BST1:
 *        12
 *      /
 *     9
 *    / \
 *   6   11
 * BST2:
 *       8
 *     /  \
 *    5    10
 *   /
 *  2
 * Output: 2 5 6 8 9 10 11 12
 * Explanation: After merging and sorting the two BST we get 2 5 6 8 9 10 11 12.
 * Expected Time Complexity: O((m+n)*log(m+n))
 * Expected Auxiliary Space: O(Height of BST1 + Height of BST2 + m + n)
 */
public class MergeTwoBST {
    /*Solution One*/
    public List<Integer> mergeSolutionOne(Node root1, Node root2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        Node head = root1;
        queue.add(head);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            minHeap.add(current.data);

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        head = root2;
        queue.add(head);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            minHeap.add(current.data);

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }

    /*Solution two*/
    public List<Integer> mergeSolutionTwo(Node root1, Node root2) {
        List<Integer> sortedListOne = new ArrayList<>();
        List<Integer> sortedListTwo = new ArrayList<>();

        inOrderTraverse(root1, sortedListOne);
        inOrderTraverse(root2, sortedListTwo);
        return mergeList(sortedListOne, sortedListTwo);

    }

    public List<Integer> mergeList(List<Integer> sortedListOne, List<Integer> sortedListTwo) {
        List<Integer> mergedList = new ArrayList<>();

        if (sortedListOne.get(sortedListOne.size() - 1) <= sortedListTwo.get(0)) {
            int index = 0;
            while (index < sortedListOne.size()) {
                mergedList.add(sortedListOne.get(index++));
            }
            index = 0;
            while (index < sortedListTwo.size()) {
                mergedList.add(sortedListTwo.get(index++));
            }
            return mergedList;
        } else {
            int i = 0, j = 0;
            while (i < sortedListOne.size() && j < sortedListTwo.size()) {
                mergedList.add(sortedListOne.get(i) <= sortedListTwo.get(j) ? sortedListOne.get(i++) : sortedListTwo.get(j++));
            }
            while (true) {
                if (i < sortedListOne.size()) {
                    mergedList.add(sortedListOne.get(i++));
                } else if (j < sortedListTwo.size()) {
                    mergedList.add(sortedListTwo.get(j++));
                } else {
                    break;
                }
            }
            return mergedList;
        }
    }

    public void inOrderTraverse(Node subTree, List<Integer> list) {
        if (subTree.left != null) {
            inOrderTraverse(subTree.left, list);
        }
        list.add(subTree.data);
        if (subTree.right != null) {
            inOrderTraverse(subTree.right, list);
        }
    }

    class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
}
