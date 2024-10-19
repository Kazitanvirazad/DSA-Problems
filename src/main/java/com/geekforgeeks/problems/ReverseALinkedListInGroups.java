package com.geekforgeeks.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a linked list, the task is to reverse every k node (where k is an input to the function) in
 * the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end,
 * should be considered as a group and must be reversed (See Example 2 for clarification).
 *
 * Examples:
 *
 * Input: Linked List: 1->2->2->4->5->6->7->8, k = 4
 * Output: 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5
 *
 * Explanation: The first 4 elements 1,2,2,4 are reversed first and then the next 4 elements 5,6,7,8.
 * Hence, the resultant linked list is 4->2->2->1->8->7->6->5.
 * Input: LinkedList: 1->2->3->4->5, k = 3
 * Output: 3 -> 2 -> 1 -> 5 -> 4
 *
 * Explanation: The first 3 elements 1,2,3 are reversed first and then element 4,5 are reversed.
 * Hence, the resultant linked list is 3->2->1->5->4.
 * Expected Time Complexity: O(n)
 * Expected Space Complexity: O(1)
 */
public class ReverseALinkedListInGroups {
    public static Node reverse(Node node, int k) {
        Queue<Node> queue = new LinkedList<>();

        int count = k;
        Node head = node;

        while (head != null) {
            Node current = new Node(head.data);
            head = head.next;
            count--;

            while (count > 0 && head != null) {
                Node temp = new Node(head.data);
                temp.next = current;
                current = temp;

                head = head.next;
                count--;
            }
            queue.add(current);
            count = k;
        }

        head = queue.poll();
        Node temp = head;
        while (temp != null) {
            if (temp.next == null && !queue.isEmpty()) {
                temp.next = queue.poll();
            }
            temp = temp.next;
        }

        return head;
    }

    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }
}
