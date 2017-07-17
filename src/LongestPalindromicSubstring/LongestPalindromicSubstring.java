package LongestPalindromicSubstring;

import java.util.HashMap;
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
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        String longest = "";
        for(int i = 0; i < s.length(); i++){
            Map<Integer, Character> m = new HashMap<>();
            int key = 0;
            m.put(key, s.charAt(i));
            for(int j = i+1; j < s.length(); j++){
                key++;
                m.put(key, s.charAt(j));
                if(isPalindrome(m)){
                    if(longest.length() < j + 1 - i){
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longest;
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
}
