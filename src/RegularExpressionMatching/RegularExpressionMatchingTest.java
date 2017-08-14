package RegularExpressionMatching;

import junit.framework.TestCase;
import org.junit.Test;

public class RegularExpressionMatchingTest extends TestCase {
    @Test
    public void testisMatch() throws Exception {
        RegularExpressionMatching r = new RegularExpressionMatching();
        outPrint("aa","a*",r);
        outPrint("aa",".*",r);
        outPrint("ab",".*",r);
        outPrint("aab","c*a*b",r);
        outPrint("aaa","ab*ac*a",r);
    }

    private void outPrint(String i, String o, RegularExpressionMatching r){
        System.out.println("Input: "+i+"    " + o);
        System.out.println("Out: " + r.isMatch(i,o));
    }
}