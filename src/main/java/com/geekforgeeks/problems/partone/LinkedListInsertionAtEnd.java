package com.geekforgeeks.problems.partone;

/**
 * Given the head of a Singly Linked List and a value x, insert that value x at the end of the LinkedList
 * and return the modified Linked List.
 *
 * Examples :
 *
 * Input: LinkedList: 1->2->3->4->5 , x = 6
 * Output: 1->2->3->4->5->6
 * Explanation:
 *
 * We can see that 6 is inserted at the end of the linkedlist.
 * Input: LinkedList: 5->4 , x = 1
 * Output: 5->4->1
 * Explanation:
 *
 * We can see that 1 is inserted at the end of the linkedlist.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class LinkedListInsertionAtEnd {
    public Node insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.next == null) {
                temp.next = newNode;
                break;
            }
            if (temp.next != null && temp.next.next != null) {
                temp = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
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
