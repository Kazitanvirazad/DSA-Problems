package com.geekforgeeks.problems;

/**
 * Given the head of a linked list that may contain a loop.  A loop means that the last node of the linked
 * list is connected back to a node in the same list.  So if the next of the previous node is null. Then
 * there is no loop.  Remove the loop from the linked list, if it is present (we mainly need to make the next
 * of the last node null). Otherwise, keep the linked list as it is.
 * <p>
 * Note: Given an integer, pos (1 based index)  Position of the node to which the last node links back if
 * there is a loop. If the linked list does not have any loop, then pos = 0.
 * <p>
 * The generated output will be true if your submitted code is correct, otherwise, false.
 * <p>
 * Examples:
 * <p>
 * Input: Linked list: 1->3->4, pos = 2
 * Output: true
 * Explanation: The linked list looks like
 * <p>
 * A loop is present. If you remove it successfully, the answer will be true.
 * Input: Linked list: 1->8->3->4, pos = 0
 * Output: true
 * Explanation:
 * <p>
 * The Linked list does not contains any loop.
 * Input: Linked list: 1->2->3->4, pos = 1
 * Output: true
 * Explanation: The linked list looks like
 * <p>
 * A loop is present. If you remove it successfully, the answer will be true.
 * Expected Time Complexity: O(n)
 * Expected Space Complexity: O(1)
 */
public class RemoveLoopInLinkedList {
    public static void removeLoop(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        boolean isLoopDetected = false;
        Node lastNode = head;
        while (slowPointer != null && fastPointer != null) {
            slowPointer = slowPointer.next;
            if (fastPointer.next != null) {
                fastPointer = fastPointer.next.next;
            } else {
                break;
            }

            if (slowPointer.equals(fastPointer)) {
                // handling scenario if meeting point is at head node
                if (slowPointer.equals(head)) {
                    lastNode.next = null;
                    break;
                }
                isLoopDetected = true;
                break;
            }
            lastNode = lastNode.next;
        }

        if (isLoopDetected) {
            slowPointer = head;

            while (true) {
                if (slowPointer.next.equals(fastPointer.next)) {
                    fastPointer.next = null;
                    break;
                } else {
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                }
            }
        }
    }

    class Node {
        int data;
        Node next;
    }
}
