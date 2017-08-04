package DivideTwoIntegers;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        boolean flag = false;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            flag = true;
        }
        if(dividend > 0){
            dividend = - dividend;
        }
        if(divisor > 0){
            divisor = - divisor;
        }
        int res = -1;
        while(dividend <= 0){
            if(res == Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            dividend-=divisor;
            res++;
        }
        if(flag){
            res = - res;
        }
        return res;
    }
}
