// Given a string s, find the length of the longest substring without repeating characters.




class Solution {
  int lengthOfLongestSubstring(String s) {
    Map<String, int> map = {};
    int maxLength = 0, start = 0;
    
    for (int end = 0; end < s.length; end++) {
      if (map.containsKey(s[end])) {
        start = max(start, map[s[end]]! + 1);
      }
      map[s[end]] = end;
      maxLength = max(maxLength, end - start + 1);
    }
    
    return maxLength;
  }
}

