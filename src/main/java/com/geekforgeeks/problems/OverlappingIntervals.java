package com.geekforgeeks.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingIntervals {
    public static void main(String[] args) {
        OverlappingIntervals intervals = new OverlappingIntervals();
        int[][] arr = {
                {1, 3}, {2, 4}, {6, 8}, {9, 10}
//                {6, 8}, {1, 9}, {2, 4}, {4, 7}
//                {1, 3}, {1, 3}, {6, 8}, {9, 10}
//                {2, 13}, {1, 2}, {3, 6}
        };
        List<int[]> res = intervals.mergeOverlap(arr);
        res.forEach(element -> {
            for (int ele : element) {
                System.out.print(ele + " ");
            }
            System.out.println();
        });
    }

    public List<int[]> mergeOverlap(int[][] arr) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        res.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] current = arr[i];
            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                res.add(new int[]{current[0], current[1]});
            }
        }
        return res;
    }
}
