package com.geekforgeeks.problems.parttwo;

/**
 * You are given the head of a linked list. You have to replace all the values of the nodes with the nearest prime
 * number. If more than one prime number exists at an equal distance, choose the smallest one. Return the head
 * of the modified linked list.
 *
 * Examples :
 *
 * Input: head = 2 → 6 → 10
 * Output: 2 → 5 → 11
 *
 * Explanation: The nearest prime of 2 is 2 itself. The nearest primes of 6 are 5 and 7, since 5 is smaller so,
 * 5 will be chosen. The nearest prime of 10 is 11.
 * Input: head = 1 → 15 → 20
 * Output: 2 → 13 → 19
 *
 * Explanation: The nearest prime of 1 is 2. The nearest primes of 15 are 13 and 17, since 13 is smaller so, 13
 * will be chosen. The nearest prime of 20 is 19.
 * Constraints:
 * 1 <= no. of Nodes <= 104
 * 1 <= node.val <= 104
 */
public class PrimeList {
    class Node {
        Node next;
        int val;

        public Node(int data) {
            val = data;
            next = null;
        }
    }

    public Node primeList(Node head) {
        Node current = head;
        while (current != null) {
            if (!isPrime(current.val)) {
                current.val = findNearestPrimeNumFromBothDirection(current.val);
            }
            current = current.next;
        }
        return head;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int findNearestPrimeNumFromBothDirection(int num) {
        int low = num - 1;
        int high = num + 1;

        while (true) {
            boolean lowPrime = false;
            boolean highPrime = false;
            if (low > 1 && isPrime(low)) {
                lowPrime = true;
            }
            if (isPrime(high)) {
                highPrime = true;
            }
            if (lowPrime && highPrime) {
                if (num - low == high - num) {
                    return low;
                }
                if (num - low > high - num) {
                    return high;
                }
                return low;
            }
            if (lowPrime) {
                return low;
            }
            if (highPrime) {
                return high;
            }
            low--;
            high++;
        }
    }
}
