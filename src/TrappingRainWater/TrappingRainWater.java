package TrappingRainWater;

/**
 Given n non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

public class TrappingRainWater {
    //my solution, accepted,but only beat 3%
    public int trap(int[] height) {
        int[] d = new int[height.length];
        for(int i = 1; i < height.length; i++){
            int j = i - 1;
            int heightLeft = 0;
            while(j >= 0){
                if(height[j] > heightLeft){
                    heightLeft = height[j];
                }
                j--;
            }
            if(heightLeft > 0){
                int heightRight = 0;
                j = i + 1;
                while(j < height.length){
                    if(height[j] > heightRight){
                        heightRight = height[j];
                    }
                    if(heightRight > heightLeft){
                        break;
                    }
                    j++;
                }
                if(Math.min(heightLeft, heightRight) - height[i] > 0){
                    d[i] = Math.min(heightLeft, heightRight) - height[i];
                }
            }
        }
        int res = 0;
        for(int t : d){
            res += t;
        }
        return res;
    }

    public int trapDP(int[] height) {
        if(height == null || height.length < 2){
            return 0;
        }
        int len = height.length;
        int[] maxLeft = new int[len];
        maxLeft[0] = height[0];
        for(int i = 1; i<len; i++){
            maxLeft[i] = Math.max(maxLeft[i-1],height[i]);
        }
        int[] maxRight = new int[len];
        maxRight[len-1] = height[len-1];
        for(int i = len - 2;i>=0;i--){
            maxRight[i] = Math.max(maxRight[i+1],height[i]);
        }
        int res = 0;
        for(int i = 1; i<height.length;i++){
            int min = Math.min(maxLeft[i],maxRight[i]);
            if(min > height[i]){//this is useless,It doesn't make any sense
                res = res + min - height[i];
            }
        }
        return res;
    }

}
