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
        //注意这里有两种情况，一种是中心为单字母，二是中心为双字母
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

    //马拉车算法，效率最高的算法
    /**
     * 但是实测并不是标率最高的算法，因为马拉车算法只是求最大长度，这里我将其改造了一下，将id作为了最大回文的中心，
     * 如果只求长度，没有必要记录最大回文的中心，可以将其不断后移，从而提高效率。
     * 算法核心就是利用了回文的对称性
     */
    public String longestPalindrome5(String s) {
        String formats = "%#";
        for (int i = 0; i < s.length(); i++) {
            //格式化字符串，字符串中间全部加#，处理单双数问题，首加上%防止越界，末尾自带\0所以不用加
            formats = formats + s.charAt(i) + "#";
        }
        formats = formats + "$";//java末尾不带\0，需要自己加一个不同的字段
        int[] p = new int[formats.length() + 1];//p[i]表示i位置的最大回文半径
        //求长度的算法 int max_len = 1;
        int id = 0;//最长回文的中心位置
        int mx = 1;//最长回文半径到达的位置
        for (int i = 1; i < formats.length() - 1; i++) {//头尾不需要判断
            if(i < mx){//先判断i和最大半径
                if(mx - i > p[2 * id - i]){//如果对称点的最大回文半径包含在最大回文半径中，则直接返回对称点的最大回文半径
                    p[i] =  p[2 * id - i];
                    continue;
                }
                else {//否则回文半径至少为mx - i，并需要继续判断
                    p[i] =  mx - i;
                }
            } else {//如果i在mx外面，则无法判断其半径，从1开始重新计算
                p[i] = 1;
            }
            while (formats.charAt(i + p[i]) == formats.charAt(i - p[i])){
                p[i]++;
            }
            //求长度的算法 int max_len = 1;
//            if(p[i] + i> mx){//这里判断有变化，只要新回文超过原本回文的位置，就后移，从而提高效率
//                id = i;
//                mx = p[i] + i;
//            }
            if(p[i] > mx - id){
                id = i;
                mx = p[i] + i;
            }
        }
        return formats.substring(2*id - mx + 1,mx).replaceAll("#","");
    }


}
