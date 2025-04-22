package com.geekforgeeks.problems.partone;

/**
 * Given a linked list where nodes can contain values 0s, 1s, and 2s only. The task is to segregate
 * 0s, 1s, and 2s linked list such that all zeros segregate to the head side, 2s at the end of the
 * linked list, and 1s in the middle of 0s and 2s.
 *
 * Examples:
 *
 * Input: LinkedList: 1->2->2->1->2->0->2->2
 * Output: 0->1->1->2->2->2->2->2
 * Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the
 * list, and 1s in between.
 *
 * Input: LinkedList: 2->2->0->1
 * Output: 0->1->2->2
 * Explanation: After arranging all the 0s,1s and 2s in the given format, the output will be 0 1 2 2.
 *
 * Expected Time Complexity: O(n).
 * Expected Auxiliary Space: O(n).
 */
public class Sort_A_LinkedListOf_0s_1s_And_2s {
    public static Node segregate(Node head) {
        Node zeroes = null;
        Node zeroesRef = null;

        Node ones = null;
        Node onesRef = null;

        Node twoes = null;
        Node twoesRef = null;

        while (head != null) {
            if (head.data == 0) {
                if (zeroes == null) {
                    zeroes = new Node(head.data);
                    zeroesRef = zeroes;
                } else {
                    zeroesRef.next = new Node(head.data);
                    zeroesRef = zeroesRef.next;
                }
            } else if (head.data == 1) {
                if (ones == null) {
                    ones = new Node(head.data);
                    onesRef = ones;
                } else {
                    onesRef.next = new Node(head.data);
                    onesRef = onesRef.next;
                }
            } else {
                if (twoes == null) {
                    twoes = new Node(head.data);
                    twoesRef = twoes;
                } else {
                    twoesRef.next = new Node(head.data);
                    twoesRef = twoesRef.next;
                }
            }
            head = head.next;
        }

        if (ones != null) {
            onesRef.next = twoes;
        }
        if (zeroes != null) {
            zeroesRef.next = ones != null ? ones : twoes;
        }
        return zeroes != null ? zeroes : ones != null ? ones : twoes;
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
}
