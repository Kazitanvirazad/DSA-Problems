package com.geekforgeeks.problems.partone;

/**
 * Given the head of a linked list, the task is to find the middle.
 * For example, the middle of 1-> 2->3->4->5 is 3. If there are two middle nodes (even count),
 * return the second middle. For example, middle of 1->2->3->4->5->6 is 4.
 * <p>
 * Examples:
 * <p>
 * Input: Linked list: 1->2->3->4->5
 * Output: 3
 * <p>
 * Explanation: The given linked list is 1->2->3->4->5 and its middle is 3.
 * <p>
 * Input: Linked list: 2->4->6->7->5->1
 * Output: 7
 * <p>
 * Explanation: The given linked list is 2->4->6->7->5->1 and its middle is 7.
 * <p>
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class MiddleOfALinkedList {

    public static int getMiddle(Node head) {
        if (head.next == null) {
            return head.data;
        }
        Node startNodePointerOne = head;
        Integer res = null;
        Node startNodePointerTwo = head;
        while (startNodePointerOne.next != null) {
            if (startNodePointerTwo == null || startNodePointerTwo.next == null) {
                res = startNodePointerOne.data;
                break;
            }
            startNodePointerOne = startNodePointerOne.next;
            startNodePointerTwo = startNodePointerTwo.next.next;
        }
        return res;
    }

    public static class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }
}
