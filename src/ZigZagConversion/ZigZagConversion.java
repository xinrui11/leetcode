package ZigZagConversion;

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
        int[][] result = new int[numRows][s.length()];
        int space = numRows * 2 - 3;
        for (int i = 0; i < s.length();) {
            for (int j = 0; j < numRows; j++,i++) {
                result[j]
            }
        }
        for (int i = 0; i < numRows; i++) {
            if(i >= numRows / 2){
                space = space + ((i - (numRows / 2)) * 2);
            } else {
                space = space - (i * 2);
            }
            for (int j = i; j < s.length(); j=+space) {
                result = result + s.charAt(j)+ ;
            }
        }
        return result;
    }
}
