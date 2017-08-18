package FirstMissingPositive;

/**
 Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0){
            return 1;
        }
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
                if(res == i - 1){
                    res = i;
                }
                continue;
            } else {
                if(nums[i]<nums[i - 1]){
                    if(nums[i - 1] - nums[i] == 1){
                        int temp = nums[i - 1];
                        nums[i - 1] = nums[i];
                        nums[i] = temp;
                        res = i;
                    } else {
                        res = i - 1;
                    }
                } else {
                    if(nums[i] - nums[i - 1] == 1){
                        res = i;
                    } else {
                        res = i - 1;
                    }
                }
            }
        }
        return nums[res] + 1;
    }
}
