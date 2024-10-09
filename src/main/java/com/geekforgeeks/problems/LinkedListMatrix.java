package com.geekforgeeks.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a Matrix mat of n*n size. Your task is constructing a 2D linked list representation of the given matrix.
 *
 * Input: mat = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
 * Output:
 *
 * Input: mat = [[23, 28], [23, 28]]
 * Output:
 *
 * Expected Time Complexity: O(n2)
 * Expected Space Complexity: O(n2)
 */
public class LinkedListMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr1 = {{73, 35}, {92, 1}};
        Node node = construct(arr1);
    }

    public static Node construct(int arr[][]) {
        Queue<Node> queue = new LinkedList<>();

        for (int i = arr.length - 1; i > -1; i--) {
            Node rowNode = new Node(arr[i][0]);
            Node temp = rowNode;
            for (int j = 1; j < arr[i].length; j++) {
                Node node = new Node(arr[i][j]);
                temp.right = node;
                temp = temp.right;
            }
            queue.add(rowNode);
        }

        Node current = queue.poll();
        if (queue.isEmpty()) {
            return current;
        }
        Node head = null;
        while (!queue.isEmpty()) {
            Node oneAbove = queue.poll();
            head = oneAbove;

            while (oneAbove != null && current != null) {
                oneAbove.down = current;
                oneAbove = oneAbove.right;
                current = current.right;
            }
            current = head;
        }
        return head;
    }

    static class Node {
        int data;
        Node right, down;

        Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }
}
