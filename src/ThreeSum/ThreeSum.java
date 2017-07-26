package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
     [-1, 0, 1],
     [-1, -1, 2]
 ]
 */

public class ThreeSum {
    //even thought this is corrent,but it could be Time Limit Exceeded
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList();
        Arrays.sort(nums);
        if(nums[0]>0 || nums[nums.length-1]<0) return new ArrayList();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int medium = 0;
        for(int i = 0;i < nums.length && nums[i]<=0;i++){
            for(int j = nums.length - 1;j > i + 1 && nums[j]>=0; j--){
                if(nums[i] + nums[j] >= 0){
                    medium = j - 1;
                    while((nums[medium] > 0) || (nums[i] + nums[medium] + nums[j] > 0 && i < medium)){
                        medium--;
                    }
                } else {
                    medium = i + 1;
                    while((nums[medium] < 0) || (nums[i] + nums[medium] + nums[j] < 0 && medium<j)){
                        medium++;
                    }
                }
                if(nums[i] + nums[medium] + nums[j] == 0){
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[i]);
                    temp.add(nums[medium]);
                    temp.add(nums[j]);
                    if(!res.contains(temp)) res.add(temp);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {            // skip same result
                continue;
            }
            int second = i + 1,third = nums.length - 1;
            int target = -nums[i];
            while(second < third){
                if(nums[second] + nums[third] == target){
                    res.add(Arrays.asList(nums[i],nums[second],nums[third]));
                    second++;third--;
                    while(second < third && nums[third] == nums[third + 1]) third--;
                    while(second < third && nums[second] == nums[second - 1]) second++;
                }
                else if(nums[second] + nums[third] > target){
                    third--;
                }
                else if(nums[second] + nums[third] < target){
                    second++;
                }
            }
        }
        return res;
    }
}
