package com.geekforgeeks.problems.partone;

/**
 * Given a string s, convert the first letter of each word in the string to
 * uppercase.
 * 
 * Examples:
 * 
 * Input: s = "gEEKs"
 * Output: "Geeks"
 * Input: s = "i love programming"
 * Output: "I Love Programming"
 * Constraints:
 * 1 <= s.length() <= 104
 * Consists of lowercase alphabets and spaces to separate words
 */
public class UpperCaseConversion {
  public static void main(String[] args) {
    UpperCaseConversion uConversion = new UpperCaseConversion();
    String str1 = "i love ProgrAmMing";
    String str2 = "gEEKs";
    System.out.println(uConversion.convert(str2));
  }

  public String convert(String s) {
    StringBuilder builder = new StringBuilder();
    if (isLowerCase(s.charAt(0))) {
      builder.append((char) (s.charAt(0) - 32));
    }

    int index = 1;
    while (index < s.length()) {
      if (s.charAt(index) == 32) {
        builder.append(s.charAt(index));
        if (index + 1 < s.length() && s.charAt(index + 1) != 32) {
          builder.append(isLowerCase(s.charAt(index + 1)) ? (char) (s.charAt(index + 1) - 32) : (s.charAt(index + 1)));
          index++;
        }
      } else {
        builder.append(s.charAt(index));
      }
      index++;
    }
    return builder.toString();
  }

  private boolean isLowerCase(char character) {
    return character > 96;
  }
}
