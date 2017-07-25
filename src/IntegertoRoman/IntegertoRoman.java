package IntegertoRoman;

/**
 Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.
 */

public class IntegertoRoman {
    public String intToRoman(int num) {
        String[][]  c= new String[][]{
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}
        };
        StringBuilder s = new StringBuilder();
        int i = 3,sub = 1000;
        while(i >= 0){
            s.append(c[i--][num / sub]);
            num = num % sub;
            sub = sub / 10;
        }
        return s.toString();
    }

    public String intToRoman2(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
