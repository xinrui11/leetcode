package ValidParentheses;

import java.util.*;

/**
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class ValidParentheses {
    //this is my solution, not much different from below solution
    public boolean isValid(String s) {
        Map<Character,Character> characterMap = new HashMap<>();
        characterMap.put('(',')');
        characterMap.put('{','}');
        characterMap.put('[',']');
        Stack<Character> end = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(characterMap.keySet().contains(s.charAt(i))){
                end.add(characterMap.get(s.charAt(i)));
            } else if(characterMap.containsValue(s.charAt(i))){
                if(!end.isEmpty() && end.pop() == s.charAt(i)){
                    continue;
                }
                return false;
            }
        }
        return end.isEmpty();
    }

    //highestVoted solution
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
