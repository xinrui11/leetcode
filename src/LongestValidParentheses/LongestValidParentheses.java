package LongestValidParentheses;

import java.util.Stack;

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
        int res = 0;
        char[] c = s.toCharArray();
        int[] d = new int[c.length];
        /*for (int i = 1; i < c.length; i++) {
            if(c[i] == '('){//这里不需要赋值0，int型数组会自动初始化为0
                d[i] = 0;
            } else {
                if(c[i - 1] == '('){
                    d[i] = i - 2 >= 0 ? d[i - 2] + 2: 2;
                } else {
                    if(i - d[i - 1] - 1 > 0 && c[i - d[i - 1] - 1] == '('){
                        d[i] = d[i - 1] + 2;
                    } else {
                        d[i] = 0;
                    }
                }
                if(res < d[i]){
                    res = d[i];
                }
            }
        }*/
        for (int i = 1; i < c.length; i++) {
            if(c[i] == ')'){
                if(c[i - 1] == '('){//looks like ...()
                    d[i] = i - 2 >= 0 ? d[i - 2] + 2: 2;
                } else if(i - d[i - 1] - 1 >= 0 && c[i - d[i - 1] - 1] == '('){//looks like ...))
                    //this is the key
                    d[i] = d[i - 1] + ((i - d[i - 1]) >= 2 ? d[i - d[i - 1] - 2] : 0)  + 2;
                }
                if(res < d[i]){
                    res = d[i];
                }
            }
        }
        return res;
    }

    public int longestValidParenthesesUseStack(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidParenthesesTwoPass(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

}
