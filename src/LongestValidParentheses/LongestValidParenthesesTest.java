package LongestValidParentheses;

import junit.framework.TestCase;
import org.junit.Test;

public class LongestValidParenthesesTest extends TestCase {
    @Test
    public void testlongestValidParentheses() throws Exception {
        LongestValidParentheses l = new LongestValidParentheses();
        System.out.println("input:))))())()()(()");
        System.out.println(l.longestValidParentheses("))))())()()(()")+" and auswer is :4");
        System.out.println("input:(((((((()()((((((((()())(((()");
        System.out.println(l.longestValidParentheses("(((((((()()((((((((()())(((()")+" and auswer is :6");
        System.out.println("input:)))))))))()())))))())(())())))))))(");
        System.out.println(l.longestValidParentheses(")))))))))()())))))())(())())))))))(")+" and auswer is :6");
    }

    public void testlongestValidParenthesesMYDP() throws Exception {
        LongestValidParentheses l = new LongestValidParentheses();
        System.out.println("input:))))())()()(()");
        System.out.println(l.longestValidParenthesesMYDP("))))())()()(()")+" and auswer is :4");
        System.out.println("input:(((((((()()((((((((()())(((()");
        System.out.println(l.longestValidParenthesesMYDP("(((((((()()((((((((()())(((()")+" and auswer is :6");
        System.out.println("input:)))))))))()())))))())(())())))))))(");
        System.out.println(l.longestValidParenthesesMYDP(")))))))))()())))))())(())())))))))(")+" and auswer is :6");
    }

}