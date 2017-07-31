package ValidParentheses;

import junit.framework.TestCase;
import org.junit.Test;

public class ValidParenthesesTest extends TestCase {
    @Test
    public void testisValid() throws Exception {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("{()}"));
        System.out.println(v.isValid("{(})"));
    }

}