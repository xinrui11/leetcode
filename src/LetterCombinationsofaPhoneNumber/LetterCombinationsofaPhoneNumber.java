package LetterCombinationsofaPhoneNumber;

import java.util.*;

/**
 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
   Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

public class LetterCombinationsofaPhoneNumber {
    //this is my solution
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        String[][] letters = new String[][]{
                {},
                {},
                {"a","b","c"},
                {"d","e","f"},
                {"g","h","i"},
                {"j","k","l"},
                {"m","n","o"},
                {"p","q","r","s"},
                {"t","u","v"},
                {"w","x","y","z"}
        };
        Map<Integer,String[]> selected =new HashMap<>();
        for(int i = 0;i<digits.length();i++){
            selected.put(i,letters[Integer.parseInt(digits.charAt(i)+"")]);
        }
        List<String> res = new ArrayList<>();
        int allCounts = 1;
        for(int i = 0;i < selected.size(); i++){
            allCounts *= selected.get(i).length;
        }
        int loopCount = allCounts;
        for(int i = 0;i < selected.size(); i++){
            int level = selected.get(i).length;
            loopCount = loopCount/level;
            if(i == 0){
                for(int j = 0; j<level; j++){
                    for(int k = 0; k < loopCount; k++){
                        res.add(selected.get(i)[j]);
                    }
                }
            }
            else{
                int p = 0;
                while(p < allCounts){
                    for(int j = 0; j<level; j++){
                        for(int k = 0; k < loopCount; k++){
                            res.set(p,res.get(p)+selected.get(i)[j]);
                            p++;
                        }
                    }
                }
            }
        }
        return res;
    }

    //this solution is amazing,using FIFO queue
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits == null || digits.length() <= 0){
            return res;
        }
        res.add("");
        for(int i = 0; i < digits.length(); i++){
            while(res.peek().length() == i){
                String p = res.remove();
                int index = digits.charAt(i) - '0';
                for(int j = 0;j < KEYS[index].length(); j++){
                    res.add(p+KEYS[index].charAt(j));
                }
                /*for(char s : KEYS[index].toCharArray()){
                    res.add(p+s);
                }*/
            }
        }
        return res;
    }

    //recursive solution
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations3(String digits) {
        List<String> res = new ArrayList<>();
        combination("", digits, 0, res);
        return res;
    }

    private void combination(String prefix, String digits, int count, List<String> res){
        if(count >= digits.length()){
            res.add(prefix);
            return;
        }
        int index = digits.charAt(count) - '0';
//        count++;//It's same.
        for(int i = 0; i < KEYS[index].length(); i++){
            combination(prefix + KEYS[index].charAt(i), digits, count + 1, res);
        }
    }


}
