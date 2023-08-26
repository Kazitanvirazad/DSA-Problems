package com.dsa.sorting;

public class MergeSort {

	public static void main(String[] args) {

		int[] arr = { 4, 3, 1, 6, 5, 2, 8, 7, 6, 6, -9, 3, 1, 9, 0, -6, 4, 2, 5 };
//		int[] arr = { 4, 3, 1, -6, 5, 0 };
		printArr(arr);
		int[] sortedArr = mergeSort(arr);
		printArr(sortedArr);
	}

	public static int[] mergeSort(int[] arr) {

		int leftArrayLength = arr.length / 2;

		int[] leftArr = new int[leftArrayLength];

		for (int i = 0; i < leftArr.length; i++) {
			leftArr[i] = arr[i];
		}

		int[] rightArr = new int[arr.length - leftArrayLength];
		copyElementsToRightArray(rightArr, arr);

		if (leftArr.length > 1) {
			leftArr = mergeSort(leftArr);
		}

		if (rightArr.length > 1) {
			rightArr = mergeSort(rightArr);
		}
		return mergeAndSortArray(leftArr, rightArr);
	}

	public static int[] mergeAndSortArray(int[] leftArr, int[] rightArr) {
		int[] sortedArray = new int[leftArr.length + rightArr.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int i = 0;
		while (i < sortedArray.length) {
			if (leftIndex < leftArr.length && rightIndex < rightArr.length
					&& leftArr[leftIndex] < rightArr[rightIndex]) {
				sortedArray[i] = leftArr[leftIndex];
				leftIndex++;
			} else if (leftIndex < leftArr.length && rightIndex < rightArr.length
					&& rightArr[rightIndex] < leftArr[leftIndex]) {
				sortedArray[i] = rightArr[rightIndex];
				rightIndex++;
			} else {
				if (leftIndex < leftArr.length) {
					sortedArray[i] = leftArr[leftIndex];
					leftIndex++;
				} else {
					sortedArray[i] = rightArr[rightIndex];
					rightIndex++;
				}
			}
			i++;
		}
		return sortedArray;
	}

	public static void copyElementsToRightArray(int[] rightArr, int[] arr) {
		int rightIndex = rightArr.length - 1;
		int arrIndex = arr.length - 1;
		while (rightIndex >= 0) {
			rightArr[rightIndex] = arr[arrIndex];
			rightIndex--;
			arrIndex--;
		}
	}

	public static void printArr(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}

}
