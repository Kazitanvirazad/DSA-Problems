package com.geekforgeeks.problems;

/**
 * Given a string str consisting of opening and closing parenthesis '(' and ')'. Find length of the longest
 * valid parenthesis substring.
 * <p>
 * A parenthesis string is valid if:
 * <p>
 * *For every opening parenthesis, there is a closing parenthesis.
 * <p>
 * *Opening parenthesis must be closed in the correct order.
 * <p>
 * Examples :
 * <p>
 * Input: str = ((()
 * <p>
 * Output: 2
 * <p>
 * Explaination: The longest valid parenthesis substring is "()".
 * <p>
 * Input: str = )()())
 * <p>
 * Output: 4
 * <p>
 * Explaination: The longest valid parenthesis substring is "()()".
 * <p>
 * Expected Time Complexity: O(|str|)
 * <p>
 * Expected Auxiliary Space: O(|str|)
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(maxLength("()()))())))))(())())))()))))()((()(((((((()(()()))()(()())))((()((((((()))))()(())(((((())((((((((()))((())()(()())()(()(()(()))))))))))))))()()((()((())))())()(())(()(()(()(()))))(()()((()(((()())))(()()())((())((((()()()()())()()()()))))(()()(()()((()(()))))))(())()(()))((())(()()()((())((((((()()))(()()()(()((())()()((((((())(((((())(((())))((((()()))()(())(())()))(()(())(((()(()())())(()())()((()()(()(()()()())((((()((()(()(((((())((()(((())(()()(())))))))))(()())((())()((()()()()()))))(((()))(()()())(()))()()))()))))()))))((())((())((()((())()))(()()))))(()))()))()()))))()(())()((())(()())()()()()()))()))()((((((()))))()())))))(()()(()())()((()(((()()))((()((()()(()()()()((())(())(()))())((()())))))())())()()(()())((())(((())(())(((()())()()(()(((())())()()(((()(()))())()()()((())((()()((((((((()()((()(((())()())))()()(()((()(())))))()((()))(()((()(())((()(())(((((("));
        System.out.println(maxLength("((()"));
    }

    static final char OPENING_PARENTHESES = '(';
    static final char CLOSING_PARENTHESES = ')';

    public static int maxLength(String S) {
        if (S.length() == 1) {
            return 0;
        }

        char[] characters = S.toCharArray();
        int openingCounter = 0;
        int closingCounter = 0;
        int validLength = 0;

        // left to right traversal
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == OPENING_PARENTHESES) {
                openingCounter++;
            }
            if (characters[i] == CLOSING_PARENTHESES) {
                closingCounter++;
            }
            if (closingCounter == openingCounter) {
                validLength = Math.max(validLength, openingCounter * 2);
            }
            if (closingCounter > openingCounter) {
                closingCounter = 0;
                openingCounter = 0;
            }
        }
        closingCounter = 0;
        openingCounter = 0;
        // right to left traversal
        for (int i = characters.length - 1; i >= 0; i--) {
            if (characters[i] == OPENING_PARENTHESES) {
                openingCounter++;
            }
            if (characters[i] == CLOSING_PARENTHESES) {
                closingCounter++;
            }
            if (closingCounter == openingCounter) {
                validLength = Math.max(validLength, openingCounter * 2);
            }
            if (openingCounter > closingCounter) {
                closingCounter = 0;
                openingCounter = 0;
            }
        }
        return validLength;
    }
}
