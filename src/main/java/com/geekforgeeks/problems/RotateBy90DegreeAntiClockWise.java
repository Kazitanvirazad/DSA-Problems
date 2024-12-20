package com.geekforgeeks.problems;

/**
 * Given a square matrix mat[][] of size n x n. The task is to rotate it by
 *  90 degrees in an anti-clockwise direction without using any extra space. 

Examples:

Input: mat[][] = [[1, 2, 3],
                [4, 5, 6]
                [7, 8, 9]]
Output: Rotated Matrix:
[3, 6, 9]
[2, 5, 8]
[1, 4, 7]
Input: mat[][] = [[1, 2],
                [3, 4]]
Output: Rotated Matrix:
[2, 4]
[1, 3]
Constraints:
1 ≤ n ≤ 102
0 <= mat[i][j] <= 103
 */
public class RotateBy90DegreeAntiClockWise {
  public static void rotateby90(int[][] mat) {
    // swap rows with columns
    int i = 0;
    while (i < mat.length) {
      int j = i;
      while (j < mat[i].length) {
        int row = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = row;
        j++;
      }
      i++;
    }

    // reverse the array
    int startIndex = 0, endIndex = mat.length - 1;
    while (startIndex < endIndex) {
      int[] temp = mat[startIndex];
      mat[startIndex] = mat[endIndex];
      mat[endIndex] = temp;
      startIndex++;
      endIndex--;
    }
  }
}
