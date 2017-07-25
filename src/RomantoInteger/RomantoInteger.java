package RomantoInteger;

import java.util.HashMap;
import java.util.Map;

/**
 Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 */

public class RomantoInteger {

    //this solution may cause Time Limit Exceeded
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);
        int res = 0;
        for(int i = 0;i<s.length();i++){
            //this step is the key
            if(i+1<s.length()&&map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                res -= map.get(s.charAt(i));
            } else{
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }

    //this solution is faster
    public int romanToInt2(String s) {
        int nums[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return sum+nums[nums.length-1];
    }
}
