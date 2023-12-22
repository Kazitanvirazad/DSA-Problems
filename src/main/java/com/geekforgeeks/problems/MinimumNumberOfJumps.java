package com.geekforgeeks.problems;

/**
 * Given an array of N integers arr[] where each element represents the maximum
 * length of the jump that can be made forward from that element. This means if
 * arr[i] = x, then we can jump any distance y such that y ≤ x. Find the minimum
 * number of jumps to reach the end of the array (starting from the first
 * element). If an element is 0, then you cannot move through that element.
 * 
 * Note: Return -1 if you can't reach the end of the array.
 * 
 * 
 * Example 1:
 * 
 * Input: N = 11 arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} Output: 3
 * Explanation: First jump from 1st element to 2nd element with value 3. Now,
 * from here we jump to 5th element with value 9, and from here we will jump to
 * the last. Example 2:
 * 
 * Input : N = 6 arr = {1, 4, 3, 2, 6, 7} Output: 2 Explanation: First we jump
 * from the 1st to 2nd element and then jump to the last element.
 * 
 * Your task: You don't need to read input or print anything. Your task is to
 * complete function minJumps() which takes the array arr and it's size N as
 * input parameters and returns the minimum number of jumps. If not possible
 * return -1.
 * 
 * 
 * Expected Time Complexity: O(N) Expected Space Complexity: O(1)
 * 
 * 
 * Constraints: 1 ≤ N ≤ 107 0 ≤ arri ≤ 107
 *
 */
public class MinimumNumberOfJumps {

	public static void main(String[] args) {

		//Unfinished 
		
//		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
//		int arr[] = { 2, 3, 1, 1, 4 };
//		int arr[] = { 2, 3, 1, 7, 4 };
//		int[] arr = { 1, 4, 3, 2, 6, 7 };
//		int arr[] = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };
//		int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
//		int arr[] = { 70, 40, 9, 19, 94, 84, 15, 87, 71, 45, 87, 85, 5, 53, 13, 43, 10, 50, 94, 91, 38, 63, 98, 33, 99,
//				91, 86, 66, 43, 80, 35, 79, 20, 10, 98, 80, 61, 13, 66, 31, 24, 18, 82, 97, 72, 61, 39, 48, 11, 99, 38,
//				49, 27, 2, 49, 26, 59, 0, 58, 1, 81, 59, 80, 67, 70, 77, 46, 97, 56, 79, 27, 81, 63, 75, 77, 0 };
//		int arr[] = { 9, 10, 1, 2, 3, 4, 8, 0, 0, 0, 0, 0, 0, 0, 1 };
//		int arr[] = { 2, 63, 81, 78, 91, 64, 91, 2, 70, 97, 73, 64, 97, 39, 21 };
//		int arr[] = { 1, 3, 7, 1, 6, 1, 1, 1, 1, 1, 9 };
		int arr[] = { 2, 1, 0, 3 };
		System.out.println(minJumps(arr));
	}

	public static int minJumps(int[] arr) {
		if (arr[0] == 0)
			return -1;

		int jumpCount = 1, maxReach = arr[0], moves = arr[0];

		for (int i = 1; i < arr.length - 1; i++) {
			if (i == arr.length - 1) {
				break;
			}

			maxReach = Math.max(maxReach, arr[i] + i);
			moves--;
			if (moves == 0) {
				jumpCount++;
				moves = maxReach - i;
			}
		}

		return jumpCount;
	}

//	public static int minJumps(int[] arr) {
//		int jumpCount = 0;
//
//		if (arr[0] == 0)
//			return -1;
//
//		int index = 0;
//		int largestPositionedElement = -1;
//		int largestPositionedIndex = -1;
//		boolean jumped = false;
//		while (index < arr.length) {
//			jumped = false;
//			if (arr[index] == 0) {
//				return -1;
//			}
//
//			largestPositionedElement = -1;
//			largestPositionedIndex = -1;
//
//			for (int i = arr[index]; i > 0; i--) {
//				if (index + i == arr.length - 1) {
//					largestPositionedIndex = index + i;
//					jumped = true;
//					break;
//				}
//				if (i + (index + 1) > arr.length || arr[index + i] == 0) {
//					continue;
//				}
//
//				largestPositionedElement = Math.max(largestPositionedIndex, arr[index + i]);
//				largestPositionedIndex = index + i;
//				jumped = true;
////				if (largestPositionedElement < arr[index + i]) {
////					if (arr[index + i] + index >= arr.length || arr[arr[index + i] + index] != 0) {
////						largestPositionedElement = arr[index + i];
////						largestPositionedIndex = index + i;
////						jumped = true;
////					}
////				}
//
//			}
//
//			if (jumped) {
//				index = largestPositionedIndex;
//				jumpCount++;
//			}
//
//			if (index == arr.length - 1) {
//				break;
//			}
//
//			if (!jumped)
//				index++;
//		}
//
//		return jumpCount;
//	}

}
