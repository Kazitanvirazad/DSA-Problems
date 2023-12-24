package com.dsa.learning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {
    BinarySearch search;
    int[] arr = {1, 4, 8, 11, 15, 17, 18};
    int[] arr2 = {-4, -1, 0, 4, 8, 11, 15, 17, 18};
    int[] arr3 = {-4, -3, -1, 8, 11, 15, 17, 18};

    @BeforeEach
    void setUp() {
        search = new BinarySearch();
    }

    @Test
    @DisplayName(value = "Searching an integer not present in the array should return -1")
    void numberNotPresentInArrayShouldReturnNegativeOneTest() {
        assertEquals(-1, search.binarySearch(arr, 12), "Searching an integer not present in the array should return -1");
    }

    @Test
    @DisplayName(value = "Searching an integer 15 present in the array should return 4")
    void numberPresentInArrayShouldReturnIndexPositionFour() {
        assertEquals(4, search.binarySearch(arr, 15), "Searching an integer 15 present in the array should return position 4");
    }

    @Test
    @DisplayName(value = "Searching a negative integer -1 present in the array should return position 2")
    void negativeNumberPresentInArrayShouldReturnIndexPositionTwo() {
        assertEquals(2, search.binarySearch(arr3, -1), "Searching a negative integer -1 present in the array should return position 2");
    }
}
