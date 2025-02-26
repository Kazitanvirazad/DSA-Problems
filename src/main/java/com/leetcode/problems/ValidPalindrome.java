package com.leetcode.problems;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
 * all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include
 * letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome palindrome = new ValidPalindrome();
        String sample1 = "A man, a plan, a canal: Panama";
        String sample2 = "race a car";
        String sample3 = " ";
        String sample4 = "ab2a";
        System.out.println(palindrome.isPalindrome(sample4));
    }

    public boolean isPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;

        while (leftPointer <= rightPointer) {
            char leftChar = Character.toLowerCase(s.charAt(leftPointer));
            char rightChar = Character.toLowerCase(s.charAt(rightPointer));

            // skipping non-alphanumeric characters from left side
            while (leftPointer < rightPointer &&
                    !((int) leftChar >= 48 &&
                            leftChar <= 57)
                    &&
                    !((int) leftChar >= 97 &&
                            leftChar <= 122)) {
                leftPointer++;
                leftChar = Character.toLowerCase(s.charAt(leftPointer));
            }
            // skipping non-alphanumeric characters from right side
            while (leftPointer < rightPointer &&
                    !((int) rightChar >= 48 &&
                            rightChar <= 57)
                    &&
                    !((int) rightChar >= 97 &&
                            (int) rightChar <= 122)) {
                rightPointer--;
                rightChar = Character.toLowerCase(s.charAt(rightPointer));
            }

            if (leftChar == rightChar) {
                leftPointer++;
                rightPointer--;
            } else {
                return false;
            }
        }
        return true;
    }
}
