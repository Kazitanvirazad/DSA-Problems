package com.geekforgeeks.problems.partone;

import java.util.ArrayList;

/**
 * Given an array arr[] of N integers, the task is to find the element which is left at last after performing
 * the following operation N – 1 time. For every Kth operation:
 *
 * Right-rotate the array clockwise by 1.
 * Delete the (n – K + 1)th last element.
 * Example:
 *
 *
 * Input: N = 6, arr[] = {1, 2, 3, 4, 5, 6}
 * Output: 3
 * Explanation: Rotate the array clockwise i.e. after rotation the array A = {6, 1, 2, 3, 4, 5} and delete the last
 * element that is {5} that will be A = {6, 1, 2, 3, 4}.
 * Again rotate the array for the second time and deletes the second last element that is {2} that will be A = {4, 6, 1, 3},
 * doing similar operation when we perform 4th operation, 4th last element does not exist. Then we deletes 1st
 * element ie {1} that will be A = {3, 6}. So, continuing this procedure the last element in A is {3}.
 * So, the output will be 3.
 *
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class RotateAndDelete {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>() {{
            for (int i = 0; i < 4; i++) {
                add(i + 1);
            }
        }};
        array.forEach(ele -> System.out.print(ele + " "));
        System.out.println();

//        array.add(0, array.get(array.size() - 1));
//        array.remove(array.size() - 1);
        System.out.println(rotateDelete(array));
        array.forEach(ele -> System.out.print(ele + " "));
    }

    public static int rotateDelete(ArrayList<Integer> arr) {
        int res = 0;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            if (arr.size() == 1) {
                res = arr.get(0);
                break;
            }
            arr.add(0, arr.get(arr.size() - 1));
            arr.remove(arr.size() - 1);
            int kth = i + 1;

            if (kth < arr.size()) {
                arr.remove(arr.size() - kth);
            } else {
                arr.remove(0);
            }
        }
        return res;
    }
}
