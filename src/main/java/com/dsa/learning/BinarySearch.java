package com.dsa.learning;

/*Binary Search using recursion*/
public class BinarySearch {

    public int binarySearch(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        if (low <= high)
            return binarySearch(arr, num, low, high);
        return -1;
    }

    private int binarySearch(int[] arr, int numToSearch, int lowIndex, int highIndex) {
        if (lowIndex <= highIndex) {
            int midPosition = (lowIndex + highIndex) / 2;

            if (arr[midPosition] == numToSearch) {
                return midPosition;
            }
            if (arr[midPosition] > numToSearch) {
                highIndex = midPosition - 1;
                return binarySearch(arr, numToSearch, lowIndex, highIndex);
            } else {
                lowIndex = midPosition + 1;
                return binarySearch(arr, numToSearch, lowIndex, highIndex);
            }
        } else {
            return -1;
        }
    }

}
