package NextPermutation;

import java.util.Arrays;

/**
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */

public class NextPermutation {
    //accepted
    public void nextPermutation(int[] nums) {
        if(nums.length < 2){
            return;
        }
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i - 1] < nums[i]){
                int index = i;
                for(int j = i + 1;j < nums.length; j++){
                    if(nums[j] > nums[i - 1] && nums[j] < nums[index]){
                        index = j;
                    }
                }
                int temp = nums[i - 1];
                nums[i - 1] = nums[index];
                nums[index] = temp;
                //reverse left
                for(int n = i; n < nums.length - 1; n++){
                    int min = n;
                    for(int m = n+1; m < nums.length; m++){
                        if(nums[m] < nums[min]){
                            min = m;
                        }
                    }
                    if(min != n){
                        temp = nums[n];
                        nums[n] = nums[min];
                        nums[min] = temp;
                    }
                }
                return;
            }
        }
        Arrays.sort(nums);
    }

    //Official solution,is similar to mine
    public void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
