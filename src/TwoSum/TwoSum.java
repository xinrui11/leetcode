package TwoSum;
/**
 * question
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 2017-06-29
 * 这道题目的关键是You may assume that each input would have exactly one solution
 * 你可以假设每个输入都有且仅有一组解
 */
public class TwoSum {
    /**
     * 暴力循环两遍，时间复杂度n的平方，空间复杂度1
     * @param nums Given array
     * @param target specific target
     * @return int[]
     */
    public int[] twoSumMySolution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("无解");
    }

    /**
     * 官方最优解法，说是只循环了一遍，但是使用了map，调用map的containsKey方法不也是循环吗
     * It only go through the list once.
     */
    public int[] twoSumFast(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            Integer diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            } else {
                map.put(nums[i],i);//这里把值放在key里，以便后边使用getkey方法获取value
            }
        }
        throw new IllegalArgumentException("无解");
    }
}
