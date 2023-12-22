package com.geekforgeeks.problems;

/**
 * Consider a sample space S consisting of all perfect squares starting from 1,
 * 4, 9 and so on. You are given a number N, you have to output the number of
 * integers less than N in the sample space S.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input : N = 9 Output: 2 Explanation: 1 and 4 are the only Perfect Squares
 * less than 9. So, the Output is 2. Example 2:
 * 
 * Input : N = 3 Output: 1 Explanation: 1 is the only Perfect Square less than
 * 3. So, the Output is 1.
 * 
 * 
 * Your Task: You don't need to read input or print anything. Your task is to
 * complete the function countSquares() which takes an Integer N as input and
 * returns the answer.
 * 
 * 
 * 
 * Expected Time Complexity: O(sqrt(N)) Expected Auxiliary Space: O(1)
 *
 */
public class CountSquares {
	public static void main(String[] args) {
		int n = 9;
		int res = countSquares(n);
		System.out.println(res);
	}

	public static int countSquares(int N) {
		int count = 0;
		int currentPerfectSquareNumber = 1;
		int lastPerfectSquareNumber = 1;
		while (true) {
			if (N <= 1) {
				break;
			}
			if (currentPerfectSquareNumber >= N) {
				break;
			}
			if (currentPerfectSquareNumber == 1) {
				lastPerfectSquareNumber = currentPerfectSquareNumber;
				currentPerfectSquareNumber = 4;
				count++;
				continue;
			}
			int nextPerfectSquareNumber = currentPerfectSquareNumber
					+ ((currentPerfectSquareNumber - lastPerfectSquareNumber) + 2);
			if (currentPerfectSquareNumber < N) {
				count++;
			}
			if (nextPerfectSquareNumber >= N) {
				break;
			}
			lastPerfectSquareNumber = currentPerfectSquareNumber;
			currentPerfectSquareNumber = nextPerfectSquareNumber;
		}

		return count;

	}
}
