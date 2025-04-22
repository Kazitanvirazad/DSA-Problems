package com.geekforgeeks.problems.partone;

import java.util.Stack;

/**
 * Given a single linked list, calculate the sum of the last n nodes.
 *
 * Note: It is guaranteed that n <= number of nodes.
 *
 * Examples:
 *
 * Input: Linked List: 5->9->6->3->4->10, n = 3
 *
 * Output: 17
 * Explanation: The sum of the last three nodes in the linked list is 3 + 4 + 10 = 17.
 * Input: Linked List: 1->2, n = 2
 *
 * Output: 3
 * Explanation: The sum of the last two nodes in the linked list is 2 + 1 = 3.
 */
public class FindTheSumOfLast_N_NodesOfTheLinkedList {

    public int sumOfLastN_Nodes(Node head, int n) {
        Node current = head;
        Stack<Integer> stack = new Stack<>();

        while (current != null) {
            stack.add(current.data);
            current = current.next;
        }

        int sum = 0;

        while (!stack.isEmpty() && n > 0) {
            sum += stack.pop();
            n--;
        }

        return sum;
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
