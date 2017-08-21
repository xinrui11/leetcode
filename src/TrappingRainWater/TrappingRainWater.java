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

    /*public int trapDP(int[] height) {

    }*/
}
