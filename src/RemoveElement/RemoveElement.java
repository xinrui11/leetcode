package RemoveElement;

import java.util.Arrays;

/**
 Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveElement {
    //my solution, is stupid
    public int removeElement(int[] nums, int val) {
        if(nums == null){
            return 0;
        }
        int length = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == val){
                int start = i;
                while(i < nums.length && nums[i] == val){
                    i++;
                    length--;
                }
                for(int j = start;i < nums.length && j < i;j++,i++){
                    nums[j] = nums[i];
                }
                return length;
            }
        }
        return length;
    }

    //formal solution
    public int removeElement2(int[] nums, int val) {//this solution is nice
        int i = 0;
        for(int temp : nums){
            if(temp != val){
                nums[i] = temp;
                i++;
            }
        }
        return i;
    }

    public int removeElement3(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}
