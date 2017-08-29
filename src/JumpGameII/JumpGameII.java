package JumpGameII;

/**
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 Note:
 You can assume that you can always reach the last index.
 */

public class JumpGameII {
    //The main idea is based on greedy.this is the easiest hard question I have met.
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        int res = 0,length = 0;
        for(int i = 0; i < nums.length;){
            if(length + nums[i] + 1 >= nums.length){
                return ++res;
            } else {
                int max = 0,index = i + 1;
                for(int j = i + 1; j <= i + nums[i];j++){
                    if(nums[j] + j - i > max){
                        max = nums[j] + j - i;
                        index = j;
                    }
                }
                res++;
                length = length + index - i;
                i = index;
            }
        }
        return res;
    }

    //A good solution in discuss,the idea is like mine,but it's better.
    /**
     * The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd],
     * curFarthest is the farthest point that all points in [curBegin, curEnd] can reach.
     * Once the current point reaches curEnd, then trigger another jump,
     * and set the new curEnd with curFarthest, then keep the above steps, as the following:
     */
    public int jump2(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
