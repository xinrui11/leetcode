package ReverseInteger;

import junit.framework.TestCase;
import org.junit.Test;

public class ReverseIntegerTest extends TestCase {
    @Test
    public void testReverse() throws Exception {
        ReverseInteger r = new ReverseInteger();
        System.out.print("input:123456789;output:");
        System.out.print(r.reverse(123456789));
        System.out.print("\ninput:-123456789;output:");
        System.out.print(r.reverse(-123456789));
        System.out.print("\ninput:-1234567898;output:");
        System.out.print(r.reverse(-1234567898));
    }

    @Test
    public void testReverseFast() throws Exception {
        ReverseInteger r = new ReverseInteger();
        System.out.print("input:123456789;output:");
        System.out.print(r.reverseFast(123456789));
        System.out.print("\ninput:-123456789;output:");
        System.out.print(r.reverseFast(-123456789));
        System.out.print("\ninput:-1234567898;output:");
        System.out.print(r.reverseFast(-1234567898));
    }

}