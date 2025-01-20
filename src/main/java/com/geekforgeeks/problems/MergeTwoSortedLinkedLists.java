package com.geekforgeeks.problems;

/**
 * Given the head of two sorted linked lists consisting of nodes respectively. The task is to merge both lists
 * and return the head of the sorted merged list.
 *
 * Examples:
 *
 * Input: head1 = 5 -> 10 -> 15 -> 40, head2 = 2 -> 3 -> 20
 * Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40
 * Explanation:
 *
 * Input: head1 = 1 -> 1, head2 = 2 -> 4
 * Output: 1 -> 1 -> 2 -> 4
 * Explanation:
 *
 * Constraints:
 * 1 <= no. of nodes<= 103
 * 0 <= node->data <= 105
 */
public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        MergeTwoSortedLinkedLists mergeTwoSortedLinkedLists = new MergeTwoSortedLinkedLists();
        Node node1 = new Node(5);
        Node node2 = new Node(2);

        Node temp1 = node1;
        Node temp2 = node2;
        temp1.next = new Node(10);
        temp1 = temp1.next;
        temp1.next = new Node(15);
        temp1 = temp1.next;
        temp1.next = new Node(40);

        temp2.next = new Node(3);
        temp2 = temp2.next;
        temp2.next = new Node(20);

        Node res = mergeTwoSortedLinkedLists.sortedMerge(node1, node2);
        while (res != null) {
            System.out.println(res.data);
            res = res.next;
        }
    }

    public Node sortedMerge(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        Node res = null;
        Node tempRes = null;

        while (temp1 != null || temp2 != null) {
            int currentVal;
            if (temp1 == null) {
                int data = temp2.data;
                temp2 = temp2.next;
                currentVal = data;
            } else if (temp2 == null) {
                int data = temp1.data;
                temp1 = temp1.next;
                currentVal = data;
            } else {
                int data1 = temp1.data;
                int data2 = temp2.data;
                if (data1 < data2) {
                    temp1 = temp1.next;
                    currentVal = data1;
                } else {
                    temp2 = temp2.next;
                    currentVal = data2;
                }
            }

            if (res == null) {
                res = new Node(currentVal);
                tempRes = res;
            } else {
                tempRes.next = new Node(currentVal);
                tempRes = tempRes.next;
            }
        }
        return res;
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
