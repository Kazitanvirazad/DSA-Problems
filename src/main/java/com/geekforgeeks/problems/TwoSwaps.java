package com.geekforgeeks.problems;

import java.util.Arrays;
import java.util.List;

/**
 * Given a permutation of some of the first natural numbers in an array arr[], determine if the array can be sorted
 * in exactly two swaps. A swap can involve the same pair of indices twice.
 *
 * Return true if it is possible to sort the array with exactly two or zero swaps, otherwise return false.
 *
 * Examples:
 *
 * Input: arr = [4, 3, 2, 1]
 * Output: true
 * Explanation: First, swap arr[0] and arr[3]. The array becomes [1, 3, 2, 4]. Then, swap arr[1] and arr[2].
 * The array becomes [1, 2, 3, 4], which is sorted.
 * Input: arr = [4, 3, 1, 2]
 * Output: false
 * Explanation: It is not possible to sort the array with exactly two swaps.
 * Input: arr = [1, 2, 3, 4]
 * Output: true
 * Explanation: It is already sorted array, so no swaps needed.
 */
public class TwoSwaps {
    public static void main(String[] args) {
        TwoSwaps swaps = new TwoSwaps();
        List<Integer> arr = Arrays.asList(3, 1, 2, 4);
        System.out.println(swaps.checkSorted(arr));
    }

    public boolean checkSorted(List<Integer> arr) {
        if (arr.size() < 2) {
            return false;
        }
        int unsortedCount = unsortedCount(arr);
        if (unsortedCount == 0 || unsortedCount == 3) {
            return true;
        }
        if (unsortedCount == 4) {
            swapOnce(arr);
            swapOnce(arr);
            return unsortedCount(arr) == 0;
        }
        return false;
    }

    public void swapOnce(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != i + 1) {
                int temp = arr.get(i);
                arr.set(i, arr.get(temp - 1));
                arr.set(temp - 1, temp);
                break;
            }
        }
    }

    public int unsortedCount(List<Integer> arr) {
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != i + 1) {
                count++;
            }
        }
        return count;
    }
}
