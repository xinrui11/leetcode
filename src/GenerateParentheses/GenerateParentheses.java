package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
 ]
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<Character> end = new Stack<>();
        String one = "(";
        return res;
    }

    void combine(List<String> end,List<String> res,String temp,int n){
        if(temp.length() == 2*n){
            res.add(temp);
            return;
        }
        for(int i = 1; i <= 2*n; i++){
            if(end.isEmpty()){
                temp += "(";
                end.add(")");
            } else {

            }
        }
    }

}
