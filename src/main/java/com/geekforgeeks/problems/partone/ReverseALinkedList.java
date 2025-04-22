package com.geekforgeeks.problems.partone;

/**
 * Given the head of a linked list, the task is to reverse this list and return the reversed head.
 *
 * Examples:
 *
 * Input: Linked list: 1->2->3->4->5->6
 * Output: 6->5->4->3->2->1
 * Explanation:
 *
 * Input: Linked list: 2->7->10->9->8
 * Output: 8->9->10->7->2
 * Explanation:
 *
 * Input: Linked List: 10
 * Output: 10
 * Explanation: For a single node list, the reverse would be same as original
 * Expected Time Complexity: O(n)
 * Expected Space Complexity: O(1)
 */
public class ReverseALinkedList {

    public Node reverseList(Node head) {
        Node current = head;
        Node reverseNode = null;

        while (current != null) {
            Node newNode = new Node(current.data);

            if (reverseNode == null) {
                reverseNode = newNode;
            } else {
                newNode.next = reverseNode;
                reverseNode = newNode;
            }

            current = current.next;
        }
        return reverseNode;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
}
