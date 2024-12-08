/* 
 You are given two strings start and target, both of length n. Each string consists only of the characters 'L', 'R', and '_' where:
The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only if there is a blank space directly to its left, and a piece 'R' can move to the right only if there is a blank space directly to its right.
The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.
Return true if it is possible to obtain the string target by moving the pieces of the string start any number of times. Otherwise, return false.
 */


class Solution {
    public boolean canChange(String start, String target) {
      if (!start.replace("_", "").equals(target.replace("_", ""))) {
          return false;
      }

      int i = 0, j = 0;
      int n = start.length();

      while (i < n && j < n) {
          while (i < n && start.charAt(i) == '_') {
              i++;
          }
          while (j < n && target.charAt(j) == '_') {
              j++;
          }

          if (i == n || j == n) {
              return i == j;
          }

          if (start.charAt(i) != target.charAt(j)) {
              return false;
          }

          if (start.charAt(i) == 'L' && i < j) {
              return false;
          }
          if (start.charAt(i) == 'R' && i > j) {
              return false;
          }

          i++;
          j++;
      }

      return true;
  }
}