package LongestPalindromicSubstring;

import junit.framework.TestCase;
import org.junit.Test;

public class LongestPalindromicSubstringTest extends TestCase {
    @Test
    public void testlongestPalindrome() throws Exception {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        String input = "asdfgfdsaaaa";
        System.out.println("input is:" + input);
        System.out.println("out is:" + l.longestPalindrome5(input));
        input = "c";
        System.out.println("input is:" + input);
        System.out.println("out is:" + l.longestPalindrome5(input));
    }

}