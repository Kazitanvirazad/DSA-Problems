package com.dsa.learning;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String sample1 = "abdace";
        String sample2 = "babce";
        System.out.println(longestCommonSubsequence_Recursion(sample1, sample2));
        System.out.println(longestCommonSubsequence_DynamicProgramming(sample1, sample2));
    }

    // Recursion
    private static int longestCommonSubsequence_Recursion(String textA, String textB) {
        return longestCommonSubsequence_Recursion(textA, textB, 0, 0);
    }

    private static int longestCommonSubsequence_Recursion(String textA, String textB, int positionA, int positionB) {
        if (positionA >= textA.length() || positionB >= textB.length()) {
            return 0;
        }
        int ans;
        if (textA.charAt(positionA) != textB.charAt(positionB)) {
            ans = Math.max(longestCommonSubsequence_Recursion(textA, textB, positionA + 1, positionB),
                    longestCommonSubsequence_Recursion(textA, textB, positionA, positionB + 1));
        } else {
            ans = 1 + longestCommonSubsequence_Recursion(textA, textB, positionA + 1, positionB + 1);
        }
        return ans;
    }

    // Dynamic Programming
    private static int longestCommonSubsequence_DynamicProgramming(String textA, String textB) {
        Integer[][] dynamicTable = new Integer[textA.length()][textB.length()];
        return longestCommonSubsequence_DynamicProgramming(textA, textB, textA.length() - 1, textB.length() - 1, dynamicTable);
    }

    private static int longestCommonSubsequence_DynamicProgramming(String textA, String textB, int positionA, int positionB, Integer[][] dynamicTable) {
        if (positionA < 0 || positionB < 0) {
            return 0;
        }
        if (dynamicTable[positionA][positionB] != null) {
            return dynamicTable[positionA][positionB];
        }
        if (textA.charAt(positionA) == textB.charAt(positionB)) {
            dynamicTable[positionA][positionB] = 1 + longestCommonSubsequence_DynamicProgramming(textA, textB, positionA - 1, positionB - 1, dynamicTable);
        } else {
            dynamicTable[positionA][positionB] = Math.max(
                    longestCommonSubsequence_DynamicProgramming(textA, textB, positionA - 1, positionB, dynamicTable),
                    longestCommonSubsequence_DynamicProgramming(textA, textB, positionA, positionB - 1, dynamicTable)
            );
        }
        return dynamicTable[positionA][positionB];
    }
}
