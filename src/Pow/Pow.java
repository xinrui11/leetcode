package Pow;

/**
 * Implement pow(x, n).
 * Example 1:

     Input: 2.00000, 10
     Output: 1024.00000
     Example 2:

     Input: 2.10000, 3
     Output: 9.26100
 */
public class Pow {
    //普通解法
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n < 0){
            x = 1/x;
            double origin = x;
            n++;
            while (n < 0){
                x = x*origin;
                n++;
            }
            return x;
        }
        else {
            double origin = x;
            while (n > 1){
                x = x*origin;
                n--;
            }
            return x;
        }
    }

    //二分解法
    public double myPowBinary(double x, int n) {
        if(x == 0)
            return 0;
        if(x == 1)
            return 1;
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 1/x*myPowBinary(1/x,-(n+1));//n+1再取反，防止-2147483648直接取反溢出
        }
        else {
            if(n%2 == 0)
                return myPowBinary(x*x,n/2);
            else
                return x*myPowBinary(x*x,n/2);//(n+1)/2和n/2等价
        }
    }

    //测试
    public static void main(String[] a){
        double x = 2;int n = 10;
        Pow p = new Pow();
        System.out.println("input is:"+"("+x + "," + n +")");
        System.out.println("output is:" + p.myPow(x,n));
        System.out.println("Binary output is:" + p.myPowBinary(x,n));
        x = 2;n = -10;
        System.out.println("input is:"+"("+x + "," + n +")");
        System.out.println("output is:" + p.myPow(x,n));
        System.out.println("Binary output is:" + p.myPowBinary(x,n));
        x = 2;n = 9;
        System.out.println("input is:"+"("+x + "," + n +")");
        System.out.println("output is:" + p.myPow(x,n));
        System.out.println("Binary output is:" + p.myPowBinary(x,n));
        x = 2;n = -9;
        System.out.println("input is:"+"("+x + "," + n +")");
        System.out.println("output is:" + p.myPow(x,n));
        System.out.println("Binary output is:" + p.myPowBinary(x,n));
        x = 2;n = -2147483648;
        System.out.println("input is:"+"("+x + "," + n +")");
        System.out.println("output is:" + p.myPow(x,n));
        System.out.println("Binary output is:" + p.myPowBinary(x,n));
    }
}
