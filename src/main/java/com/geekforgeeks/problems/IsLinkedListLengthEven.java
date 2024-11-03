package com.geekforgeeks.problems;

/**
 * Given a linked list, your task is to complete the function isLengthEven() which contains the head of
 * the linked list, and check whether the length of the linked list is even or not. Return true if it is even,
 * otherwise false.
 *
 * Examples:
 *
 * Input: Linked list: 12->52->10->47->95->0
 *
 * Output: true
 * Explanation: The length of the linked list is 6 which is even, hence returned true.
 * Input: Linked list: 9->4->3
 *
 * Output: false
 * Explanation: The length of the linked list is 3 which is odd, hence returned false.
 * Expected Time Complexity: O(n)
 * Expected Auxillary Space: O(1)
 */
public class IsLinkedListLengthEven {
    public boolean isLengthEven(Node head) {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return (count ^ 1) > count;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
