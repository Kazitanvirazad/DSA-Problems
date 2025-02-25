package com.geekforgeeks.problems;

/**
 * You are given a two-dimensional mat[][] of size n*m containing English alphabets and a string word.
 * Check if the word exists on the mat. The word can be constructed by using letters from adjacent cells,
 * either horizontally or vertically. The same cell cannot be used more than once.
 *
 * Examples :
 *
 * Input: mat[][] = [['T', 'E', 'E'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
 * Output: true
 * Explanation:
 *
 * The letter cells which are used to construct the "GEEK" are colored.
 * Input: mat[][] = [['T', 'E', 'U'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
 * Output: false
 * Explanation:
 *
 * It is impossible to construct the string word from the mat using each cell only once.
 * Input: mat[][] = [['A', 'B', 'A'], ['B', 'A', 'B']], word = "AB"
 * Output: true
 * Explanation:
 *
 * There are multiple ways to construct the word "AB".
 * Constraints:
 * 1 ≤ n, m ≤ 6
 * 1 ≤ L ≤ 15
 * mat and word consists of only lowercase and uppercase English letters.
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] sample1 = {
                {'T', 'E', 'E'},
                {'S', 'G', 'K'},
                {'T', 'E', 'L'}};
        char[][] sample2 = {
                {'T', 'E', 'U'},
                {'S', 'G', 'K'},
                {'T', 'E', 'L'}};
        char[][] sample3 = {
                {'A', 'B', 'A'},
                {'B', 'A', 'B'}};
        char[][] sample4 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        String word1 = "GEEK";
        String word2 = "AB";
        String word3 = "SEE";

        System.out.println(isWordExist(sample1, word1));
    }

    public static boolean isWordExist(char[][] mat, String word) {
        // if word has more character than total characters in matrix
        if (word.length() > mat.length * mat[0].length) {
            return false;
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (checkWord(mat, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkWord(char[][] matrix, int current_I_Index, int current_J_Index, String word, int currentCharIndex) {
        if (currentCharIndex + 1 >= word.length()) {
            return true;
        }
        char currentChar = word.charAt(currentCharIndex + 1);
        // setting current char to '#' to avoid read the same element again, which will increase the speed of the program
        char temp = matrix[current_I_Index][current_J_Index];
        matrix[current_I_Index][current_J_Index] = '#';
        // check vertical upper direction
        if (current_I_Index > 0) {
            if (matrix[current_I_Index - 1][current_J_Index] == currentChar) {
                if (checkWord(matrix, current_I_Index - 1, current_J_Index, word, currentCharIndex + 1)) {
                    // resetting with origin value
                    matrix[current_I_Index][current_J_Index] = temp;
                    return true;
                }
            }
        }
        // check horizontal left direction
        if (current_J_Index > 0) {
            if (matrix[current_I_Index][current_J_Index - 1] == currentChar) {
                if (checkWord(matrix, current_I_Index, current_J_Index - 1, word, currentCharIndex + 1)) {
                    // resetting with origin value
                    matrix[current_I_Index][current_J_Index] = temp;
                    return true;
                }
            }
        }
        // check horizontal right direction
        if (current_J_Index < matrix[current_I_Index].length - 1) {
            if (matrix[current_I_Index][current_J_Index + 1] == currentChar) {
                if (checkWord(matrix, current_I_Index, current_J_Index + 1, word, currentCharIndex + 1)) {
                    // resetting with origin value
                    matrix[current_I_Index][current_J_Index] = temp;
                    return true;
                }
            }
        }
        // check vertical bottom direction
        if (current_I_Index < matrix.length - 1) {
            if (matrix[current_I_Index + 1][current_J_Index] == currentChar) {
                if (checkWord(matrix, current_I_Index + 1, current_J_Index, word, currentCharIndex + 1)) {
                    // resetting with origin value
                    matrix[current_I_Index][current_J_Index] = temp;
                    return true;
                }
            }
        }
        // resetting with origin value
        matrix[current_I_Index][current_J_Index] = temp;
        return false;
    }
}
