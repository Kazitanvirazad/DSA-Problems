package com.geekforgeeks.problems.partone;

import java.util.PriorityQueue;

/**
 * Given a Linked List, where every node represents a sub-linked-list and contains two pointers:
 * (i) a next pointer to the next node,
 * (ii) a bottom pointer to a linked list where this node is head.
 * Each of the sub-linked lists is in sorted order.
 * Flatten the Link List so all the nodes appear in a single level while maintaining the sorted order.
 *
 * Note: **The flattened list will be printed using the bottom pointer instead of the next pointer.**
 *
 * Examples:
 *
 * Input:
 *
 * Output:  5-> 7-> 8- > 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
 * Explanation: The resultant linked lists has every node in a single level.(Note: | represents the bottom pointer.)
 * Input:
 *
 * Output: 5-> 7-> 8-> 10-> 19-> 22-> 28-> 30-> 50
 * Explanation: The resultant linked lists has every node in a single level.(Note: | represents the bottom pointer.)
 * Note: In the output section of the above examples, the -> represents the bottom pointer.
 *
 * Expected Time Complexity: O(n * n * m)
 * Expected Auxiliary Space: O(n)
 *
 * Constraints:
 * 0 <= number of nodes <= 50
 * 1 <= no. of nodes in sub-LinkedList(mi) <= 20
 * 1 <= node->data <= 103
 */
public class FlatteningALinkedList {
    public Node flatten(Node root) {
        Node temp = root;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while (temp != null) {
            minHeap.add(temp.data);
            if (temp.bottom != null) {
                Node bottom = temp.bottom;
                while (bottom != null) {
                    minHeap.add(bottom.data);
                    bottom = bottom.bottom;
                }
            }
            temp = temp.next;
        }

        Node flattenedList = null;
        Node tempFlattenedList = null;

        while (!minHeap.isEmpty()) {
            if (flattenedList == null) {
                flattenedList = new Node(minHeap.poll());
                tempFlattenedList = flattenedList;
                continue;
            }
            tempFlattenedList.bottom = new Node(minHeap.poll());
            tempFlattenedList = tempFlattenedList.bottom;
        }

        return flattenedList;
    }

    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int x) {
            data = x;
            next = null;
            bottom = null;
        }
    }
}