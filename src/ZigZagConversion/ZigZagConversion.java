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

    //总体思路和我的基本一致，但是处理的比我巧妙，一次循环一个V行，使用StringBuilder数组，都是比我巧妙的地方
    public String convertHighestVoted(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            //必要的初始化，否则下面使用时要判断是否实例化，和上面我的算法一样
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while (i < s.length()){
            //下面一定要判断i < s.length()
            for(int index = 0;index < numRows && i < s.length(); index++)
                sb[index].append(s.charAt(i++));
            for (int index = numRows - 2; index > 0 && i < s.length(); index--)
                sb[index].append(s.charAt(i++));
        }
        for (int j = 1; j < sb.length; j++) {
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }
}
