package MaximumSubarray;

/**
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 翻译：寻找子数组的最大和
 */

public class MaximumSubarray {
    /**
     * 蛮简单的一道题目，定义两个变量一个是与当前元素相连的数组最大和，一个是所有的最大和即可
     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int max = nums[0];//所有的最大和
        int temp = nums[0];//连续数组的最大和
        for(int i = 1; i < nums.length; i++){
            //如果连续数组的最大和为负，则加上nums[i]后会更小，所以直接取nums[i]，否则累加，不用判断nums[i]的正负
            temp = temp > 0 ? temp + nums[i] : nums[i];
            if(max < temp){
                max = temp;
            }
        }
        return max;
    }

    /**
     * 或者使用DP也很清晰：maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i];
     */
    public int maxSubArrayDP(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
