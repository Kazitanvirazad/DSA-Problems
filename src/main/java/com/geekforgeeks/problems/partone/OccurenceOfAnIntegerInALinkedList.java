package com.geekforgeeks.problems.partone;

/**
 * Given a singly linked list and a key, count the number of occurrences of the given key in the linked list.
 *
 * Examples:
 *
 * Input: Linked List: 1->2->1->2->1->3->1, key = 1
 *
 * Output: 4
 * Explanation: 1 appears 4 times.
 * Input: Linked List: 1->2->1->2->1, key = 3
 *
 * Output: 0
 * Explanation: 3 appears 0 times.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class OccurenceOfAnIntegerInALinkedList {
    public static int count(Node head, int key) {
        int res = 0;
        while (head != null) {
            if (head.data == key) {
                res++;
            }
            head = head.next;
        }
        return res;
    }

    class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }
}
