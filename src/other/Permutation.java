package other;

/**
 * 回溯法---集合所有的排列
 */
public class Permutation {
    private static int[] s = {1,2,3,4,5,6,7,8};
    private static int n = s.length;
    private static int[] x = new int[n];

    public static void main(String[] args){
        long now = System.currentTimeMillis();
        all_permutation("all");
        System.out.println("耗时："+(System.currentTimeMillis() - now));
    }

    /**
     * 输出集合的排列
     * @param limit  决定选出特定条件的子集
     * 注：all为所有排列,sp为限定元素奇偶性相间。
     */
    public static void all_permutation(String limit){
        switch(limit){
            case "all":backtrack(0);break;
            case "sp":backtrack1(0);break;
        }
    }


    /**
     * 回溯法求集合的所有排列，依次递归
     * 注：是否回溯的条件为精髓
     * @param t
     */
    private static void backtrack(int t){
        if(t >= n)
            output(s);
        else
            for (int i = t; i < n; i++) {
                /*if(i == t){
                    backtrack(t+1);
                    continue;
                }*/
                swap(i, t, s);
                backtrack(t+1);
                swap(i, t, s);
            }

    }

    /**
     * 回溯法求集合中元素奇偶性相间的排列,依次递归
     * @param t
     */
    private static void backtrack1(int t){
        if(t >= n)
            output(s);
        else
            for (int i = t; i < n; i++) {
                swap(i, t, s);
                if(legal(x, t))
                    backtrack1(t+1);
                swap(i, t, s);
            }

    }

    /**
     * 对子集中元素奇偶性进行判断
     * @param x
     * @param t
     * @return
     */
    private static boolean legal(int[] x, int t) {
        boolean bRet = true;   //判断是否需要剪枝

        //奇偶相间,即每隔一个数判断奇偶相同
        for (int i = 0; i < t - 2; i++) {
            bRet &= ((s[i+2] - s[i]) % 2 == 0);
        }

        return bRet;
    }


    /**
     * 元素交换
     * @param i
     * @param j
     */
    private static void swap(int i, int j,int[] s) {
        int tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    /**
     * 子集输出函数
     * @param s
     */
    private static void output(int[] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }
        System.out.println();
    }
}
