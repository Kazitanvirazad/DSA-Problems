package com.geekforgeeks.problems;

/**
 * Given an array arr[ ] of positive elements. Consider the array as a circular array,
 * meaning the element after the last element is the first element of the array.
 * The task is to find the maximum sum of the absolute differences between consecutive elements
 * with shuffling of array elements allowed i.e. shuffle the array elements and make [a1..an] such
 * order that  |a1 – a2| + |a2 – a3| + …… + |an-1 – an| + |an – a1| is maximized.
 *
 * Examples:
 *
 * Input: arr[] = [4, 2, 1, 8]
 * Output: 18
 * Explanation: After Shuffling, we get [1, 8, 2, 4]. Sum of absolute difference between consecutive elements
 * after rearrangement = |1 - 8| + |8 - 2| + |2 - 4| + |4 - 1| = 7 + 6 + 2 + 3 = 18.
 * Input: arr[] = [10, 12]
 * Output: 4
 * Explanation: No need of rearrangement. Sum of absolute difference between consecutive
 * elements = |10 - 12| + |12 - 10| = 2 + 2 = 4.
 */
public class SwapAndMaximize {
    public static void main(String[] args) {
        Long[] arr1 = {4L, 2L, 1L, 8L};
        Long[] arr2 = {10L, 12L};
        SwapAndMaximize swapAndMaximize = new SwapAndMaximize();
        System.out.println(swapAndMaximize.maxSum(arr1));
        System.out.println(swapAndMaximize.maxSum(arr2));
    }

    public long maxSum(Long[] arr) {
        quickSort(arr, 0, arr.length - 1);
        int start = 0;
        int last = arr.length - 1;

        long sum = 0;
        long firstElement = arr[start++];
        long secondElement, val;
        boolean isPickSmallerElement = false;
        while (start <= last) {
            if (start == last) {
                secondElement = arr[start++];
            } else {
                secondElement = isPickSmallerElement ? arr[start++] : arr[last--];
            }
            val = firstElement - secondElement;
            if (val < 0) {
                val *= -1;
            }
            sum += val;
            firstElement = secondElement;
            isPickSmallerElement = !isPickSmallerElement;
        }
        val = firstElement - arr[0];
        if (val < 0) {
            val *= -1;
        }
        sum += val;
        return sum;
    }

    private void quickSort(Long[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = getPivotIndex(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    private int getPivotIndex(Long[] arr, int start, int end) {
        int j = start, i = j - 1;
        while (j <= end) {
            if (arr[j] <= arr[end]) {
                i++;
                Long temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        return i;
    }
}
