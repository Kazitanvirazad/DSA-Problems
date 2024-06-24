package com.dsa.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MergeSortTest {

    MergeSort mergeSort;

    @BeforeEach
    void setUp() {
        mergeSort = new MergeSort();
    }

    boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (!(arr[i] <= arr[i + 1]))
                return false;
        }
        return true;
    }

    @Test
    @DisplayName(value = "Should return false as the array is not mergeSorted")
    void checkIsSortedTestOne() {
        int[] arr = {4, 3, 1, 6, 5};
        assertFalse(isSorted(arr), "Should return false as the array is not mergeSorted");
    }

    @Test
    @DisplayName(value = "Should return true as the array is mergeSorted")
    void checkIsSortedTestTwo() {
        int[] arr = {1, 3, 4, 5, 6};
        assertTrue(isSorted(arr), "Should return true as the array is mergeSorted");
    }

    @Test
    @DisplayName(value = "Should return true if the array is mergeSorted Test 1")
    void checkWhetherArrayIsSortedTestOne() {
        int[] newArr1 = {4, 3, 1, 6, 5, 2, 8, 7, 6, 6, -9, 3, 1, 9, 0, -6, 4, 2, 5, 3};
        mergeSort.mergeSort(newArr1);
        assertTrue(isSorted(newArr1), "Should return true if the array is mergeSorted Test 1");
    }

    @Test
    @DisplayName(value = "Should return true if the array is mergeSorted Test 2")
    void checkWhetherArrayIsSortedTestTwo() {
        int[] arr = {4, 3, 1, 6, 5};
        mergeSort.mergeSort(arr);
        assertTrue(isSorted(arr), "Should return true if the array is mergeSorted Test 2");
    }

    @Test
    @DisplayName(value = "Should return true if the array is mergeSorted Test 3")
    void checkWhetherArrayIsSortedTestThree() {
        int[] arr1 = {4, 3, 1, 6, 5, 2};
        mergeSort.mergeSort(arr1);
        assertTrue(isSorted(arr1), "Should return true if the array is mergeSorted Test 3");
    }

    @Test
    @DisplayName(value = "Should return true if the array is mergeSorted Test 4")
    void checkWhetherArrayIsSortedTestFour() {
        int[] newArr = {4, 3, 1, 6, 5, 2, 8, 7, 6, 6, -9, 3, 1, 9, 0, -6, 4, 2, 5};
        mergeSort.mergeSort(newArr);
        assertTrue(isSorted(newArr), "Should return true if the array is mergeSorted Test 4");
    }

    @Test
    @DisplayName(value = "Should return true if the array with two elements is mergeSorted Test 5")
    void checkWhetherArrayIsSortedTestFive() {
        int[] arrWithTwoElements = {4, -3};
        mergeSort.mergeSort(arrWithTwoElements);
        assertTrue(isSorted(arrWithTwoElements), "Should return true if the array with two elements is mergeSorted Test 5");
    }

    @Test
    @DisplayName(value = "Should return true if the array with one elements is mergeSorted Test 6")
    void checkWhetherArrayIsSortedTestSix() {
        int[] arrWithOneElements = {4};
        mergeSort.mergeSort(arrWithOneElements);
        assertTrue(isSorted(arrWithOneElements), "Should return true if the array with one elements is mergeSorted Test 6");
    }

    @Test
    @DisplayName(value = "Should return true if the array with no elements is mergeSorted Test 7")
    void checkWhetherArrayIsSortedTestSeven() {
        int[] arrWithNoElements = {};
        mergeSort.mergeSort(arrWithNoElements);
        assertTrue(isSorted(arrWithNoElements), "Should return true if the array with no elements is mergeSorted Test 7");
    }

}
