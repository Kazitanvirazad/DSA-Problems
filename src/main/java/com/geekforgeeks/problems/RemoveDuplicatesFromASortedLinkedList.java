package com.geekforgeeks.problems;

/**
 * Given a singly linked list. The task is to remove duplicates (nodes with duplicate values) from
 * the given list (if it exists).
 * Note: Try not to use extra space. The nodes are arranged in a sorted way.
 *
 * Examples:
 *
 * Input:
 * LinkedList: 2->2->4->5
 * Output: 2 -> 4 -> 5
 *
 * Explanation: In the given linked list 2 -> 2 -> 4 -> 5, only 2 occurs more than 1 time. So we need to remove it once.
 * Input:
 * LinkedList: 2->2->2->2->2
 * Output: 2
 *
 * Explanation: In the given linked list  2 -> 2 -> 2 -> 2, 2 is the only element and is repeated 5 times.
 * So we need to remove any four 2.
 * Expected Time Complexity : O(n)
 * Expected Space Complexity: O(1)
 */
public class RemoveDuplicatesFromASortedLinkedList {
    public Node removeDuplicates(Node head) {
        if (head.next == null) {
            return head;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                Node node = temp.next.next;
                temp.next.next = null;
                temp.next = node;
            } else {
                temp = temp.next;
            }
        }
        return head;
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
