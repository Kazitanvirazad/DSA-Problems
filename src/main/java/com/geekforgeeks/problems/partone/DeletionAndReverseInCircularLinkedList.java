package com.geekforgeeks.problems.partone;

/**
 * Given a Circular Linked List. The task is to delete the given node, key in the circular linked list,
 * and reverse the circular linked list.
 *
 * Note:
 *
 * You don't have to print anything, just return the head of the modified list in each function.
 * Nodes may consist of Duplicate values.
 * The key may or may not be present.
 * Examples:
 *
 * Input: Linked List: 2->5->7->8->10, key = 8
 *
 * Output: 10->7->5->2
 * Explanation: After deleting 8 from the given circular linked list, it has elements as 2, 5, 7, 10. Now, reversing
 * this list will result in 10, 7, 5, 2, the resultant list is also circular.
 * Input: Linked List: 1->7->8->10, key = 8
 *
 * Output: 10->7->1
 * Explanation: After deleting 8 from the given circular linked list, it has elements as 1, 7,10. Now, reversing this
 * list will result in 10, 7, 1, the resultant list is also circular.
 * Input: Linked List: 3->6->4->10, key = 9
 * Output: 10->4->6->3
 * Explanation: As there no key present in the list, so simply reverse the list, the resultant list is also circular.
 * Expected Time Complexity: O(n)
 * Expected Auxillary Space: O(1)
 */
public class DeletionAndReverseInCircularLinkedList {

    public Node reverse(Node head) {
        Node top = head;
        Node current = top;
        Node newNode = new Node(current.data);
        Node newTemp = newNode;
        while ((current = current.next) != top) {
            Node temp = new Node(current.data);
            temp.next = newTemp;
            newTemp = temp;
        }
        newNode.next = newTemp;
        newNode = newNode.next;

        return newNode;
    }

    public Node deleteNode(Node head, int key) {
        Node top = head;
        Node current = top;
        if (current.data == key) {
            current.data = current.next.data;

            Node temp = current.next;
            current.next = temp.next;
            temp.next = null;
            return current;
        }
        while (current.next != top) {
            if (current.next.data == key) {
                Node temp = current.next;
                current.next = temp.next;
                break;
            }
            current = current.next;
        }
        return top;
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