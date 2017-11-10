package MedianofTwoSortedArrays;

import java.util.Arrays;

/**
 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
     nums1 = [1, 3]
     nums2 = [2]

 The median is 2.0

 Example 2:
     nums1 = [1, 2]
     nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */
public class MedianofTwoSortedArrays {
    //投机取巧的解法
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);
        double median;
        if(nums.length % 2 == 1){
            median = nums[(nums.length - 1) / 2];
        }else{
            median = (double)(nums[(nums.length - 1) / 2] + nums[(nums.length - 1) / 2 + 1])/2;
        }
        return median;
    }

    //官方解法，很复杂，附上连接：https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = iMin + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = iMax - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
