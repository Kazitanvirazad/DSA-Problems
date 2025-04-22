package com.geekforgeeks.problems.partone;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array arr. Return the size of the modified array which contains only distinct elements.
 * Note:
 * 1. Don't use set or HashMap to solve the problem.
 * 2. You must return the modified array size only where distinct elements are present and modify
 * the original array such that all the distinct elements come at the beginning of the original array.
 *
 * Examples :
 *
 * Input: arr = [2, 2, 2, 2, 2]
 * Output: [2]
 * Explanation: After removing all the duplicates only one instance of 2 will remain i.e. [2] so
 * modified array will contains 2 at first position and you should return 1 after modifying the array,
 * the driver code will print the modified array elements.
 * Input: arr = [1, 2, 4]
 * Output: [1, 2, 4]
 * Explation:  As the array does not contain any duplicates so you should return 3.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray remove = new RemoveDuplicatesFromSortedArray();
        List<Integer> arr = new ArrayList<>();
//        arr.add(2);
//        arr.add(2);
//        arr.add(2);
//        arr.add(2);
//        arr.add(2);
//        arr.add(1);
//        arr.add(2);
//        arr.add(4);
        arr.add(2);
        arr.add(2);
        arr.add(4);
        arr.add(4);
        arr.add(8);
        arr.add(8);
        arr.add(9);
        arr.add(11);
        System.out.println(remove.remove_duplicate(arr));
        arr.forEach(ele -> System.out.print(ele + " "));
    }

    public int remove_duplicate(List<Integer> arr) {
        int index = 0;
        List<Integer> temp = new ArrayList<>();
        while (index < arr.size() - 1) {
            if (!arr.get(index).equals(arr.get(index + 1))) {
                temp.add(arr.get(index));
            }
            index++;
        }
        if (temp.size() == 0) {
            temp.add(arr.get(0));
        } else if (!temp.get(temp.size() - 1).equals(arr.get(arr.size() - 1))) {
            temp.add(arr.get(arr.size() - 1));
        }
        for (int i = 0; i < temp.size(); i++) {
            arr.set(i, temp.get(i));
        }
        int diff = arr.size() - temp.size();
        while (diff > 0) {
            arr.remove(arr.size() - 1);
            diff--;
        }
        return arr.size();
    }
}
