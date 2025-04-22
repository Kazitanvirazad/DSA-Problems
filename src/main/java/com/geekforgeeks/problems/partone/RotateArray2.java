package com.geekforgeeks.problems.partone;

import java.util.LinkedList;
import java.util.Queue;

public class RotateArray2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int d1 = 2;
        rotateArr(arr1, d1);
        print(arr1);
        int[] arr2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int d2 = 3;
        rotateArr(arr2, d2);
        print(arr2);
        int[] arr3 = {7, 3, 9, 1};
        int d3 = 9;
        rotateArr(arr3, d3);
        print(arr3);
        int[] arr4 = {1, 2, 3, 4, 5};
        int d4 = 5;
        rotateArr(arr4, d4);
        print(arr4);
    }

    // Time Complexity = O(n+d) [where d is always less than n]
    // Space Complexity = O(d) [where d is always less than n]
    public static void rotateArr(int[] arr, int d) {
        if (d == arr.length) {
            return;
        }
        if (d > arr.length) {
            d = d - (arr.length * (d / arr.length));
        }
        Queue<Integer> queue = new LinkedList<>();
        int index;
        // O(d)
        for (index = 0; index < d; index++) {
            queue.add(arr[index]);
        }
        //O(n-d)
        while (index < arr.length) {
            arr[index - d] = arr[index];
            index++;
        }
        // O(d)
        for (int i = arr.length - d; i < arr.length; i++) {
            arr[i] = queue.poll();
        }
    }

    private static void print(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}
