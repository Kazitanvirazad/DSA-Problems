package com.geekforgeeks.problems;

import java.util.Arrays;
import java.util.List;

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
