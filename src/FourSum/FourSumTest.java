package FourSum;

import junit.framework.TestCase;
import org.junit.Test;

public class FourSumTest extends TestCase {
    @Test
    public void testfourSum() throws Exception {
        FourSum f = new FourSum();
        System.out.println(f.fourSum(new int[]{1, 0, -1, 0, -2, 2},0));
        System.out.println(f.fourSum2(new int[]{1, 0, -1, 0, -2, 2},0));

        System.out.println(f.fourSum(new int[]{-1,-5,-5,-3,2,5,0,4},-7));
        System.out.println(f.fourSum2(new int[]{-1,-5,-5,-3,2,5,0,4},-7));
    }

}