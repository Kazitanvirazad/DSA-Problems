package com.geekforgeeks.problems;

/**
 * You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of
 * meeting i and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be
 * accommodated in a single meeting room, when only one meeting can be held in the meeting room at a particular time.
 *
 * Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
 *
 * Examples :
 *
 * Input: n = 6, start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
 * Output: 4
 * Explanation: Maximum four meetings can be held with given start and end timings.
 * The meetings are - (1, 2), (3, 4), (5,7) and (8,9)
 * Input: n = 3, start[] = [10, 12, 20], end[] = [20, 25, 30]
 * Output: 1
 * Explanation: Only one meetings can be held with given start and end timings.
 * Expected Time Complexity: O(n*logn)
 * Expected Auxilliary Space: O(n)
 */
public class NMeetingsInOneRoom {
    public static void main(String[] args) {
//        int start[] = {1, 3, 0, 5, 8, 5};
//        int end[] = {2, 4, 6, 7, 9, 9};
        int start[] = {10, 12, 20};
        int end[] = {20, 25, 30};
//        quickSort(end, start, 0, start.length - 1);
//        for (int i : start) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        for (int i : end) {
//            System.out.print(i + " ");
//        }
        System.out.println(maxMeetings(start.length, start, end));
    }

    public static int maxMeetings(int n, int start[], int end[]) {
        quickSort(end, start, 0, start.length - 1);

        int rangeEnd = end[0];

        int meetings = 1;

        for (int i = 1; i < start.length; i++) {
            if (start[i] > rangeEnd) {
                rangeEnd = end[i];
                meetings++;
            }
        }
        return meetings;
    }

    private static void quickSort(int[] input1, int[] input2, int start, int end) {
        if (end <= start) {
            return;
        }

        int partitionIndex = getPartitionIndex(input1, input2, start, end);
        quickSort(input1, input2, start, partitionIndex - 1);
        quickSort(input1, input2, partitionIndex + 1, end);
    }

    private static int getPartitionIndex(int[] input1, int[] input2, int start, int end) {
        int j = start, i = j - 1;

        int partition = input1[end];

        while (j <= end) {
            if (input1[j] <= partition) {
                i++;
                int temp = input1[i];
                int temp2 = input2[i];
                input1[i] = input1[j];
                input2[i] = input2[j];
                input1[j] = temp;
                input2[j] = temp2;
            }
            j++;
        }

        return i;
    }
}
