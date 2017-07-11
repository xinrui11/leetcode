package LongestSubstringWithoutRepeatingCharacters;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        String temp = "";
        int start, end = 1;
        for(int i = 0; i < s.length(); i++){
            start = i;
            temp = s.substring(start, end);
            while(end + 1 <= s.length() && !temp.contains(s.substring(end, end + 1))){
                end++;
                temp = s.substring(start, end);
            }
            if(answer < temp.length()){
                answer = temp.length();
            }
        }
        return answer;
    }
}
