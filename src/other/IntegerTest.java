package other;

/**
 * 用于测试Integer
 */
public class IntegerTest {
    public static void main(String[] args){
        System.out.println("最大的整数：" + Integer.MAX_VALUE);
        System.out.println("最大的整数（二进制）：" + Integer.toBinaryString(Integer.MAX_VALUE)+","+Integer.toBinaryString(Integer.MAX_VALUE).length());
        System.out.println("最小的整数：" + Integer.MIN_VALUE);
        System.out.println("最小的整数（二进制）：" + Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println();
        System.out.println("最大的整数" + Integer.MAX_VALUE + "加一等于" + (Integer.MAX_VALUE + 1));
        System.out.println("最大的整数+1（二进制）：" + Integer.toBinaryString(Integer.MAX_VALUE+1));
        System.out.println("最大的整数+2（二进制）：" + Integer.toBinaryString(Integer.MAX_VALUE+2));
        System.out.println("最大的整数+最大的整数（二进制）：" + Integer.toBinaryString(Integer.MAX_VALUE+Integer.MAX_VALUE));
        System.out.println("最大的整数+最大的整数+2（二进制）：" + Integer.toBinaryString(Integer.MAX_VALUE+Integer.MAX_VALUE+1));
        System.out.println("最大的整数+最大的整数+2：" + (Integer.MAX_VALUE+Integer.MAX_VALUE+2));
    }
}
