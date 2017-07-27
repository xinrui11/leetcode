package LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
   Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

public class LetterCombinationsofaPhoneNumber {
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
                        String t = selected.get(i)[j];
                        res.add(selected.get(i)[j]);
                    }
                }
            }
            else{
                /*for(int p = 0;p < counts; p++){
                    for(int j = 0; j<level; j++){
                        for(int k = loopCount * j; k < loopCount * (j+1);k++){
                            res.set(k,res.get(k)+selected.get(i)[j]);
                        }
                    }
                }*/
                int j = 0;
                for(int p = 0;p < allCounts;p++){
                    if(p % loopCount == 0){
                        j++;
                    }
                    res.set(p,res.get(p)+selected.get(i)[j]);
                }
            }
        }
        return res;
    }

}
