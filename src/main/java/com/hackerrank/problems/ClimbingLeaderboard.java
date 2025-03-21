package com.hackerrank.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An arcade game player wants to climb to the top of the leaderboard and track their ranking.
 * The game uses Dense Ranking, so its leaderboard works like this:
 *
 * The player with the highest score is ranked number 1 on the leaderboard.
 * Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately
 * following ranking number.
 *
 * Function Description
 *
 * Complete the climbingLeaderboard function in the editor below.
 *
 * climbingLeaderboard has the following parameter(s):
 *
 * int ranked[n]: the leaderboard scores
 * int player[m]: the player's scores
 * Returns
 *
 * int[m]: the player's rank after each new score
 * Input Format
 *
 * The first line contains an integer , the number of players on the leaderboard.
 * The next line contains  space-separated integers , the leaderboard scores in decreasing order.
 * The next line contains an integer, , the number games the player plays.
 * The last line contains  space-separated integers , the game scores.
 */
public class ClimbingLeaderboard {
    public static void main(String[] args) {
        System.out.println(climbingLeaderboard(List.of(100, 100, 50, 40, 40, 20, 10), List.of(5, 25, 50, 120)));
        System.out.println(climbingLeaderboard(List.of(100, 90, 90, 80, 75, 60), List.of(50, 65, 77, 90, 102)));
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        ranked = ranked.stream().distinct().collect(Collectors.toList());
        for (int score : player) {
            if (score >= ranked.get(0)) {
                result.add(1);
                continue;
            }
            if (score < ranked.get(ranked.size() - 1)) {
                result.add(ranked.size() + 1);
                continue;
            }
            if (score == ranked.get(ranked.size() - 1)) {
                result.add(ranked.size());
                continue;
            }
            int binarySearchIndex = binarySearch(ranked, score, 0, ranked.size() - 1);
            if (binarySearchIndex > -1) {
                result.add(binarySearchIndex + 1);
            }
        }
        return result;
    }

    private static int binarySearch(List<Integer> ranked, int element, int low, int high) {
        if (low <= high) {
            int mid = (high + low) / 2;
            if (ranked.get(mid) == element) {
                return mid;
            }
            if (ranked.get(mid) > element) {
                return binarySearch(ranked, element, mid + 1, high);
            } else {
                return binarySearch(ranked, element, low, mid - 1);
            }
        }
        return low;
    }
}
