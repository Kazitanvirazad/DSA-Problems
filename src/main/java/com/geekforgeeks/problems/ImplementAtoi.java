package com.geekforgeeks.problems;

/**
 * Given a string s, the objective is to convert it into integer format without utilizing any built-in functions.
 * If the conversion is not feasible, the function should return -1.
 *
 * Note: Conversion is feasible only if all characters in the string are numeric or if its first character is '-'
 * or '+' and rest are numeric.
 *
 * Examples:
 *
 * Input: s = "-123"
 * Output: -123
 * Explanation: It is possible to convert -123 into an integer so we returned in the form of an integer
 * Input: s = "21a"
 * Output: -1
 * Explanation: The output is -1 as, due to the inclusion of 'a', the given string cannot be converted to an integer.
 *
 * Expected Time Complexity: O( |s| ),
 * Expected Auxiliary Space: O(1)
 */
public class ImplementAtoi {
    public int atoi(char[] s) {
        if (s[0] == '+') {
            return -1;
        }

        boolean isNegative = s[0] == '-';

        int index = isNegative ? 1 : 0;

        int res = 0;

        while (index < s.length) {
            if (!isDigit(s[index])) {
                return -1;
            }
            int digit = s[index] - '0';
            res = (res * 10) + digit;
            index++;
        }

        return isNegative ? res * -1 : res;
    }

    private boolean isDigit(char character) {
        int ascii = (int) character;
        return ascii > 47 && ascii < 58;
    }

    public int atoi(String s) {
        boolean isNegative = false;
        boolean hasNegOrPosCharOccurred = false;

        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int currentCharNumber = currentChar - '0';
            if (currentCharNumber >= 0 && currentCharNumber <= 9) {
                if (number * 10 + currentCharNumber < 0) {
                    number = Integer.MAX_VALUE;
                    break;
                }
                number = number * 10 + currentCharNumber;
            } else {
                if (currentChar == ' ') {
                    continue;
                }
                if ((currentChar == '-' || currentChar == '+') && number != 0) {
                    break;
                }
                if (currentChar == '-') {
                    if (hasNegOrPosCharOccurred) {
                        break;
                    }
                    hasNegOrPosCharOccurred = true;
                    isNegative = true;
                    continue;
                }
                if (currentChar == '+') {
                    if (hasNegOrPosCharOccurred) {
                        break;
                    }
                    hasNegOrPosCharOccurred = true;
                    isNegative = false;
                    continue;
                }
                if (currentChar > 57 || currentChar < 48) {
                    break;
                }
            }
        }

        if (number == Integer.MAX_VALUE) {
            return isNegative ? Integer.MIN_VALUE : number;
        } else {
            return isNegative && number > 0 ? number * -1 : number;
        }
    }
}
