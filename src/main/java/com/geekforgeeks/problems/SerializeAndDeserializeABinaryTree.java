package com.geekforgeeks.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree
 * back from the array. Complete the functions
 *
 * serialize() : stores the tree into an array a and returns the array.
 * deSerialize() : deserializes the array to the tree and returns the root of the tree.
 * Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be
 * correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will
 * print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).
 *
 * Examples :
 *
 * Input: root = [1, 2, 3]
 *
 * Output: [2, 1, 3]
 * Input: root = [10, 20, 30, 40, 60, N, N]
 *
 * Output: [40, 20, 60, 10, 30]
 * Constraints:
 * 1 <= Number of nodes <= 104
 * 1 <= Data of a node <= 109
 */
public class SerializeAndDeserializeABinaryTree {
    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                res.add(-1);
                continue;
            }
            res.add(current.data);
            queue.add(current.left);
            queue.add(current.right);
        }

        return res;
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        if (arr.get(0) == -1) {
            return null;
        }
        int index = 0;
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(arr.get(index));
        queue.add(root);
        index++;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (arr.get(index) != -1) {
                Node left = new Node(arr.get(index));
                current.left = left;
                queue.add(left);
            }
            index++;
            if (arr.get(index) != -1) {
                Node right = new Node(arr.get(index));
                current.right = right;
                queue.add(right);
            }
            index++;
        }
        return root;
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
