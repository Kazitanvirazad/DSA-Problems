package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Given a binary tree, return an array where elements represent the bottom view of the binary tree from left to right.
 *
 * Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in
 * the level traversal is considered. For example, in the below diagram, 3 and 4 are both the bottommost nodes at
 * a horizontal distance of 0, here 4 will be considered.
 *
 *                       20
 *                     /    \
 *                   8       22
 *                 /   \     /   \
 *               5      3 4     25
 *                      /    \
 *                  10       14
 *
 * For the above tree, the output should be 5 10 4 14 25.
 *
 * Examples :
 *
 * Input:
 *        1
 *      /   \
 *     3     2
 * Output: 3 1 2
 * Explanation: First case represents a tree with 3 nodes and 2 edges where root is 1,
 * left child of 1 is 3 and right child of 1 is 2.
 *
 * Thus bottom view of the binary tree will be 3 1 2.
 * Input:
 *          10
 *        /    \
 *       20    30
 *      /  \
 *     40   60
 * Output: 40 20 60 30
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(n)
 */
public class BottomViewOfBinaryTree {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> array = new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node current = root;
        int hd = 0;
        current.hd = hd;
        queue.add(current);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            hd = temp.hd;
            map.put(hd, temp.data);

            if (temp.left != null) {
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }
        }

        map.keySet().forEach(key -> array.add(map.get(key)));
        return array;
    }

    class Node {
        int data;
        int hd;
        Node left, right;

        public Node(int key) {
            data = key;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }
}
