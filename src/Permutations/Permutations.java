package Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
     [1,2,3],
     [1,3,2],
     [2,1,3],
     [2,3,1],
     [3,1,2],
     [3,2,1]
 ]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, new ArrayList<>(), res);
        return res;
    }

    private void permute(int[] nums, List<Integer> temp, List<List<Integer>> res){
        if(nums.length - temp.size() == 1){
            for(int num : nums){
                if(temp.contains(num))
                    continue;
                List<Integer> copy = new ArrayList<>(temp);
                copy.add(num);
                res.add(copy);
            }
        } else {
            for(int num : nums){
                if(temp.contains(num))
                    continue;
                temp.add(num);
                List<Integer> copy = new ArrayList<>(temp);
                permute(nums, copy, res);
            }
        }
    }
}
