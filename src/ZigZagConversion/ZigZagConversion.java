package ZigZagConversion;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {
    /**
     The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

     P   A   H   N
     A P L S I I G
     Y   I   R
     And then read line by line: "PAHNAPLSIIGYIR"
     Write the code that will take a string and make this conversion given a number of rows:

     string convert(string text, int nRows);
     convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     */
    public String convert(String s, int numRows) {
        Map<Integer,String> result = new HashMap<>();
        boolean flag = true;
        for (int i = 0; i < s.length();) {
            for (int j = 0; j < numRows && i < s.length(); i++) {
                String temp = result.get(j);
                if(temp != null){
                    result.put(j,temp+s.charAt(i));
                }
                else{
                    result.put(j,""+s.charAt(i));
                }
                if(flag)
                    j++;
                else
                    j--;
                if(j == numRows - 1){
                    flag = false;
                }
                if(j == 0){
                    flag = true;
                }
            }
        }
        String re = "";
        for(Map.Entry<Integer, String> entry : result.entrySet()){
            re = re + entry.getValue();
        }
        return re;
    }
}
