package com.geekforgeeks.problems;

/**
 * You are given a Linked List. Sort the given Linked List using quicksort.
 *
 * Examples:
 *
 * Input: Linked list: 1->6->2
 * Output: 1->2->6
 *
 * Explanation:
 * After sorting the nodes, we have 1, 2 and 6.
 * Input: Linked list: 1->9->3->8
 * Output: 1->3->8->9
 *
 * Explanation:
 * After sorting the nodes, we have 1, 3, 8 and 9.
 * Constraints:
 * 1<= size of linked list <= 105
 */
public class QuickSortOnLinkedList {
    public static Node quickSort(Node node) {
        Node end = getEnd(node);
        quickSort(node, end);
        return node;
    }

    private static void quickSort(Node start, Node end) {
        if (start == null || start == end) {
            return;
        }
        Node pivot = getPivotNode(start, end);
        quickSort(start, pivot);
        quickSort(pivot.next, end);
    }

    private static Node getPivotNode(Node start, Node end) {
        Node pivot = start, previous = start, current = start;
        while (current != end.next) {
            if (current.data < pivot.data) {
                int temp = current.data;
                current.data = previous.next.data;
                previous.next.data = temp;
                previous = previous.next;
            }
            current = current.next;
        }
        int temp = pivot.data;
        pivot.data = previous.data;
        previous.data = temp;
        return previous;
    }

    private static Node getEnd(Node node) {
        if (node != null && node.next != null) {
            return getEnd(node.next);
        }
        return node;
    }

    class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }
}
