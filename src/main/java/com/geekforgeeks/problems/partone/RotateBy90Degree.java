package com.geekforgeeks.problems.partone;

/**
 * Given a square mat[][]. The task is to rotate it by 90 degrees in clockwise direction without
 * using any extra space.
 *
 * Examples:
 *
 * Input: mat[][] = [[1 2 3], [4 5 6], [7 8 9]]
 * Output:
 * 7 4 1
 * 8 5 2
 * 9 6 3
 * Input: mat[][] = [1 2], [3 4]
 * Output:
 * 3 1
 * 4 2
 * Input: mat[][] = [[1]]
 * Output:
 * 1
 */
public class RotateBy90Degree {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2 = {{1, 2}, {3, 4}};
        int[][] arr3 = {{1}};
        printMatrix(arr1);
        rotate(arr1);
        printMatrix(arr1);

        printMatrix(arr2);
        rotate(arr2);
        printMatrix(arr2);

        printMatrix(arr3);
        rotate(arr3);
        printMatrix(arr3);
    }

    public static void rotate(int[][] mat) {
        // swap rows with columns
        int baseIndex = 0;
        while (baseIndex < mat.length) {
            int pointerIndex = baseIndex;
            while (pointerIndex < mat.length) {
                int temp = mat[baseIndex][pointerIndex];
                mat[baseIndex][pointerIndex] = mat[pointerIndex][baseIndex];
                mat[pointerIndex][baseIndex] = temp;
                pointerIndex++;
            }
            baseIndex++;
        }

        // reverse the rows
        for (int i = 0; i < mat.length; i++) {
            int rowStart = 0;
            int rowEnd = mat[i].length - 1;
            while (rowStart < rowEnd) {
                int temp = mat[i][rowStart];
                mat[i][rowStart] = mat[i][rowEnd];
                mat[i][rowEnd] = temp;
                rowStart++;
                rowEnd--;
            }
        }
    }

    private static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
