package com.geekforgeeks.problems.parttwo;

/**
 * Given an array arr[] containing 2*n + 2 positive numbers, out of which 2*n numbers exist in pairs whereas the
 * other two number occur exactly once and are distinct. Find the other two numbers.
 * Return the answer in increasing order.
 *
 * Examples:
 *
 * Input: arr[] = [1, 2, 3, 2, 1, 4]
 * Output: [3, 4]
 * Explanation: 3 and 4 occur exactly once.
 * Input: arr[] = [2, 1, 3, 2]
 * Output: [1, 3]
 * Explanation: 1 and 3 occur exactly once.
 * Input: arr[] = [2, 1, 3, 3]
 * Output: [1, 2]
 * Explanation: 1 and 2 occur exactly once.
 * Constraints:
 * 2 ≤ arr.size() ≤ 106
 * 1 ≤ arr[i] ≤ 5 * 106
 * arr.size() is even
 */
public class UniqueNumber_II {
    public static void main(String[] args) {
        int[] sample1 = {1, 2, 3, 2, 1, 4};
        int[] sample2 = {2, 1, 3, 2};
        int[] sample3 = {2, 1, 3, 3};

        int[] res = singleNum(sample3);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] singleNum(int[] arr) {
        int xorVal = 0;
        for (int i : arr) {
            xorVal ^= i;
        }

        xorVal &= -xorVal;

        int[] res = new int[2];

        for (int num : arr) {
            if ((num & xorVal) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        if (res[0] > res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        return res;
    }
}
