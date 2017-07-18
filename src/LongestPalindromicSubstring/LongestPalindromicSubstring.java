package LongestPalindromicSubstring;

import java.util.Map;

/**
 * Created by xinrui on 2017-7-15.
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Input: "babad"

 * Output: "bab"

 * Note: "aba" is also a valid answer.

 * Input: "cbbd"

 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    /**
     * 最长回文字
     */
    //最初的解法，暴力寻找，时间复杂度直上n`3，leecode会报超时
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        String longest = new String();
        String temp;
        for(int i = 0; i < s.length(); i++){
            for(int j = s.length(); j > i; j--){
                temp = s.substring(i, j);
                if(isPalindrome(temp)){
                    if(longest.length() < temp.length()){
                        longest = temp;
                    }
                }
            }
        }
        return longest;
    }

    private boolean isPalindrome(String m){
        if(m.length() <= 1){
            return true;
        }
        int halfSize = m.length() / 2;
        for(int i = 0;i < halfSize; i++){
            if(m.charAt(i) != m.charAt(m.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(Map<Integer, Character> m){
        if(m.size() <= 1){
            return true;
        }
        int halfSize = m.size() / 2;
        for(int i = 0;i < halfSize; i++){
            if(m.get(i) != m.get(m.size() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    //中心拓展法，时间复杂度n`2，leetcode通过
    public String longestPalindrome2(String s) {
        if(s.length() <= 1){
            return s;
        }
        String longest = new String();
        for(int i = 0; i < s.length() - 1; i++){
            String temp = centerExpand(s,i,i+1);
            if(longest.length()<temp.length())
                longest = temp;
            temp = centerExpand(s,i,i);
            if(longest.length()<temp.length())
                longest = temp;
        }
        return longest;
    }
    private String centerExpand(String s, int start, int end){
        while(start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start + 1, end );
    }

    //将s倒置为s2，s和s2的最长的公共的字符串即为最长回文字符串，时间复杂度也是n`2，leetcode会报超时
    public String longestPalindrome3(String s) {
        String s2 = new String();
        for(int i = s.length() - 1; i >= 0; i--){
            s2 = s2 + s.charAt(i);
        }
        String longest = new String();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i,j);
                String temp2 = s2.substring(s.length() - j,s.length() - i);
                if(temp.equals(temp2) && temp.length() > longest.length()){
                    longest = temp;
                }
            }
        }
        return longest;
    }

    //动态规划
    public String longestPalindrome4(String s) {
        boolean[][] p = new boolean[1000][1000];
        int start = 0,maxLength = 0;
        for (int i = 0; i < 1000; i++) {
            p[i][i] = true;
            if(maxLength == 0){
                start = i;
                maxLength = 1;
            }
            if(i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                p[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        for(int len = 3;len <= s.length(); len++ ){
            for (int i = 0; i < s.length(); i++) {
                int j = i + len - 1;
                if(j < s.length() && p[i + 1][j - 1] && s.charAt(i)==s.charAt(j)){
                    p[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

}
