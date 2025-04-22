package com.geekforgeeks.problems.partone;

/**
 * Given the head of a linked list, determine whether the list contains a loop. If a loop is present,
 * return the number of nodes in the loop, otherwise return 0.
 *
 *
 *
 * Note: 'c' is the position of the node which is the next pointer of the last node of the linkedlist.
 * If c is 0, then there is no loop.
 *
 * Examples:
 *
 * Input: LinkedList: 25->14->19->33->10->21->39->90->58->45, c = 4
 * Output: 7
 * Explanation: The loop is from 33 to 45. So length of loop is 33->10->21->39-> 90->58->45 = 7.
 * The number 33 is connected to the last node of the linkedlist to form the loop because according to
 * the input the 4th node from the beginning(1 based indexing)
 * will be connected to the last node for the loop.
 *
 * Input: LinkedList: 5->4, c = 0
 * Output: 0
 * Explanation: There is no loop.
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class FindLengthOfLoop {
    public int countNodesinLoop(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        boolean isLoopDetected = false;
        Node lastNode = head;
        while (slowPointer != null && fastPointer != null) {
            slowPointer = slowPointer.next;
            if (fastPointer.next != null) {
                fastPointer = fastPointer.next.next;
            } else {
                break;
            }

            if (slowPointer.equals(fastPointer)) {
                isLoopDetected = true;
                break;
            }
            lastNode = lastNode.next;
        }

        int loopLength = 0;
        boolean reachedCountStartPosition = false;
        if (isLoopDetected) {
            slowPointer = head;

            while (true) {
                if (slowPointer.next.equals(fastPointer.next)) {
                    reachedCountStartPosition = true;
                    break;
                } else {
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                }
            }
        }
        if (reachedCountStartPosition) {
            while (true) {
                slowPointer = slowPointer.next;
                loopLength++;
                if (slowPointer.equals(fastPointer)) {
                    break;
                }
            }
        }
        return loopLength;
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
