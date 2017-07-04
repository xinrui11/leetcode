import ReverseInteger.ReverseInteger;
import TwoSum.TwoSum;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
       System.out.println(new Date());

        TwoSum t = new TwoSum();
        t.twoSumFast(new int[]{1,2,3},5);

        ReverseInteger r = new ReverseInteger();
        int input = 214567898;
        System.out.println("input:" + input);
        System.out.println("output:" + r.reverse(input));
    }
}
