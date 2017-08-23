package MultiplyStrings;

/**
 Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

 Note:

 The length of both num1 and num2 is < 110.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {
    //my solution,TLE
    public String multiply(String num1, String num2) {
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        String res;
        if(num1Char.length > num2Char.length){
            res = mulTweString(num1Char, num2Char);
        } else {
            res = mulTweString(num2Char, num1Char);
        }
        return res;
    }

    private String mulTweString(char[] num1Char, char[] num2Char){
        String res = "";
        for(int i = num1Char.length - 1;i>=0;i--){
            int i1 = num1Char[i] - '0';
            for(int j = num2Char.length - 1;j>=0;j--){
                int i2 = num2Char[j] - '0';
                int sum = i1*i2;
                String sumStr = sum+"";
                if(sum > 0){
                    for(int k = 0;k<num1Char.length + num2Char.length - 2 - i - j;k++){
                        sumStr += "0";
                    }
                }
                //this process is not necessary do in every loop,we can store it,after loop,add them together
                if(res.length() > sumStr.length()){
                    res = addTweString(res, sumStr);
                } else {
                    res = addTweString(sumStr, res);
                }
            }
        }
        return res;
    }

    private String addTweString(String max, String min){
        String res = "";
        char[] maxArray = max.toCharArray();
        char[] minArray = min.toCharArray();
        boolean flag = false;
        for(int i = maxArray.length - 1;i>=0;i--){
            int mi = maxArray[i] - '0';
            if(flag) {
                mi += 1;
                flag = false;
            }
            if(minArray.length - maxArray.length + 1 + i - 1 >= 0){
                int ni = minArray[minArray.length - maxArray.length + 1 + i - 1] - '0';
                mi = mi + ni;
            }
            if(mi > 9){
                mi = mi - 10;
                flag = true;
            }
            res = mi + res;
        }
        if(flag){
            res = "1" + res;
        }
        return res;
    }

    //a solution in discuss
    public String multiply2(String num1, String num2) {
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        int[] sum = new int[num1Char.length + num2Char.length];
        for(int i = num1Char.length - 1;i>=0;i--) {
            int i1 = num1Char[i] - '0';
            for (int j = num2Char.length - 1; j >= 0; j--) {
                int i2 = num2Char[j] - '0';
                int mul = i1 * i2;
                int p1 = i+j,p2=p1+1;//this is the key,they have same digit
                mul = mul + sum[p2];
                sum[p2] = mul % 10;
                sum[p1] = sum[p1] + (mul / 10);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int s :sum){
            if(sb.length() == 0 && s == 0){
                continue;
            }
            sb.append(s);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
