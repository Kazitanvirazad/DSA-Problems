package com.geekforgeeks.problems.partone;

import java.util.PriorityQueue;

/**
 * Given an array arr containing the lengths of the different ropes, we need to connect these ropes to form one rope.
 * The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = [4, 3, 2, 6]
 * Output: 29
 * Explanation: We can connect the ropes in following ways.
 * 1) First connect ropes of lengths 2 and 3. Which makes the array [4, 5, 6]. Cost of this operation 2 + 3 = 5.
 * <p>
 * 2) Now connect ropes of lengths 4 and 5. Which makes the array [9, 6]. Cost of this operation 4 + 5 = 9.
 * <p>
 * 3) Finally connect the two ropes and all ropes have connected. Cost of this operation 9 + 6 =15
 * <p>
 * Total cost for connecting all ropes is 5 + 9 + 15 = 29. This is the optimized cost for connecting ropes.
 * Other ways of connecting ropes would always have same or more cost. For example, if we connect 4 and 6 first
 * (we get three rope of 3, 2 and 10), then connect 10 and 3 (we gettwo rope of 13 and 2).
 * <p>
 * Finally we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38.
 *
 * <p>
 * Input: arr[] = [4, 2, 7, 6, 9]
 * Output: 62
 * Explanation: First, connect ropes 4 and 2, which makes the array [6, 7, 6, 9]. Cost of this operation 4 + 2 = 6.
 * <p>
 * Next, add ropes 6 and 6, which results in [12, 7, 9]. Cost of this operation 6 + 6 = 12.
 * <p>
 * Then, add 7 and 9, which makes the array [12,16]. Cost of this operation 7 + 9 = 16. And
 * finally, add these two which gives [28]. Hence, the total cost is 6 + 12 + 16 + 28 = 62.
 * <p>
 * Expected Time Complexity: O(n logn)
 * Expected Auxiliary Space: O(n)
 * <p>
 * Solution:
 * Follow the steps mentioned below to implement the idea:
 * <p>
 * Declare a priority queue and push all the elements in it.
 * Do following while the number of elements in min-heap is greater than one.
 * Extract the minimum and second minimum from min-heap
 * Add the above two extracted values and insert the added value to the min-heap.
 * Maintain a variable for total cost and keep incrementing it by the sum of extracted values.
 * Return the value of total cost.
 */
public class MinimumCostOfRopes {
    public static void main(String[] args) {
        long[] arr1 = {4, 3, 2, 6};
        long[] arr2 = {4, 2, 7, 6, 9};
        System.out.println(minCost(arr1));
        System.out.println(minCost(arr2));
    }

    public static long minCost(long[] arr) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (long val : arr) {
            minHeap.add(val);
        }

        long totalSum = 0;
        while (minHeap.size() > 1) {
            long firstMinElement = minHeap.poll();
            long secondMinElement = minHeap.poll();

            long sum = firstMinElement + secondMinElement;
            minHeap.add(sum);
            totalSum += sum;
        }
        return totalSum;
    }
}
