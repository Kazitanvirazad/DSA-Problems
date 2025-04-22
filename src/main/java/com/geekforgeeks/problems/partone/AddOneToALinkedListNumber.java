package com.geekforgeeks.problems.partone;

/**
 * You are given a linked list where each element in the list is a node and have an integer data. You need to
 * add 1 to the number formed by concatinating all the list node numbers together and return
 * the head of the modified linked list.
 *
 * Note: The head represents the first element of the given array.
 *
 * Examples :
 *
 * Input: LinkedList: 4->5->6
 * Output: 457
 *
 * Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457.
 * Input: LinkedList: 1->2->3
 * Output: 124
 *
 * Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class AddOneToALinkedListNumber {
    public Node addOne(Node head) {
        if (head.next == null) {
            head.data += 1;
            return head;
        }
        StringBuilder num = new StringBuilder();

        Node current = head;
        while (current != null) {
            int data;

            if (current.data > 8) {
                data = 9;
            } else {
                data = current.data;
            }
            num.append(data);
            current = current.next;
        }

        String newData = num.toString();

        java.math.BigInteger bigInteger = new java.math.BigInteger(newData);
        bigInteger = bigInteger.add(new java.math.BigInteger("1"));
        newData = String.valueOf(bigInteger);

        Node newNode = new Node(Integer.parseInt(newData.substring(0, 1)));
        Node temp = newNode;
        for (int i = 1; i < newData.length(); i++) {
            Node node = new Node(Integer.parseInt(newData.substring(i, i + 1)));
            temp.next = node;
            temp = temp.next;
        }
        return newNode;
    }

    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }
}
