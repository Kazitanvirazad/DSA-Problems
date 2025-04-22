package com.geekforgeeks.problems.partone;

import java.util.Iterator;
import java.util.Stack;

/**
 * You are given N operations and your task is to Implement a Stack in which you can get a minimum element in O(1) time.
 *
 * Example 1:
 *
 * Input:
 * push(2)
 * push(3)
 * pop()
 * getMin()
 * push(1)
 * getMin()
 * Output: 2 1
 * Explanation: In the first test case for
 * query
 * push(2)  Insert 2 into the stack.
 *          The stack will be {2}
 * push(3)  Insert 3 into the stack.
 *          The stack will be {2 3}
 * pop()    Remove top element from stack
 *          Poped element will be 3 the
 *          stack will be {2}
 * getMin() Return the minimum element
 *          min element will be 2
 * push(1)  Insert 1 into the stack.
 *          The stack will be {2 1}
 * getMin() Return the minimum element
 *          min element will be 1
 * Your Task:
 * You are required to complete the three methods push() which takes one argument an integer 'x' to be pushed into the
 * stack, pop() which returns an integer popped out from the stack, and getMin() which returns the min element
 * from the stack. (-1 will be returned if for pop() and getMin() the stack is empty.)
 *
 * Expected Time Complexity: O(1) for all the 3 methods.
 * Expected Auxiliary Space: O(1) for all the 3 methods.
 */
public class GetMinimumElementFromStack {
    int minEle;
    Stack<Integer> s;

    public GetMinimumElementFromStack() {
        s = new Stack<>();
        minEle = Integer.MAX_VALUE;
    }

    /*returns min element from stack*/
    public int getMin() {
        return minEle == Integer.MAX_VALUE ? -1 : minEle;
    }

    /*returns poped element from stack*/
    public int pop() {
        if (s.empty()) {
            return -1;
        }
        int popped = s.pop();
        if (popped == minEle) {
            int min = Integer.MAX_VALUE;
            Iterator<Integer> iterator = s.iterator();
            while (iterator.hasNext()) {
                int val = iterator.next();
                if (val < min) {
                    min = val;
                }
            }
            minEle = min;
        }
        return popped;
    }

    /*push element x into the stack*/
    public void push(int x) {
        if (x < minEle) {
            minEle = x;
        }
        s.add(x);
    }
}

class Solution {
    private int[] stack;
    private int top = -1;
    private int minValue = Integer.MAX_VALUE;

    public Solution() {
        this.stack = new int[100000];
    }

    // Add an element to the top of Stack
    public void push(int x) {
        if (top < 0) {
            minValue = Integer.MAX_VALUE;
        }
        stack[++top] = x;
        minValue = Math.min(x, minValue);
    }

    // Remove the top element from the Stack
    public void pop() {
        if (top > -1) {
            int elementToPop = stack[top];
            top--;
            minValue = Integer.MAX_VALUE;
            for (int i = 0; i <= top; i++) {
                minValue = Math.min(stack[i], minValue);
            }
        }
    }

    // Returns top element of the Stack
    public int peek() {
        if (top > -1) {
            return stack[top];
        }
        return -1;
    }

    // Finds minimum element of Stack
    public int getMin() {
        if (top < 0) {
            return -1;
        }
        return minValue;
    }
}