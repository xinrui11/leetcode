package TwoSum;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class TwoSumTest extends TestCase {
    @Test
    public void testTwoSumMySolution() throws Exception {
        TwoSum t = new TwoSum();
        System.out.print((new Date()).getTime());
        System.out.print("input:[1,2,3],5;output:");
        System.out.print(Arrays.toString(t.twoSumMySolution(new int[]{1,2,3},5)));
        System.out.print((new Date()).getTime());
    }

    @Test
    public void testTwoSumFast() throws Exception {
        TwoSum t = new TwoSum();
        System.out.print((new Date()).getTime());
        System.out.print("input:[1,2,3],5;output:");
        System.out.print(Arrays.toString(t.twoSumFast(new int[]{1,2,3},5)));
        System.out.print((new Date()).getTime());
    }

}