package RemoveDuplicatesfromSortedArray;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int temp = nums[0];
        int length = 1;
        for(int i = 1; i < nums.length;i++){
            if(nums[i] != temp){
                for(int j = length; j < i; j++){
                    nums[j] = nums[i];
                }
                temp = nums[i];
                length++;
            }
        }
        return length;
    }

    //this is better solution
    public int removeDuplicates2(int[] A) {
        if (A.length==0) return 0;
        int j=0;
        for (int i=0; i<A.length; i++)
            if (A[i]!=A[j]) A[++j]=A[i];
        return ++j;
    }
}
