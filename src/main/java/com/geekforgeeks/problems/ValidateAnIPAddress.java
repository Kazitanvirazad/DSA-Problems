package com.geekforgeeks.problems;

/**
 * You are given a string str in the form of an IPv4 Address. Your task is to validate an IPv4 Address, if it
 * is valid return true otherwise return false.
 *
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each
 * ranging from 0 to 255, separated by dots, e.g., 172.16.254.1
 *
 * A valid IPv4 Address is of the form x1.x2.x3.x4 where 0 <= (x1, x2, x3, x4) <= 255. Thus, we can write the
 * generalized form of an IPv4 address as (0-255).(0-255).(0-255).(0-255)
 *
 * Note: Here we are considering numbers only from 0 to 255 and any additional leading zeroes will be considered invalid.
 *
 * Examples :
 *
 * Input: str = 222.111.111.111
 * Output: true
 * Explanation: Here, the IPv4 address is as per the criteria mentioned and also all four decimal numbers lies in the
 * mentioned range.
 * Input: str = 5555..555
 * Output: false
 * Explanation: 5555..555 is not a valid. IPv4 address, as the middle two portions are missing.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 */
public class ValidateAnIPAddress {
    public static void main(String[] args) {
        String str1 = "5555..555";
        System.out.println(isValid(str1));
    }

    public static boolean isValid(String str) {
        if (str.length() < 7) {
            return false;
        }

        String[] ips = str.split("\\.");
        if (ips.length != 4) {
            return false;
        }

        for (int i = 0; i < ips.length; i++) {
            String current = ips[i];
            if (!isIpNumber(current)) {
                return false;
            }
            int unit = Integer.parseInt(current);
            if (unit < 0 || unit > 255) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIpNumber(String number) {
        if (number.isEmpty() || number.length() > 3) {
            return false;
        }
        // checking for leading zeroes
        if (number.length() > 1 && number.charAt(0) == '0') {
            return false;
        }
        char[] chars = number.toCharArray();
        boolean isNumber = true;

        for (int i = 0; i < chars.length && isNumber; i++) {
            if (!Character.isDigit(chars[i])) {
                isNumber = false;
            }
        }
        return isNumber;
    }
}
