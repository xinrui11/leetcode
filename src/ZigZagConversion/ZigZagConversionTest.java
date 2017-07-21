package ZigZagConversion;

import junit.framework.TestCase;
import org.junit.Test;

public class ZigZagConversionTest extends TestCase {
    @Test
    public void testconvert() throws Exception {
        ZigZagConversion z = new ZigZagConversion();
        String s = "PAYPALISHIRING";
        System.out.println("input is :" + s);
        System.out.println("out is :" + z.convert(s, 3));

    }

}