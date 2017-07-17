package LongestPalindromicSubstring;

import junit.framework.TestCase;
import org.junit.Test;

public class LongestPalindromicSubstringTest extends TestCase {
    @Test
    public void testlongestPalindrome() throws Exception {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        String input = "asdqweewsdfewq";
        System.out.println("input is:" + input);
        System.out.println("out is:" + l.longestPalindrome(input));
    }

}