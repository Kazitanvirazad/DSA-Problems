package com.geekforgeeks.problems.partone;

/**
 * 
 * Given a string S, check if it is palindrome or not.
 * 
 * Example 1:
 * 
 * Input: S = "abba" Output: 1 Explanation: S is a palindrome Example 2:
 * 
 * Input: S = "abc" Output: 0 Explanation: S is not a palindrome Your Task: You
 * don't need to read input or print anything. Complete the function
 * isPalindrome()which accepts string S and returns an integer value 1 or 0.
 * 
 * Expected Time Complexity: O(Length of S) Expected Auxiliary Space: O(1)
 * 
 * Constraints: 1 <= Length of S<= 2*105
 *
 */
public class PalindromeString {

	public static void main(String[] args) {

//		String S = "kazi";
		String S = "abba";
		System.out.println(isPalindrome(S));

	}

	public static int isPalindrome(String S) {

		int forwardLength = 0;
		int backwardIndex = S.length() - 1;

		while (backwardIndex >= 0 && forwardLength < S.length()) {
			if (S.charAt(backwardIndex) != S.charAt(forwardLength)) {
				return 0;
			}
			backwardIndex--;
			forwardLength++;
		}

		return 1;
	}

}
