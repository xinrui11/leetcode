package other;

/**
 * 回溯法---集合所有的子集
 */
public class Subset {

    private static int[] s = {1,2,3,4,5,6,7,8};
    private static int n = s.length;
    private static int[] x = new int[n];

    public static void main(String[] args){
        all_subset("all");
    }

    /**
     * 输出集合的子集 
     * @param limit  决定选出特定条件的子集 
     * 注：all为所有子集,num为限定元素数量的子集, 
     *    sp为限定元素奇偶性相同，且和小于8。 
     */
    public static void all_subset(String limit){
        switch(limit){
            case "all":backtrack(0);break;
            case "num":backtrack1(0);break;
            case "sp":backtrack2(0);break;
        }
    }


    /**
     * 回溯法求集合的所有子集，依次递归 
     * 注：是否回溯的条件为精髓 
     * @param t
     */
    private static void backtrack(int t){
        if(t >= n)
            output(x);
        else
            for (int i = 0; i <= 1; i++) {
                x[t] = i;
                backtrack(t+1);
            }

    }

    /**
     * 回溯法求集合的所有(元素个数小于4)的子集，依次递归 
     * @param t
     */
    private static void backtrack1(int t){
        if(t >= n)
            output(x);
        else
            for (int i = 0; i <= 1; i++) {
                x[t] = i;
                if(count(x, t) < 4)
                    backtrack1(t+1);
            }

    }

    /**
     * (剪枝) 
     * 限制条件：子集元素小于4,判断0~t之间已被选中的元素个数， 
     *        因为此时t之后的元素还未被递归,即决定之后的元素 
     *        是否应该被递归调用 
     * @param x
     * @param t
     * @return
     */
    private static int count(int[] x, int t) {
        int num = 0;
        for (int i = 0; i <= t; i++) {
            if(x[i] == 1){
                num++;
            }
        }
        return num;
    }

    /**
     * 回溯法求集合中元素奇偶性相同，且和小于8的子集,依次递归 
     * @param t
     */
    private static void backtrack2(int t){
        if(t >= n)
            output(x);
        else
            for (int i = 0; i <= 1; i++) {
                x[t] = i;
                if(legal(x, t))
                    backtrack2(t+1);
            }

    }

    /**
     * 对子集中元素奇偶性进行判断，还需元素的数组和小于8 
     * @param x
     * @param t
     * @return
     */
    private static boolean legal(int[] x, int t) {
        boolean bRet = true;   //判断是否需要剪枝  
        int part = 0;  //奇偶性判断的基准  

        for (int i = 0; i <= t; i++) {  //选择第一个元素作为奇偶性判断的基准  
            if(x[i] == 1){
                part = i;
                break;
            }
        }

        for (int i = 0; i <= t; i++) {
            if(x[i] == 1){
                bRet &= ((s[part] - s[i]) % 2 == 0);
            }

        }

        int sum = 0;
        for(int i = 0; i <= t; i++){
            if(x[i] == 1)
                sum += s[i];
        }
        bRet &= (sum < 8);

        return bRet;
    }


    /**
     * 子集输出函数 
     * @param x
     */
    private static void output(int[] x) {
        for (int i = 0; i < x.length; i++) {
            if(x[i] == 1){
                System.out.print(s[i]);
            }
        }
        System.out.println();
    }

}  