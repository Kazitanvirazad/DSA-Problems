package com.geekforgeeks.problems.partone;

/**
 * Given a Singly Linked List, Delete all alternate nodes of the list ie delete all the nodes present in even positions.
 *
 * Examples :
 *
 * Input: LinkedList: 1->2->3->4->5->6
 *
 * Output: 1->3->5
 *
 * Explanation: Deleting alternate nodes ie 2, 4, 6 results in the linked list with elements 1->3->5.
 * Input: LinkedList: 99->59->42->20
 *
 * Output: 99->42
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class DeleteAlternateNodes {
    public void deleteAlt(Node head) {
        int position = 1;
        Node temp = head;
        while (temp != null) {
            if (position % 2 != 0 && temp.next != null) {
                if (temp.next.next == null) {
                    temp.next = null;
                } else {
                    Node node = temp.next.next;
                    temp.next.next = null;
                    temp.next = node;
                }
                position++;
            }
            temp = temp.next;
            position++;
        }
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
