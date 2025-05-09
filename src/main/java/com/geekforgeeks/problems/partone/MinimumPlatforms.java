package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given arrival and departure times of all trains that reach a railway station.
 * Find the minimum number of platforms required for the railway station so that
 * no train is kept waiting. Consider that all the trains arrive on the same day
 * and leave on the same day. Arrival and departure time can never be the same
 * for a train but we can have arrival time of one train equal to departure time
 * of the other. At any given instance of time, same platform can not be used
 * for both departure of a train and arrival of another train. In such cases, we
 * need different platforms. Example 1:
 * 
 * Input: n = 6 arr[] = {0900, 0940, 0950, 1100, 1500, 1800} dep[] = {0910,
 * 1200, 1120, 1130, 1900, 2000} Output: 3 Explanation: Minimum 3 platforms are
 * required to safely arrive and depart all trains. Example 2:
 * 
 * Input: n = 3 arr[] = {0900, 1100, 1235} dep[] = {1000, 1200, 1240} Output: 1
 * Explanation: Only 1 platform is required to safely manage the arrival and
 * departure of all trains.
 * 
 * Your Task: You don't need to read input or print anything. Your task is to
 * complete the function findPlatform() which takes the array arr[] (denoting
 * the arrival times), array dep[] (denoting the departure times) and the size
 * of the array as inputs and returns the minimum number of platforms required
 * at the railway station such that no train waits.
 * 
 * Note: Time intervals are in the 24-hour format(HHMM) , where the first two
 * characters represent hour (between 00 to 23 ) and the last two characters
 * represent minutes (this may be > 59).
 * 
 * 
 * Expected Time Complexity: O(nLogn) Expected Auxiliary Space: O(n)
 * 
 * 
 * Constraints: 1 ≤ n ≤ 50000 0000 ≤ A[i] ≤ D[i] ≤ 2359
 * 
 */
public class MinimumPlatforms {

	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

//		int arr[] = { 900, 1100, 1235 };
//		int dep[] = { 1000, 1200, 1240 };
		System.out.println(findPlatform(arr, dep));
	}

	/* Expected approach */
	public static int findPlatform(int[] arr, int[] dep) {
		int n = arr.length;
		int res = 0;

		Arrays.sort(arr);
		Arrays.sort(dep);

		int count = 0;
		int j = 0;

		for (int i = 0; i < n; i++) {
			while (j < n && dep[j] < arr[i]) {
				count--;
				j++;
			}
			count++;
			res = Math.max(res, count);
		}
		return res;
	}

	public static int findPlatform(int arr[], int dep[], int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		List<Platform> platforms = new ArrayList<>();

		int platformCount = arr.length > 0 ? 1 : -1;
		platforms.add(new Platform(dep[0]));

		for (int i = 1; i < arr.length; i++) {
			CalculatedPlatform calculatedPlatform = hasVacantPlatform(platforms, arr[i]);
			if (!calculatedPlatform.hasVacantPlatform) {
				platformCount++;
				platforms.add(new Platform(dep[i]));
			} else {
				platforms.get(calculatedPlatform.index).freeAfter = dep[i];

			}
		}
		return platformCount;
	}

	public static CalculatedPlatform hasVacantPlatform(List<Platform> platforms, int arrivalTime) {
		CalculatedPlatform calculatedPlatform = new CalculatedPlatform();
		for (int i = 0; i < platforms.size(); i++) {
			Platform platform = platforms.get(i);
			if (platform.freeAfter >= arrivalTime) {
				continue;
			} else {
				calculatedPlatform.hasVacantPlatform = true;
				calculatedPlatform.index = i;
				break;
			}
		}
		return calculatedPlatform;
	}

	public static class Platform {
		int freeAfter;

		public Platform(int freeAfter) {
			this.freeAfter = freeAfter;
		}

	}

	public static class CalculatedPlatform {
		boolean hasVacantPlatform;
		int index;
	}

}
