package com.geekforgeeks.problems.partone;

import java.util.PriorityQueue;

/**
 * Given a doubly linked list, each node is at most k-indices away from its target position.
 * The problem is to sort the given doubly linked list. The distance can be assumed in either
 * of the directions (left and right).
 *
 * Examples :
 *
 * Input: Doubly Linked List : 3 <-> 2 <-> 1 <-> 5 <-> 6 <-> 4 , k = 2
 * Output: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6
 *
 * Explanation: After sorting the given 2-sorted list is 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6.
 * Input: Doubly Linked List : 5 <-> 6 <-> 7 <-> 3 <-> 4 <-> 4 , k = 3
 * Output: 3 <-> 4 <-> 4 <-> 5 <-> 6 <-> 7
 *
 * Explanation: After sorting the given 3-sorted list is 3 <-> 4 <-> 4 <-> 5 <-> 6 <-> 7.
 * Expected Time Complexity: O(n*logk)
 * Expected Auxiliary Space: O(k)
 */
public class Sort_a_K_SortedDoublyLinkedList {
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        PriorityQueue<DLLNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.data - o2.data);
        for (int i = 0; head != null && i < k + 1; i++) {
            minHeap.add(head);
            head = head.next;
        }
        DLLNode current = null;
        DLLNode temp = null;
        while (!minHeap.isEmpty()) {
            if (current == null) {
                current = minHeap.poll();
                current.prev = null;
                temp = current;
            } else {
                temp.next = minHeap.poll();
                temp.next.prev = temp;
                temp = temp.next;
            }

            if (head != null) {
                minHeap.add(head);
                head = head.next;
            }
        }
        temp.next = null;
        return current;
    }

    class DLLNode {
        int data;
        DLLNode next;
        DLLNode prev;

        DLLNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
