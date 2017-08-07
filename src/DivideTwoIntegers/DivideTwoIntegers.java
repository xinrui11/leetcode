package DivideTwoIntegers;

/**
 Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 */

public class DivideTwoIntegers {
    //this solution will be TLE
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
        if(res+(-res) != 0){
            return Integer.MAX_VALUE;
        }
        return res;
    }

    public int divide2(int dividend, int divisor) {
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
        long res = divideRecursive(dividend, divisor);
        if(flag){
            res = - res;
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)res;
    }

    private long divideRecursive(int dividend, int divisor){
        if(dividend > divisor){
            return 0;
        }
        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = divisor;
        long count = 1;
        while(sum+sum >= dividend){
            sum += sum;
            count += count;
        }
        return count + divideRecursive(dividend - (int)sum, divisor);
    }
}
