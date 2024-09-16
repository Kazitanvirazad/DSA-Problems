package com.geekforgeeks.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a singly linked list of integers. The task is to check if the given linked list is palindrome or not.
 *
 * Examples:
 *
 * Input: LinkedList: 1->2->1->1->2->1
 * Output: true
 * Explanation: The given linked list is 1->2->1->1->2->1 , which is a palindrome and Hence, the output is true.
 *
 * Input: LinkedList: 1->2->3->4
 * Output: false
 * Explanation: The given linked list is 1->2->3->4, which is not a palindrome and Hence, the output is false.
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 * Note: You should not use the recursive stack space as well
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(Node head) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        if (head.next == null) {
            return true;
        }

        Node current = head;
        while (current != null) {
            queue.add(current.data);
            stack.add(current.data);
            current = current.next;
        }

        while (!queue.isEmpty() || !stack.isEmpty()) {
            if (!queue.poll().equals(stack.pop())) {
                return false;
            }
        }
        return true;
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
