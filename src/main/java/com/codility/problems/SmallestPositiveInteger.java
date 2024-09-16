package com.codility.problems;

import java.util.PriorityQueue;

/**
 * class Solution { public int solution(int[] A); } that, given an array A of N
 * integers, returns the smallest positive integer (greater than 0) that does
 * not occur in A. For example, given A = [1, 3, 6, 4, 1, 2], the function
 * should return 5. Given A = [1, 2, 3], the function should return 4. Given A =
 * [−1, −3], the function should return 1. Write an efficient algorithm for the
 * following assumptions: N is an integer within the range [1..100,000]; each
 * element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class SmallestPositiveInteger {

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
//		int[] A = { 1, 2, 3 };
//		int[] A = { -1, -3 };
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                minHeap.add(A[i]);
            }
        }

        if (minHeap.isEmpty() || minHeap.peek() != 1) {
            return 1;
        }

        int top = minHeap.poll();

        int lastElement = top;
        while (!minHeap.isEmpty()) {
            int current = minHeap.poll();
            if (current - lastElement > 1) {
                return ++lastElement;
            }
            lastElement = current;
        }

        return ++lastElement;
    }
}
