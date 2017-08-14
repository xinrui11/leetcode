package SearchinRotatedSortedArray;

import junit.framework.TestCase;
import org.junit.Test;

public class SearchinRotatedSortedArrayTest extends TestCase {
    @Test
    public void testsearch() throws Exception {
        SearchinRotatedSortedArray s = new SearchinRotatedSortedArray();
        int[] nums = new int[]{4,5,6,7,0,1,2,3};
        System.out.println("input is : 4,5,6,7,0,1,2,3");
        System.out.println("target is : 4 " + " index is :" + s.search(nums, 4));
        System.out.println("target is : 7 " + " index is :" + s.search(nums, 7));
        System.out.println("target is : 2 " + " index is :" + s.search(nums, 2));
        int[] nums2 = new int[]{3,1};
        System.out.println("input is : 3,1");
        System.out.println("target is : 1 " + " index is :" + s.search(nums2, 1));
        int[] nums3 = new int[]{3,5,1};
        System.out.println("input is : 3,5,1");
        System.out.println("target is : 1 " + " index is :" + s.search(nums3, 1));
    }

}