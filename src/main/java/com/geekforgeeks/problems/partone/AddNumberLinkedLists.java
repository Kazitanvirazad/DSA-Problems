package com.geekforgeeks.problems.partone;

/**
 * Given two numbers, num1, and num2, represented by linked lists. The task is to return the head of the linked list
 * representing the sum of these two numbers.
 *
 * For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null.
 * Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return
 * the head of the linked list 2->1->5->null.
 *
 * Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.
 *
 * Examples:
 *
 * Input: num1 = 45 (4->5->null), num2 = 345 (3->4->5->null)
 * Output:  3->9->0->null
 *
 * Explanation:
 * For the given two linked list (4 5) and (3 4 5), after adding the two linked list resultant linked list will be (3 9 0).
 * Input: num1 = 0063 (0->0->6->3->null), num2 = 07 (0->7->null)
 * Output: 7->0->null
 *
 * Explanation:
 * For the given two linked list (0 0 6 3) and (0 7), after adding the two linked list resultant linked list will be (7 0).
 * Expected Time Complexity: O(n+m)
 * Expected Space Complexity: O(max(n,m)) for the resultant list.
 */
public class AddNumberLinkedLists {

    public static Node addTwoLists(Node num1, Node num2) {
        num1 = reverseList(num1);
        num2 = reverseList(num2);

        int carry;
        int numElementOne = num1.data;
        int numElementTwo = num2.data;
        int sum = numElementOne + numElementTwo;

        Node res = new Node(sum % 10);
        carry = sum / 10;

        num1 = num1.next;
        num2 = num2.next;
        while (num1 != null || num2 != null) {
            numElementOne = num1 != null ? num1.data : 0;
            num1 = num1.next;
            numElementTwo = num2 != null ? num2.data : 0;
            num2 = num2.next;

            sum = numElementOne + numElementTwo + carry;
            Node node = new Node(sum % 10);
            node.next = res;
            res = node;
            carry = sum / 10;
        }

        while (carry != 0) {
            Node node = new Node(carry % 10);
            node.next = res;
            res = node;
            carry = carry / 10;
        }
        return res;
    }

    public static Node reverseList(Node head) {
        Node current = new Node(head.data);
        head = head.next;
        while (head != null) {
            Node node = new Node(head.data);
            node.next = current;
            current = node;
            head = head.next;
        }
        return current;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

