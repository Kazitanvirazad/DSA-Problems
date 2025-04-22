package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the
 * overlapping Intervals.
 *
 * Examples:
 *
 * Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
 * Output: [[1,4], [6,8], [9,10]]
 * Explanation: In the given intervals we have only two overlapping intervals here, [1,3] and [2,4] which
 * on merging will become [1,4]. Therefore we will return [[1,4], [6,8], [9,10]].
 * Input: arr[][] = [[6,8],[1,9],[2,4],[4,7]]
 * Output: [[1,9]]
 * Explanation: In the given intervals all the intervals overlap with the interval [1,9].
 * Therefore we will return [1,9].
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * 0 ≤ starti ≤ endi ≤ 105
 */
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
