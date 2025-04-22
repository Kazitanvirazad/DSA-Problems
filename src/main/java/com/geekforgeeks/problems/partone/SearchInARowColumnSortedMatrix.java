package com.geekforgeeks.problems.partone;

/**
 * Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in
 * increasing order and a number x, the task is to find whether element x is present in the matrix.
 *
 * Examples:
 *
 * Input: mat[][] = [[3, 30, 38],[20, 52, 54],[35, 60, 69]], x = 62
 * Output: false
 * Explanation: 62 is not present in the matrix, so output is false.
 * Input: mat[][] = [[18, 21, 27],[38, 55, 67]], x = 55
 * Output: true
 * Explanation: 55 is present in the matrix.
 * Input: mat[][] = [[1, 2, 3],[4, 5, 6],[7, 8, 9]], x = 3
 * Output: true
 * Explanation: 3 is present in the matrix.
 * Constraints:
 * 1 <= n, m <=1000
 * 1 <= mat[i][j] <= 109
 * 1<= x <= 109
 */
public class SearchInARowColumnSortedMatrix {
    public static boolean matSearch(int[][] mat, int x) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][0] > x || mat[i][mat[i].length - 1] < x) {
                continue;
            }
            if (binarySearch(mat[i], 0, mat[i].length - 1, x)) {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int lowIndex, int highIndex, int element) {
        if (lowIndex > highIndex) {
            return false;
        } else {
            int mid = (lowIndex + highIndex) / 2;
            if (arr[mid] == element) {
                return true;
            }
            if (arr[mid] > element) {
                return binarySearch(arr, lowIndex, mid - 1, element);
            } else {
                return binarySearch(arr, mid + 1, highIndex, element);
            }
        }
    }
}
