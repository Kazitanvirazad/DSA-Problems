package com.leetcode.problems;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens
 * attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 */
public class NQueens2 {
    public int totalNQueens(int n) {
        int res = 0;
        NQueensProblem queensProblem = new NQueensProblem(n);
        while (true) {
            if (queensProblem.solve()) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    private class NQueensProblem {
        private int numOfQueens;
        private int[][] chessBoard;
        private Set<ColumnRowStore> columnRowStores;

        public NQueensProblem(int numOfQueens) {
            this.numOfQueens = numOfQueens;
            this.chessBoard = new int[numOfQueens][numOfQueens];
            this.columnRowStores = new HashSet<>();
        }

        public boolean solve() {
            ColumnRowStore columnRowStore = new ColumnRowStore();
            if (setQueen(0, columnRowStore)) {
                columnRowStores.add(columnRowStore);
                this.chessBoard = new int[numOfQueens][numOfQueens];
                return true;
            }
            return false;
        }

        private boolean setQueen(int colIndex, ColumnRowStore columnRowStore) {
            if (colIndex == numOfQueens) {
                return !isBoardAlreadyUsed(columnRowStore);
            }
            for (int rowIndex = 0; rowIndex < chessBoard.length; rowIndex++) {
                if (isPlaceValid(colIndex, rowIndex)) {
                    chessBoard[rowIndex][colIndex] = 1;
                    columnRowStore.addCol(colIndex);
                    columnRowStore.addRow(rowIndex);
                    if (setQueen(colIndex + 1, columnRowStore)) {
                        return true;
                    } else {
                        chessBoard[rowIndex][colIndex] = 0;
                        columnRowStore.subtractCol();
                        columnRowStore.subtractRow();
                    }
                }
            }
            return false;
        }

        private boolean isPlaceValid(int colIndex, int rowIndex) {
            for (int i = 0; i < colIndex; i++) {
                if (chessBoard[rowIndex][i] == 1) {
                    return false;
                }
            }
            for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--) {
                if (chessBoard[i][j] == 1) {
                    return false;
                }
            }
            for (int i = rowIndex + 1, j = colIndex - 1; i < chessBoard.length && j >= 0; i++, j--) {
                if (chessBoard[i][j] == 1) {
                    return false;
                }
            }
            return true;
        }

        private boolean isBoardAlreadyUsed(ColumnRowStore columnRowStore) {
            return columnRowStores.contains(columnRowStore);
        }

        class ColumnRowStore {
            int colSum;
            int rowSum;

            public ColumnRowStore() {
                this.colSum = 0;
                this.rowSum = 0;
            }

            void addCol(int col) {
                colSum = colSum * 10 + col;
            }

            void addRow(int row) {
                rowSum = rowSum * 10 + row;
            }

            void subtractCol() {
                colSum /= 10;
            }

            void subtractRow() {
                rowSum /= 10;
            }

            @Override
            public boolean equals(Object obj) {
                return obj instanceof ColumnRowStore && (obj == this ||
                        (((ColumnRowStore) obj).colSum == this.colSum &&
                                ((ColumnRowStore) obj).rowSum == this.rowSum));
            }

            @Override
            public int hashCode() {
                return Objects.hash(this.colSum, this.rowSum);
            }
        }
    }
}
