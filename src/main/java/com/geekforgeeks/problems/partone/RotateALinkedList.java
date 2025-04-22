package com.geekforgeeks.problems.partone;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the head of a singly linked list, the task is to rotate the left shift of the linked list by k nodes,
 * where k is a given positive integer smaller than or equal to the length of the linked list.
 *
 * Examples:
 *
 * Input: linkedlist: 2->4->7->8->9 , k = 3
 * Output: 8->9->2->4->7
 * Explanation:
 * Rotate 1: 4 -> 7 -> 8 -> 9 -> 2
 * Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
 * Rotate 3: 8 -> 9 -> 2 -> 4 -> 7
 *
 * Input: linkedlist: 1->2->3->4->5->6->7->8 , k = 4
 * Output: 5->6->7->8->1->2->3->4
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class RotateALinkedList {

    public Node rotate(Node head, int k) {
        if (head.next == null) {
            return head;
        }
        Queue<Integer> queue = new LinkedList<>();

        Node current = head;
        for (int i = 0; i < k; i++) {
            queue.add(current.data);
            current = current.next;
        }

        if (current == null) {
            return head;
        }
        Node newNode = new Node(current.data);
        Node temp = newNode;
        current = current.next;
        while (current != null) {
            Node node = new Node(current.data);
            temp.next = node;
            temp = temp.next;
            current = current.next;
        }

        while (!queue.isEmpty()) {
            Node node = new Node(queue.poll());
            temp.next = node;
            temp = temp.next;
        }
        return newNode;
    }

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
