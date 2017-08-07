package DivideTwoIntegers;

import junit.framework.TestCase;

/**
 * Created by xinrui on 2017-8-6.
 */
public class DivideTwoIntegersTest extends TestCase {
    public void testDivide() throws Exception {
        DivideTwoIntegers d = new DivideTwoIntegers();
        System.out.println(d.divide(15,3));
        System.out.println(d.divide2(15,3));
        System.out.println(d.divide2(-2147483648,-1));

    }

}