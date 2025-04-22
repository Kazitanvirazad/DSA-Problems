package com.geekforgeeks.problems.partone;

/**
 * Given an array arr of integers. Find whether three numbers are such that the sum of two elements equals
 * the third element.
 *
 * Example:
 *
 * Input: arr[] = [1, 2, 3, 4, 5]
 * Output: true
 * Explanation: The pair (1, 2) sums to 3.
 * Input: arr[] = [5, 3, 4]
 * Output: false
 * Explanation: No triplets satisfy the condition.
 * Expected Time Complexity: O(n2)
 * Expected Auxilary Space: O(1)
 */
public class TripletFamily {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 3, 4};
        int[] arr3 = {23774, 14662, 31525, 15479, 32545, 4340, 17655, 18342, 4575, 28950, 15297, 31998, 1788, 11149, 13098, 17809, 14097, 15138, 27948, 1162, 15726, 16248, 30253, 4801, 21851, 30014, 3180, 6284, 7332, 32425, 5791, 14807, 24404, 4130, 28123, 18551, 20672, 21820, 32435, 28859, 21959, 8680, 1444, 5188, 17497};
        int[] arr4 = {30438, 8374, 24141, 22623, 26069, 19940, 6674, 18279, 27898, 2552, 1673, 24616, 18307, 20029, 30563, 10466, 7870, 10896, 22934, 17665, 2422, 5991, 19795, 30532, 5504, 10514, 7225, 3870, 3985, 2113, 24520, 17757, 32083, 21447, 27672, 19465, 32183, 20381, 21195, 5519, 908, 1322, 4672, 5918, 7761, 14529, 17673, 2642, 17735};
        int[] arr5 = {6865, 8921, 22468, 20392, 27390, 31530, 8847, 26964, 20505, 21692, 7535, 31540, 18233, 19549, 30152, 12717, 28032, 25526, 23414, 7868, 26691, 22744, 18960, 28208, 6250, 7192, 30569, 10775, 7450, 22557, 2909};
        int[] arr6 = {26016, 29200, 22731, 18408, 31317, 26289, 19939, 11760, 15755, 28002, 14359, 9919, 5668, 24266, 9602, 32720, 29754, 8430, 296, 24808, 26128, 14418, 28554, 1622, 31048, 29793, 22904, 28793, 15446, 15119, 6439, 11396, 29748, 14269, 32131, 6782};
        System.out.println(findTriplet(arr1));
        System.out.println(findTriplet(arr2));
        System.out.println(findTriplet(arr3));
        System.out.println(findTriplet(arr4));
        System.out.println(findTriplet(arr5));
        System.out.println(findTriplet(arr6));
    }

    public static boolean findTriplet(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (binarySearch(arr, arr[i] + arr[j], j, arr.length - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int item, int low, int high) {
        if (low > high) {
            return false;
        } else {
            int midIndex = (high + low) / 2;
            if (arr[midIndex] == item) {
                return true;
            } else if (arr[midIndex] > item) {
                return binarySearch(arr, item, low, midIndex - 1);
            } else {
                return binarySearch(arr, item, midIndex + 1, high);
            }
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = getPivotIndex(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    private static int getPivotIndex(int[] arr, int start, int end) {
        int j = start, i = j - 1;
        while (j <= end) {
            if (arr[j] <= arr[end]) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        return i;
    }
}
