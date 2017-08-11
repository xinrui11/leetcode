package LongestValidParentheses;

/**
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int resLeft = 0,resRight = 0,left = 0,right = 0,length = 0;
        boolean start = false;
        char[] sc = s.toCharArray();
        for(char c : sc){
            if(c == '('){
                left++;
            }
            else if(c == ')'){
                right++;
            }
            if(!start && left > 0 && left == right){
                start = true;
            }
            if(!start && left < right){
                left = 0;
                right = 0;
                length = 0;
            }
            if(start){
                if(left == right){
                    length = right * 2;
                    if(resLeft < length){
                        resLeft = length;
                    }
                } else if(right > left) {
                    start = false;
                    left = 0;
                    right = 0;
                    length = 0;
                }
            }
        }
        // resLeft = resLeft > length? resLeft:length;
        // left = 0;right = 0;length = 0;
        // start = false;
        // for(int i = sc.length - 1; i >= 0; i--){
        //     char c = sc[i];
        //     if(c == '('){
        //         left++;
        //     }
        //     else if(c == ')'){
        //         right++;
        //     }
        //     if(!start && left < right){
        //         start = true;
        //     }
        //     if(!start && left >= right){
        //         left = 0;
        //         right = 0;
        //         length = 0;
        //     }
        //     if(start){
        //         if(left <= right){
        //             length = left*2;
        //         } else {
        //             start = false;
        //             left = 0;
        //             right = 0;
        //             if(resRight < length){
        //                 resRight = length;
        //             }
        //             length = 0;
        //         }
        //     }
        // }
        resRight = resRight > length? resRight:length;
        return resLeft;
    }

    public int longestValidParenthesesMYDP(String s) {
        int[] d1 = new int[s.length()];
        int[] d2 = new int[s.length()];
        int res = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(i == 0){
                if(c[i] == '('){
                    d1[i] = 0;
                    d2[i] = 1;
                } else {
                    d1[i] = 0;
                    d2[i] = 0;
                }
            } else {
                if(c[i] == '('){
                    if(d2[i - 1] > 0){
                        d1[i] = 0;
                    } else {
                        d1[i] = d1[i - 1];
                    }
                    d2[i] = d2[i - 1] + 1;
                } else {
                    if(d2[i - 1] > 0){
                        d1[i] = d1[i - 1] + 2;
                        d2[i] = d2[i - 1] - 1;
                        if(res < d1[i]){
                            res = d1[i];
                        }
                    } else {
                        d1[i] = 0;
                        d2[i] = 0;
                    }
                }
            }
        }
        return res;
    }
}
