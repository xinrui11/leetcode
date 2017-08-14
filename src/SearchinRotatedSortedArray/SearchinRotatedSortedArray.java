package SearchinRotatedSortedArray;

/**
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int s = 0,e = nums.length - 1;
        while(s<=e){
            int middle = (s+e)/2;
            if(nums[middle] == target)
                return middle;
            if(nums[s] <= nums[middle]){//do not forget the '='
                if(nums[s] <= target && target <= nums[middle]){
                    e = middle - 1;
                } else {
                    s = middle + 1;
                }
            } else {
                if(nums[middle] <= target && target <= nums[e]){
                    s = middle + 1;
                } else {
                    e = middle - 1;
                }
            }
        }
        return -1;
    }

}
