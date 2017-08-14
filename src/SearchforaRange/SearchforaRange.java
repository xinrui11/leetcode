package SearchforaRange;

/**
 Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        int s = -1,e = -1;
        int ls1 = 0,le1 = nums.length - 1;
        while(ls1<=le1){
            if(target == nums[le1]){
                if(le1 == 0){
                    s = le1;
                    break;
                } else if(nums[le1 - 1] < target) {
                    s = le1;
                    break;
                } else {
                    if(nums[(ls1+le1)/2] == target){
                        le1 = (ls1+le1)/2;
                    } else if (nums[(ls1+le1)/2] < target){//this judge can replace with else
                        ls1 = (ls1+le1)/2;
                    }
                }
            } else if(nums[le1] < target) {
                ls1 = (ls1+le1)/2;
            } else if(nums[le1] > target){
                le1 = (ls1+le1)/2;
            }
        }
        ls1 = 0;
        le1 = nums.length - 1;
        while(ls1<=le1){
            if(target == nums[ls1]){
                if(ls1 == nums.length - 1){
                    e = ls1;
                    break;
                } else if (nums[ls1 + 1] > target){
                    e = ls1;
                    break;
                } else {
                    if(nums[(ls1+le1)/2] == target){
                        ls1 = (ls1+le1)/2;
                    } else if(nums[(ls1+le1)/2] > target){
                        le1 = (ls1+le1)/2;
                    }
                }
            } else if (nums[ls1] < target){
                ls1 = (ls1+le1)/2;
            } else if (nums[ls1] > target){
                break;
            }
        }
        if(s != -1 && e == -1){
            e = s;
        }
        return new int[]{s,e};
    }

}
