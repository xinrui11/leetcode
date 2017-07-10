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
        for(int i = 0; i < s.length(); i++){
            int j = i;
            int length = 1;
            temp = s.substring(i, i + length);
            while(j + 1 < s.length() && !temp.contains(s.substring(j + 1, j + 2))){
                j++; length++;
                temp = s.substring(i, i + length);
            }
            if(answer < temp.length()){
                answer = temp.length();
            }
        }
        return answer;
    }
}
