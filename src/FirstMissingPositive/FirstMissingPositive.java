package FirstMissingPositive;

/**
 Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */

public class FirstMissingPositive {
    //The key here is to use swapping to keep constant space and also make use of the length of the array, which means there can be at most n positive integers.
    // So each time we encounter an valid integer, find its correct position and swap. Otherwise we continue.
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0){
            return 1;
        }
        int i = 0;
        //Pass 1, move every value to the position of its value
        while (i<nums.length){
            if(nums[i] <= 0 || nums[i] > nums.length || nums[i] == i + 1)
                i++;
            else if (nums[nums[i] - 1] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        i = 0;
        //Pass 2, find first location where the index doesn't match the value
        while(i<nums.length && i + 1 == nums[i]){
            i++;
        }
        return i+1;
    }

}
