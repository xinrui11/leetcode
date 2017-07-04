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
        String re = new String();///1
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
}
