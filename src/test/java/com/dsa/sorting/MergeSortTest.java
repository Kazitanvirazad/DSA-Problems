package com.dsa.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    MergeSort mergeSort;


    @BeforeEach
    void setUp() {
        mergeSort = new MergeSort();
    }

    @Test
    @DisplayName(value = "Should return false as the array is not sorted")
    void checkIsSortedTestOne() {
        int[] arr = {4, 3, 1, 6, 5};
        assertEquals(false, mergeSort.isSorted(arr), "Should return false as the array is not sorted");
    }

    @Test
    @DisplayName(value = "Should return true as the array is sorted")
    void checkIsSortedTestTwo() {
        int[] arr = {1, 3, 4, 5, 6};
        assertEquals(true, mergeSort.isSorted(arr), "Should return true as the array is sorted");
    }

    @Test
    @DisplayName(value = "Should return true if the array is sorted Test 1")
    void checkWhetherArrayIsSortedTestOne() {
        int[] newArr1 = {4, 3, 1, 6, 5, 2, 8, 7, 6, 6, -9, 3, 1, 9, 0, -6, 4, 2, 5, 3};
        mergeSort.mergeSort(newArr1);
        assertEquals(true, mergeSort.isSorted(newArr1), "Should return true if the array is sorted Test 1");
    }

    @Test
    @DisplayName(value = "Should return true if the array is sorted Test 2")
    void checkWhetherArrayIsSortedTestTwo() {
        int[] arr = {4, 3, 1, 6, 5};
        mergeSort.mergeSort(arr);
        assertEquals(true, mergeSort.isSorted(arr), "Should return true if the array is sorted Test 2");
    }

    @Test
    @DisplayName(value = "Should return true if the array is sorted Test 3")
    void checkWhetherArrayIsSortedTestThree() {
        int[] arr1 = {4, 3, 1, 6, 5, 2};
        mergeSort.mergeSort(arr1);
        assertEquals(true, mergeSort.isSorted(arr1), "Should return true if the array is sorted Test 3");
    }

    @Test
    @DisplayName(value = "Should return true if the array is sorted Test 4")
    void checkWhetherArrayIsSortedTestFour() {
        int[] newArr = {4, 3, 1, 6, 5, 2, 8, 7, 6, 6, -9, 3, 1, 9, 0, -6, 4, 2, 5};
        mergeSort.mergeSort(newArr);
        assertEquals(true, mergeSort.isSorted(newArr), "Should return true if the array is sorted Test 4");
    }

    @Test
    @DisplayName(value = "Should return true if the array with two elements is sorted Test 5")
    void checkWhetherArrayIsSortedTestFive() {
        int[] arrWithTwoElements = {4, -3};
        mergeSort.mergeSort(arrWithTwoElements);
        assertEquals(true, mergeSort.isSorted(arrWithTwoElements), "Should return true if the array with two elements is sorted Test 5");
    }

    @Test
    @DisplayName(value = "Should return true if the array with one elements is sorted Test 6")
    void checkWhetherArrayIsSortedTestSix() {
        int[] arrWithOneElements = {4};
        mergeSort.mergeSort(arrWithOneElements);
        assertEquals(true, mergeSort.isSorted(arrWithOneElements), "Should return true if the array with one elements is sorted Test 6");
    }

    @Test
    @DisplayName(value = "Should return true if the array with no elements is sorted Test 7")
    void checkWhetherArrayIsSortedTestSeven() {
        int[] arrWithNoElements = {};
        mergeSort.mergeSort(arrWithNoElements);
        assertEquals(true, mergeSort.isSorted(arrWithNoElements), "Should return true if the array with no elements is sorted Test 7");
    }

}
