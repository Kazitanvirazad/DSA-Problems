package com.geekforgeeks.problems.partone;

import java.util.ArrayList;

/**
 * You are given a rectangular matrix mat[][] of size n x m, and your task is to return an array while
 * traversing the matrix in spiral form.
 *
 * Examples:
 *
 * Input: mat[][] = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
 * Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
 * Explanation:
 *
 * Input: mat[][] = [[1, 2, 3, 4, 5, 6], [7, 8, 9, 10, 11, 12], [13, 14, 15, 16, 17, 18]]
 * Output: [1, 2, 3, 4, 5, 6, 12, 18, 17, 16, 15, 14, 13, 7, 8, 9, 10, 11]
 * Explanation: Applying same technique as shown above.
 * Input: mat[][] = [[32, 44, 27, 23], [54, 28, 50, 62]]
 * Output: [32, 44, 27, 23, 62, 50, 28, 54]
 * Explanation: Applying same technique as shown above, output will be [32, 44, 27, 23, 62, 50, 28, 54].
 * Constraints:
 * 1 <= n, m <= 1000
 * 0 <= mat[i][j]<= 100
 */
public class SpirallyTraversingAMatrix {
    public static void main(String[] args) {
        SpirallyTraversingAMatrix spirallyTraversingAMatrix = new SpirallyTraversingAMatrix();
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix2 = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}};
        int[][] matrix3 = {{32, 44, 27, 23}, {54, 28, 50, 62}};
        spirallyTraversingAMatrix.spirallyTraverse(matrix3).forEach(element -> System.out.print(element + " "));
    }

    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0;
        int right = mat[0].length - 1;
        int top = 0;
        int bottom = mat.length - 1;

        while (bottom >= top && left <= right) {
            int tempLeft = left;
            while (tempLeft <= right) {
                res.add(mat[top][tempLeft++]);
            }
            top++;
            int tempTop = top;
            while (tempTop <= bottom) {
                res.add(mat[tempTop++][right]);
            }
            right--;
            if (bottom >= top) {
                int tempRight = right;
                while (tempRight >= left) {
                    res.add(mat[bottom][tempRight--]);
                }
                bottom--;
            }
            if (left <= right) {
                int tempBottom = bottom;
                while (tempBottom >= top) {
                    res.add(mat[tempBottom--][left]);
                }
                left++;
            }
        }
        return res;
    }
}
