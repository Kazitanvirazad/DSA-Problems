package com.geekforgeeks.problems;

/**
 * Given a singly linked list. The task is to find the length of the linked list, where length is defined as the
 * number of nodes in the linked list.
 *
 * Examples :
 *
 * Input: LinkedList : 1->2->3->4->5
 *
 * Output: 5
 * Explanation: Count of nodes in the linked list is 5, which is its length.
 * Input: LinkedList : 2->4->6->7->5->1->0
 *
 * Output: 7
 * Explanation: Count of nodes in the linked list is 7. Hence, the output is 7.
 * Expected Time Complexity: O(n)
 * Expected Auxilliary Space: O(1)
 */
public class CountLinkedListNodes {
    public int getCount(Node head) {
        if (head.next == null) {
            return 1;
        }

        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }

    class Node {
        int data;
        Node next;

        Node(int a) {
            data = a;
            next = null;
        }
    }
}
