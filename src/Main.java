import leetCode.ReverseInteger;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Date());

        ReverseInteger r = new ReverseInteger();
        int input = 214567898;
        System.out.println("input:" + input);
        System.out.println("output:" + r.reverse(input));
    }
}
