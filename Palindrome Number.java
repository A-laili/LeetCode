class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = Integer.toString(x); 
        StringBuilder sb = new StringBuilder(str);
        String str_reverse = sb.reverse().toString();
        return str.equals(str_reverse);

   }
}