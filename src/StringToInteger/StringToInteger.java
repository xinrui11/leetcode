package StringToInteger;

import java.util.regex.Pattern;

/**
 * Implement atoi to convert a string to an integer.

   Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

   Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 */

//this question not define how to return illegal String,there is many possible solutions
public class StringToInteger {
    public int myAtoi(String str) {
        if(isAllNum(str))
            return  Integer.parseInt(str);
        else
            return 0;
    }

    public boolean isAllNum(String str){
        return Pattern.matches("^\\d+$",str);
    }

    public int myAtoi2(String str) {
        if(str.isEmpty()) return 0;
        //由于空格的ascii码在'0'前面，所以先去除空格
        str = str.replaceAll(" ","");
        int sign = 1, res = 0,start = 0;
        if((str.charAt(0) < '0' || str.charAt(0)>'9') && (str.charAt(0) != '-' && str.charAt(0) != '+')){
            return 0;
        } else if(str.charAt(0) == '-'){
            start = 1;
            sign = -1;
        } else if(str.charAt(0) == '+')
            start = 1;
        //如果有非数字字符
        for (int i = start; i < str.length(); i++) {
            //判断字符是否合法
            if(str.charAt(i) < '0' || str.charAt(i)>'9'){//有不合法字符时，将已有的数字返回
                return res*sign;
            } else if(Integer.MAX_VALUE / 10 < res || Integer.MIN_VALUE / 10 > res){//巧妙的判断，与边界值值的十分之一比较
                return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            } else {
                res *= 10;
                res += str.charAt(i) - '0';//使用ascii码
            }
        }
        return res*sign;
    }

    //this solution has passed leetcode's test
    public int myAtoiPassed(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }

}
