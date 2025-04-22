package com.geekforgeeks.problems.partone;

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
        Stack<Node> stack = new Stack<>();

        Node current = head;
        while (current != null) {
            stack.add(current);
            current = current.next;
        }

        boolean isPalindrome = true;
        current = head;
        while (!stack.isEmpty()) {
            if (stack.peek().data != current.data) {
                isPalindrome = false;
                break;
            }
            current = current.next;
            stack.pop();
        }
        return isPalindrome;
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
