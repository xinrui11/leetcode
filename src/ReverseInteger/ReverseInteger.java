package ReverseInteger;

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * click to show spoilers.
 * <p>
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * <p>
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * <p>
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * <p>
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * <p>
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    /**
     * 初步思路有两个，一是转为String，然后倒转，二是取余数
     * 2017-07-03
     */
    public int reverse(int x) {
        String s = String.valueOf(x);
        String re = new String();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                re = "-" + re;
            } else {
                re += s.charAt(i);
            }
        }
        try {
            return Integer.parseInt(re);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 网站上支持率最高的solution
     * Only 15 lines.
     * If overflow exists, the new result will not equal previous one.
     * No flags needed. No hard code like 0xf7777777 needed.
     * Sorry for my bad english.
     * 翻译：只有15行代码，如果出现了溢出，新的结果不会等于之前的结果，不需要状态判断，也不需要硬编码。
     * 基本思路是原数不断除以10，结果不断乘以10，正负数不需要考虑
     */
    public int reverseFast(int x) {
        int result = 0;
        while (x != 0){
            int tail = x % 10;
            int newResult = tail + result * 10;
            if(result != (newResult-tail)/10 ){
                return 0;
            }
            //x = (x - tail) / 10;//此计算放在判断后面，可以提高效率，整数相除会自动抹去小数，所以不用减去尾数
            x = x / 10;
            result = newResult;
        }
        return result;
    }
}
