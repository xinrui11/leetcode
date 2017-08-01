package GenerateParentheses;

import junit.framework.TestCase;
import org.junit.Test;

public class GenerateParenthesesTest extends TestCase {
    @Test
    public void testgenerateParenthesis() throws Exception {
        GenerateParentheses g = new GenerateParentheses();
        System.out.println(g.generateParenthesis(4));
        System.out.println(g.generateParenthesis(3));
        System.out.println(g.generateParenthesis(2));
        System.out.println(g.generateParenthesis(1));

        System.out.println(g.generateParenthesisDP(3));
    }

}