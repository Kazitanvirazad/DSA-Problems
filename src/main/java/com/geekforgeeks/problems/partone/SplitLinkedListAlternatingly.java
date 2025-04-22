package com.geekforgeeks.problems.partone;

/**
 * Given a singly linked list's head. Your task is to complete the function alternatingSplitList() that splits the
 * given linked list into two smaller lists. The sublists should be made from alternating elements from the original list.
 * Note:
 *
 * The sublist should be in the order with respect to the original list.
 * Your have to return an array containing the both sub-linked lists.
 * Examples:
 *
 * Input: LinkedList = 0->1->0->1->0->1
 * Output: 0->0->0 , 1->1->1
 * Explanation: After forming two sublists of the given list as required, we have two lists as: 0->0->0 and 1->1->1.
 *
 * Input: LinkedList = 2->5->8->9->6
 * Output: 2->8->6 , 5->9
 * Explanation: After forming two sublists of the given list as required, we have two lists as: 2->8->6 and 5->9.
 * Input: LinkedList: 7
 * Output: 7 , <empty linked list>
 */
public class SplitLinkedListAlternatingly {
    public Node[] alternatingSplitList(Node head) {
        Node[] res = new Node[2];
        if (head.next == null) {
            res[0] = head;
            return res;
        }

        Node current = head;
        res[0] = new Node(current.data);
        current = current.next;
        res[1] = new Node(current.data);
        current = current.next;

        Node firstListPointer = res[0];
        Node secondListPointer = res[1];

        while (current != null) {
            firstListPointer.next = new Node(current.data);
            firstListPointer = firstListPointer.next;
            current = current.next;
            if (current != null) {
                secondListPointer.next = new Node(current.data);
                secondListPointer = secondListPointer.next;
                current = current.next;
            }
        }
        return res;
    }

    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }
}
