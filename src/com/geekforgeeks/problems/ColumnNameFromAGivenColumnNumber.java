package com.geekforgeeks.problems;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet. Excel columns has a pattern like A, B, C, … ,Z, AA, AB, AC,….
 * ,AZ, BA, BB, … ZZ, AAA, AAB ….. etc. In other words, column 1 is named as
 * “A”, column 2 as “B”, column 27 as “AA” and so on.
 * 
 * Example 1:
 * 
 * Input: N = 28 Output: AB Explanation: 1 to 26 are A to Z. Then, 27 is AA and
 * 28 = AB.
 * 
 * Example 2:
 * 
 * Input: N = 13 Output: M Explanation: M is the 13th character of alphabet.
 * Your Task: You don't need to read input or print anything. Your task is to
 * complete the function colName() which takes the column number N as input and
 * returns the column name represented as a string. Expected Time Complexity:
 * O(LogN). Expected Auxiliary Space: O(1).
 * 
 * Constraints: 1 <= N <= 1018
 */
public class ColumnNameFromAGivenColumnNumber {

	public static void main(String[] args) {
		long N = 28; // AB
//		long N = 13;	//M
		System.out.println(colName(N));
	}

	public static String colName(long n) {
		String[] alphabets = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };

		String res = "";

		if (n <= alphabets.length) {
			return alphabets[(int) n];
		} else {
			int columnCount = (int) (Math.log(n) / Math.log(26));
			int lastCol = (int) (n - Math.pow(26, columnCount));
			for (int i = 0; i < columnCount; i++) {
				res += alphabets[26 - columnCount + i];
			}
			res += alphabets[26 - lastCol];
//			long remainder = (n % alphabets.length);

//			if (n % alphabets.length == 0) {
//				res += colName(n % alphabets.length);
//			} else {
//				res += colName(columnCount);
//			}
			return res;
		}
	}

	public static String getColumnName(long n) {
		// initialize output string as empty
		StringBuilder result = new StringBuilder();

		while (n > 0) {
			// find the index of the next letter and concatenate the letter
			// to the solution

			// here index 0 corresponds to 'A', and 25 corresponds to 'Z'
			long index = (n - 1) % 26;
			result.append((char) (index + 'A'));
			n = (n - 1) / 26;
		}

		return result.reverse().toString();
	}
}
