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
    //my solution, TLE
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
                    if(nums[(ls1+le1+1)/2] == target){
                        le1 = (ls1+le1+1)/2;
                    } else if (nums[(ls1+le1+1)/2] < target){//this judge can replace with else
                        ls1 = (ls1+le1+1)/2;
                    }
                }
            } else if (le1 == 0){
                return new int[]{s,e};
            } else if(nums[le1] < target || target < nums[ls1]) {
                return new int[]{s,e};
            } else if(nums[le1] > target){
                if(nums[(ls1+le1+1)/2] >= target){
                    le1 = (ls1+le1+1)/2;
                } else {
                    ls1 = (ls1+le1+1)/2;
                }
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
                    if(nums[(ls1+le1+1)/2] == target){
                        ls1 = (ls1+le1+1)/2;
                    } else if(nums[(ls1+le1+1)/2] > target){
                        le1 = (ls1+le1+1)/2;
                    }
                }
            } else if (ls1 == nums.length - 1){
                return new int[]{s,e};
            } else if (nums[ls1] > target || nums[le1] < target){
                return new int[]{s,e};
            } else if (nums[ls1] < target){
                if(nums[(ls1+le1+1)/2] <= target){
                    ls1 = (ls1+le1+1)/2;
                } else {
                    le1 = (ls1+le1+1)/2;
                }
            }
        }
        return new int[]{s,e};
    }

    //the best solution in discuss
    public int[] searchRange2(int[] nums, int target) {
        int s = -1;
        int e = -1;
        if(nums.length == 0)
            return new int[]{s,e};
        int ls = 0;
        int le = nums.length - 1;
        while(ls<le){
            int mid = (ls + le)/2;
            if(nums[mid] < target) ls = mid + 1;
            else le = mid;
        }
        if(nums[ls] == target)
            s = ls;
        else
            return new int[]{s,e};
        le = nums.length - 1;
        while(ls<le){
            int mid = (ls + le)/2 + 1;
            if(nums[mid] > target) le = mid - 1;
            else ls = mid;
        }
        e = ls;
        return new int[]{s,e};
    }
    //this is the full explanation
    /**
     The problem can be simply broken down as two binary searches for the begining and end of the range, respectively:

     First let's find the left boundary of the range. We initialize the range to [i=0, j=n-1]. In each step, calculate the middle element [mid = (i+j)/2].
     Now according to the relative value of A[mid] to target, there are three possibilities:

     If A[mid] < target, then the range must begins on the right of mid (hence i = mid+1 for the next iteration)
     If A[mid] > target, it means the range must begins on the left of mid (j = mid-1)
     If A[mid] = target, then the range must begins on the left of or at mid (j= mid)
     Since we would move the search range to the same side for case 2 and 3, we might as well merge them as one single case so that less code is needed:

     2*. If A[mid] >= target, j = mid;

     Surprisingly, 1 and 2* are the only logic you need to put in loop while (i < j). When the while loop terminates, the value of i/j is where the start of the range is. Why?

     No matter what the sequence originally is, as we narrow down the search range, eventually we will be at a situation where there are only two elements in the search range.
     Suppose our target is 5, then we have only 7 possible cases:

     case 1: [5 7] (A[i] = target < A[j])
     case 2: [5 3] (A[i] = target > A[j])
     case 3: [5 5] (A[i] = target = A[j])
     case 4: [3 5] (A[j] = target > A[i])
     case 5: [3 7] (A[i] < target < A[j])
     case 6: [3 4] (A[i] < A[j] < target)
     case 7: [6 7] (target < A[i] < A[j])
     For case 1, 2 and 3, if we follow the above rule, since mid = i => A[mid] = target in these cases,
     then we would set j = mid. Now the loop terminates and i and j both point to the first 5.

     For case 4, since A[mid] < target, then set i = mid+1. The loop terminates and both i and j point to 5.

     For all other cases, by the time the loop terminates, A[i] is not equal to 5. So we can easily know 5 is not in the sequence if the comparison fails.

     In conclusion, when the loop terminates, if A[i]==target, then i is the left boundary of the range; otherwise, just return -1;

     For the right of the range, we can use a similar idea. Again we can come up with several rules:

     If A[mid] > target, then the range must begins on the left of mid (j = mid-1)
     If A[mid] < target, then the range must begins on the right of mid (hence i = mid+1 for the next iteration)
     If A[mid] = target, then the range must begins on the right of or at mid (i= mid)
     Again, we can merge condition 2 and 3 into:

     2* If A[mid] <= target, then i = mid;
     However, the terminate condition on longer works this time. Consider the following case:

     [5 7], target = 5
     Now A[mid] = 5, then according to rule 2, we set i = mid. This practically does nothing because i is already equal to mid. As a result, the search range is not moved at all!

     The solution is by using a small trick: instead of calculating mid as mid = (i+j)/2, we now do:

     mid = (i+j)/2+1
     Why does this trick work? When we use mid = (i+j)/2, the mid is rounded to the lowest integer. In other words, mid is always biased towards the left.
     This means we could have i == mid when j - i == mid, but we NEVER have j == mid. So in order to keep the search range moving, you must make sure the new i is set to something different than mid,
     otherwise we are at the risk that i gets stuck. But for the new j, it is okay if we set it to mid, since it was not equal to mid anyways.
     Our two rules in search of the left boundary happen to satisfy these requirements, so it works perfectly in that situation. Similarly, when we search for the right boundary,
     we must make sure i won't get stuck when we set the new i to i = mid. The easiest way to achieve this is by making mid biased to the right, i.e. mid = (i+j)/2+1.
     */

}
