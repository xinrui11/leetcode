package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note: The solution set must not contain duplicate quadruplets.

 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
     [-1,  0, 0, 1],
     [-2, -1, 1, 2],
     [-2,  0, 0, 2]
 ]
 */

public class FourSum {
    //recursive solution,but it will be Time Limit Exceeded
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        group(0, 0, nums ,res, new ArrayList<>(), target);
        return res;
    }

    private void group(int count,int j, int[] nums, List<List<Integer>> res,List<Integer> member, int target){
        if(count == 4){
            Collections.sort(member);
            if(!res.contains(member)){
                int sum = 0;
                for(Integer num : member){
                    sum += num;
                }
                if(sum == target){
                    res.add(member);
                }
            }
            return;
        }
        for(int i = j; i < nums.length; i++){
            List<Integer> memberCopy = new ArrayList<>();
            memberCopy.addAll(member);
            memberCopy.add(nums[i]);
            group(count + 1,i + 1, nums ,res, memberCopy, target);
        }
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int p = 0; p<nums.length-3; p++){
            if (p >= 1 && nums[p] == nums[p - 1]){
                continue;// skip same result
            }
            for (int i = p + 1; i < nums.length - 2; i++) {
                if (i > p + 1 && nums[i] == nums[i- 1]){
                    continue;// skip same result
                }
                int second = i + 1,third = nums.length - 1;
                int dValue = target-nums[i]-nums[p];
                while(second < third){
                    if(nums[second] + nums[third] == dValue){
                        res.add(Arrays.asList(nums[p], nums[i],nums[second],nums[third]));
                        second++;third--;
                        while(second < third && nums[third] == nums[third + 1]) third--;
                        while(second < third && nums[second] == nums[second - 1]) second++;
                    }
                    else if(nums[second] + nums[third] > dValue){
                        third--;
                    }
                    else if(nums[second] + nums[third] < dValue){
                        second++;
                    }
                }
            }
        }
        return res;
    }
}
