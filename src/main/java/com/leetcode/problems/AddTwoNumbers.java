package com.leetcode.problems;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order, and each of their nodes contains a single digit. Add the two numbers
 * and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;

        int carry = 0;
        ListNode result = null;
        ListNode current = result;

        while (head1 != null || head2 != null) {
            int sum = carry;
            carry = 0;
            if (head1 != null) {
                sum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.val;
                head2 = head2.next;
            }
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }
            if (current == null) {
                current = new ListNode(sum);
                result = current;
            } else {
                current.next = new ListNode(sum);
                current = current.next;
            }
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
