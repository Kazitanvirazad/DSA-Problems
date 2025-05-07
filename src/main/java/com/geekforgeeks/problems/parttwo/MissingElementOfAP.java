package com.geekforgeeks.problems.parttwo;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a sorted array arr[] that represents an Arithmetic Progression (AP) with exactly one missing element,
 * find the missing number.
 *
 * Note: An element will always exist that, upon inserting into a sequence forms Arithmetic progression.
 * If the given sequence already forms a valid complete AP, return the (n+1)-th element that would come next in the sequence.
 *
 * Examples:
 *
 * Input: arr[] = [2, 4, 8, 10, 12, 14]
 * Output: 6
 * Explanation: Actual AP should be 2, 4, 6, 8, 10, 12, 14.
 * Input: arr[] = [1, 6, 11, 16, 21, 31]
 * Output: 26
 * Explanation: Actual AP should be 1, 6, 11, 16, 21, 26, 31.
 * Input: arr[] = [4, 7, 10, 13, 16]
 * Output: 19
 * Explanation: Since the sequence already forms a valid AP, the next element after 16 in the sequence would be 19.
 * Therefore, the output is 19.
 * Constraints:
 * 2 <= arr.size() <= 105
 * 0 <= arr[i] <= 2*107
 */
public class MissingElementOfAP {
    public static void main(String[] args) {
        int[] sample1 = {2, 4, 8, 10, 12, 14};  // 6
        int[] sample2 = {1, 6, 11, 16, 21, 31};     // 26
        int[] sample3 = {2, 4, 8, 12};      // 6
        int[] sample4 = {4, 7, 10, 13, 16};     // 19
        int[] sample5 = {5, 10, 15, 20};    // 25
        System.out.println(findMissingWithBinarySearch(sample5));
    }

    /* Expected Approach */
    public static int findMissingWithBinarySearch(int[] arr) {
        int n = arr.length;

        if (n == 2) {
            return arr[1] + (arr[1] - arr[0]);
        }
        int diff = (arr[1] - arr[0] == arr[n - 1] - arr[n - 2]) ? arr[1] - arr[0] :
                ((arr[1] - arr[0] == (arr[n - 1] - arr[0]) / n) ? arr[1] - arr[0] : arr[n - 1] - arr[n - 2]);

        if (diff == 0) return arr[0];
        int res = binarySearch(arr, 0, n - 1, diff);
        if (res == -1) {
            return arr[n - 1] + diff;
        }
        return res;
    }

    private static int binarySearch(int[] arr, int low, int high, int diff) {
        if (high <= low) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid + 1] - arr[mid] != diff) {
            return arr[mid] + diff;
        }
        if (mid > 0 && arr[mid] - arr[mid - 1] != diff) {
            return arr[mid - 1] + diff;
        }
        if (arr[mid] == arr[0] + mid * diff)
            return binarySearch(arr, mid + 1, high, diff);
        else
            return binarySearch(arr, low, mid - 1, diff);
    }

    public static int findMissing(int[] arr) {
        int n = arr.length;

        if (n == 2) {
            return arr[1] + (arr[1] - arr[0]);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }

        int diff = map
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(-1);

        int prev = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] != prev + diff) {
                return prev + diff;
            }
            prev = arr[i];
        }
        return arr[n - 1] + diff;
    }
}
