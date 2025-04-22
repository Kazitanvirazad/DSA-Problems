package com.geekforgeeks.problems.partone;

/**
 * Given elements as nodes of the two singly linked lists. The task is to multiply these two linked lists,
 * say L1 and L2.
 *
 * Note: The output could be large take modulo 10^9+7.
 *
 * Examples :
 *
 * Input: LinkedList L1 : 3->2 , LinkedList L2 : 2
 * Output: 64
 * Explanation:
 *
 * Multiplication of 32 and 2 gives 64.
 * Input: LinkedList L1: 1->0->0 , LinkedList L2 : 1->0
 * Output: 1000
 * Explanation:
 *
 * Multiplication of 100 and 10 gives 1000.
 * Expected Time Complexity: O(max(n,m))
 * Expected Auxilliary Space: O(1)
 * where n is the size of L1 and m is the size of L2
 */
public class MultiplyTwoLinkedLists {
    public long multiplyTwoLists(Node first, Node second) {
        long firstElementsTotal = 0L;
        long secondElementsTotal = 0L;

        int mod = 1000000007;

        Node firstHead = first;
        Node secondHead = second;

        while (firstHead != null || secondHead != null) {
            if (firstHead != null) {
                firstElementsTotal = (firstElementsTotal * 10 + firstHead.data) % mod;
                firstHead = firstHead.next;
            }
            if (secondHead != null) {
                secondElementsTotal = (secondElementsTotal * 10 + secondHead.data) % mod;
                secondHead = secondHead.next;
            }
        }

        return (firstElementsTotal * secondElementsTotal) % mod;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
