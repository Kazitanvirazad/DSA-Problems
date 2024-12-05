package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens
 * attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer
 * in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * Example 2:
 *
 * Input: n = 1
 * Output: [["Q"]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 */
public class NQueens {
    public static void main(String[] args) {
        NQueens queens = new NQueens();
        System.out.println(queens.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        NQueensProblem queensProblem = new NQueensProblem(n);
        while (true) {
            List<String> temp = queensProblem.solve();
            if (temp.isEmpty()) {
                break;
            }
            res.add(temp);
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

        public List<String> solve() {
            List<String> queens = new ArrayList<>();
            ColumnRowStore columnRowStore = new ColumnRowStore();
            if (setQueen(0, columnRowStore)) {
                columnRowStores.add(columnRowStore);
                addQueens(queens);
            }
            return queens;
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

        private void addQueens(List<String> queens) {
            for (int i = 0; i < chessBoard.length; i++) {
                String queen = "";
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if (chessBoard[i][j] == 1) {
                        queen += "Q";
                    } else if (chessBoard[i][j] == 0) {
                        queen += ".";
                    }
                }
                queens.add(queen);
            }
            this.chessBoard = new int[numOfQueens][numOfQueens];
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
