package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array arr[], find all possible indices [i, j, k] of triplets [arr[i], arr[j], arr[k]] in
 * the array whose sum is equal to zero. Return indices of triplets in any order and all the returned
 * triplets indices should also be internally sorted, i.e., for any triplet indices [i, j, k],
 * the condition i < j < k should hold.
 *
 * Examples:
 *
 * Input: arr[] = [0, -1, 2, -3, 1]
 * Output: [[0, 1, 4], [2, 3, 4]]
 * Explanation: Triplets with sum 0 are:
 * arr[0] + arr[1] + arr[4] = 0 + (-1) + 1 = 0
 * arr[2] + arr[3] + arr[4] = 2 + (-3) + 1 = 0
 * Input: arr[] = [1, -2, 1, 0, 5]
 * Output: [[0, 1, 2]]
 * Explanation: Only triplet which satisfies the condition is arr[0] + arr[1] + arr[2] = 1 + (-2) + 1 = 0
 * Input: arr[] = [2, 3, 1, 0, 5]
 * Output: [[]]
 * Explanation: There is no triplet with sum 0.
 */
public class FindAllTripletsWithZeroSum {
    public static void main(String[] args) {
        FindAllTripletsWithZeroSum findAllTripletsWithZeroSum = new FindAllTripletsWithZeroSum();
        int[] arr1 = {0, -1, 2, -3, 1};
        int[] arr2 = {1, -2, 1, 0, 5};
        int[] arr3 = {2, 3, 1, 0, 5};
        int[] arr4 = {1, -1, 2, -2, 3, -3};
        int[] arr5 = {-1, 0, 1, 2, -1, -4};
        int[] arr6 = {-8074, -7406, 3721, 6494, 4353, -96, 2214, -8708, 7502};
        findAllTripletsWithZeroSum.findTriplets(arr1).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        findAllTripletsWithZeroSum.findTriplets(arr2).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        findAllTripletsWithZeroSum.findTriplets(arr3).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        findAllTripletsWithZeroSum.findTriplets(arr4).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        findAllTripletsWithZeroSum.findTriplets(arr5).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        findAllTripletsWithZeroSum.findTriplets(arr6).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
    }

    public List<List<Integer>> findTriplets(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(-arr[i], i);
        }
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (map.containsKey(arr[i] + arr[j])) {
                    int sum = (arr[i] + arr[j]);
                    int index = map.get(sum);
                    if (index == i || index == j) {
                        continue;
                    }
                    List<Integer> indices = new ArrayList<>();
                    indices.add(index);
                    indices.add(i);
                    indices.add(j);
                    Collections.sort(indices);
                    res.add(indices);
                }
            }
        }
        return new ArrayList<>(res);
    }
}
