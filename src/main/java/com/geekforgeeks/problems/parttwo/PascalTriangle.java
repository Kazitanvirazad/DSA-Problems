package com.geekforgeeks.problems.parttwo;

import java.util.ArrayList;

/**
 * Given a positive integer n, return the nth row of pascal's triangle.
 * Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.
 *
 * File:PascalTriangleAnimated2.gif
 *
 * Examples:
 *
 * Input: n = 4
 * Output: [1, 3, 3, 1]
 * Explanation: 4th row of pascal's triangle is [1, 3, 3, 1].
 * Input: n = 5
 * Output: [1, 4, 6, 4, 1]
 * Explanation: 5th row of pascal's triangle is [1, 4, 6, 4, 1].
 * Input: n = 1
 * Output: [1]
 * Explanation: 1st row of pascal's triangle is [1].
 * Constraints:
 * 1 ≤ n ≤ 20
 */
public class PascalTriangle {
    public ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int prev = 1;
        n--;
        res.add(prev);

        for (int i = 1; i <= n; i++) {
            int current = (prev * (n - i + 1)) / i;
            res.add(current);
            prev = current;
        }
        return res;
    }
}
