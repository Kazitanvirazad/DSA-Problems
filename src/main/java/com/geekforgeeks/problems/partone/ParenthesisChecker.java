package com.geekforgeeks.problems.partone;

/**
 * Given an expression string x. Examine whether the pairs and the orders of
 * {,},(,),[,] are correct in exp. For example, the function should return
 * 'true' for exp = [()]{}{[()()]()} and 'false' for exp = [(]).
 * 
 * Note: The drive code prints "balanced" if function return true, otherwise it
 * prints "not balanced".
 * 
 * Example 1:
 * 
 * Input: {([])} Output: true Explanation: { ( [ ] ) }. Same colored brackets
 * can form balanced pairs, with 0 number of unbalanced bracket. Example 2:
 * 
 * Input: () Output: true Explanation: (). Same bracket can form balanced pairs,
 * and here only 1 type of bracket is present and in balanced way. Example 3:
 * 
 * Input: ([] Output: false Explanation: ([]. Here square bracket is balanced
 * but the small bracket is not balanced and Hence , the output will be
 * unbalanced. Your Task: This is a function problem. You only need to complete
 * the function ispar() that takes a string as a parameter and returns a boolean
 * value true if brackets are balanced else returns false. The printing is done
 * automatically by the driver code.
 * 
 * Expected Time Complexity: O(|x|) Expected Auixilliary Space: O(|x|)
 * 
 * Constraints: 1 ≤ |x| ≤ 32000
 */
public class ParenthesisChecker {

	public static void main(String[] args) {
		String x = "[()]{}{[()()]()}";
//		String x = "[(])";
//		String x = "{([])}";
//		String x = "()";
//		String x = "([]){";
		System.out.println(ispar(x));
	}

	public static boolean ispar(String x) {
		return checkParenthesis(x);
	}

	public static boolean checkParenthesis(String str) {
		int i = -1;
		char[] stack = new char[str.length()];

		for (char ch : str.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				stack[++i] = ch;
			} else {
				if (i >= 0 && ((stack[i] == '(' && ch == ')') || (stack[i] == '{' && ch == '}')
						|| (stack[i] == '[' && ch == ']'))) {
					i--;
				} else {
					return false;
				}
			}
		}
		return i == -1;
	}

}
