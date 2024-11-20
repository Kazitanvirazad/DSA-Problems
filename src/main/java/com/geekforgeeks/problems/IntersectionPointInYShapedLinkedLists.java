package com.geekforgeeks.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two singly linked lists, return the point where two linked lists intersect.
 *
 * Note: If the linked lists do not merge at any point, return -1.
 *
 * Examples:
 *
 * Input: Linked list 1: 4->4->4->4->4, Linked list 2: 4->4->4
 *
 * Output: 4
 * Explanation: From the above image, it is clearly seen that the common part is 4->4 whose starting point is 4.
 *
 * Input: Linked list 1: 4->1->8->4->5, Linked List 2: 5->6->1->8->4->5
 *
 * Output: 8
 * Explanation: From the above image, it is clearly seen that the common part is 8->4->5 whose starting point is 8.
 * Input: Linked list 1: 1->2->3, Linked list 2: 4->5->6
 * Output: -1
 * Explanation: There is no common part, so there is no interaction point.
 * Try to solve the problem without using any extra space.
 */
public class IntersectionPointInYShapedLinkedLists {
    public int intersectPoint(Node head1, Node head2) {
        Set<Node> set = new HashSet<>();
        Node current = head1;
        while (current != null) {
            set.add(current);
            current = current.next;
        }
        current = head2;
        while (current != null) {
            if (set.contains(current)) {
                return current.data;
            }
            current = current.next;
        }
        return -1;
    }

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    class LinkedList {
        Node head;
    }
}