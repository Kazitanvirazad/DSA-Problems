package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
        queens.solveNQueens(4);
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
        private Integer[][] chessBoard;
        private Set<Integer[][]> usedChessBoard;

        public NQueensProblem(int numOfQueens) {
            this.numOfQueens = numOfQueens;
            this.chessBoard = new Integer[numOfQueens][numOfQueens];
            resetChessBoard();
            this.usedChessBoard = new HashSet<>();
        }

        private void resetChessBoard() {
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    chessBoard[i][j] = 0;
                }
            }
        }

        public List<String> solve() {
            List<String> queens = new ArrayList<>();
            if (setQueen(0)) {
                addQueens(queens);
            }
            return queens;
        }

        private boolean setQueen(int colIndex) {
            if (colIndex == numOfQueens) {
                return !isBoardAlreadyUsed();
            }
            for (int rowIndex = 0; rowIndex < chessBoard.length; rowIndex++) {
                if (isPlaceValid(colIndex, rowIndex)) {
                    chessBoard[rowIndex][colIndex] = 1;
                    if (setQueen(colIndex + 1)) {
                        return true;
                    } else {
                        chessBoard[rowIndex][colIndex] = 0;
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

        private boolean isBoardAlreadyUsed() {
            Iterator<Integer[][]> usedChessBoardIterator = usedChessBoard.iterator();
            while (usedChessBoardIterator.hasNext()) {
                Integer[][] usedBoard = usedChessBoardIterator.next();
                if (isChessBoardUsed(usedBoard)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isChessBoardUsed(Integer[][] used) {
            boolean isChessBoardUsed = true;
            for (int i = 0; i < chessBoard.length && isChessBoardUsed; i++) {
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if (used[i][j] != chessBoard[i][j]) {
                        isChessBoardUsed = false;
                        break;
                    }
                }
            }
            return isChessBoardUsed;
        }

        private void addQueens(List<String> queens) {
            for (int i = 0; i < chessBoard.length; i++) {
                String queen = "";
                for (int j = 0; j < chessBoard[i].length; j++) {
                    if (chessBoard[i][j] == 1) {
                        queen += "Q";
                    } else if (chessBoard[i][j] == 0 || chessBoard[i][j] == null) {
                        queen += ".";
                    }
                }
                queens.add(queen);
            }
            shallowCopyChessBoard(chessBoard);
            resetChessBoard();
        }

        private void shallowCopyChessBoard(Integer[][] board) {
            Integer[][] newBoard = new Integer[board.length][board.length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    newBoard[i][j] = board[i][j];
                }
            }
            usedChessBoard.add(newBoard);
        }
    }
}
