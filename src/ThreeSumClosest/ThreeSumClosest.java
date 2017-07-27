package ThreeSumClosest;

import java.util.Arrays;

/**
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
 target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return target;
        }
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2],m,e,sum;
        for(int i = 0;i < nums.length - 2; i++){
            m = i + 1;e = nums.length - 1;
            if(i > 1 && nums[i] == nums[i - 1]){//skip same value to improve speed
                continue;
            }
            while(m < e){
                sum = nums[i] + nums[m] + nums[e];
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if(sum == target){
                    return target;
                } else if (sum > target){
                    e--;
                    while(m < e && nums[e] == nums[e + 1]){//skip same value to improve speed
                        e--;
                    }
                } else if (sum < target){
                    m++;
                    while(m < e && nums[m] == nums[m - 1]){//skip same value to improve speed
                        m++;
                    }
                }
            }
        }
        return res;
    }
}
