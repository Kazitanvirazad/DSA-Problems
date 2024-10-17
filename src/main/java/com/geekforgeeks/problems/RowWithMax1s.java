package com.geekforgeeks.problems;

/**
 * You are given a 2D array consisting of only 1's and 0's, where each row is sorted in non-decreasing order.
 * You need to find and return the index of the first row that has the most number of 1s. If no such row exists,
 * return -1.
 * Note: 0-based indexing is followed.
 *
 * Examples:
 *
 * Input: arr[][] = [[0, 1, 1, 1],
 *                [0, 0, 1, 1],
 *                [1, 1, 1, 1],
 *                [0, 0, 0, 0]]
 * Output: 2
 * Explanation: Row 2 contains 4 1's.
 * Input: arr[][] = [[0, 0],
 *                [1, 1]]
 * Output: 1
 * Explanation: Row 1 contains 2 1's.
 * Expected Time Complexity: O(n+m)
 * Expected Auxiliary Space: O(1)
 *
 * Note : Here n,m refers to the number of rows and columns respectively.
 */
public class RowWithMax1s {
    public static void main(String[] args) {
        RowWithMax1s row = new RowWithMax1s();
        int[][] arr = {{0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};
        int[][] arr1 = {{0, 0}, {1, 1}};
        System.out.println(row.rowWithMax1s(arr1));
    }

    public int rowWithMax1s(int[][] arr) {
        int maxCount = -1;
        int resRow = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][arr[i].length - 1] == 0) {
                continue;
            }
            int startIndex = 0;
            int endIndex = arr[i].length - 1;

            int resCount = -1;
            while (startIndex < arr[i].length || endIndex > -1) {
                if (arr[i][startIndex] != 0) {
                    resCount = arr[i].length - startIndex;
                    break;
                }

                if (arr[i][endIndex] != 1) {
                    resCount = arr[i].length - 1 - endIndex;
                    break;
                }
                startIndex++;
                endIndex--;
            }
            if (resCount > maxCount) {
                maxCount = resCount;
                resRow = i;
            }
        }
        return resRow;
    }
}
