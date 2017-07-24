package StringToInteger;

import org.junit.Test;

public class StringToIntegerTest {
    @Test
    public void testmyAtoi2() throws Exception {
        StringToInteger s = new StringToInteger();
        System.out.print("input:  -0012a42;output:");
        System.out.println(s.myAtoi2("  -0012a42"));
        System.out.print("input:1;output:");
        System.out.println(s.myAtoi2("1"));
    }

}