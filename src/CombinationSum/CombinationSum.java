package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
     [7],
     [2, 2, 3]
 ]
 */

public class CombinationSum {
    //my solution, backtracking, beat 65%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        validSum(res, new ArrayList<>(), candidates, target, 0);
        return  res;
    }

    private void validSum(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target,int start){
        for(int i = start; i < candidates.length; i++){
            int sum = sum(temp);
            if(sum + candidates[i] == target){
                temp.add(candidates[i]);
                res.add(new ArrayList<>(temp));//notice here
                temp.remove(temp.size()-1);
                return;
            } else if(sum + candidates[i] < target){
                temp.add(candidates[i]);
                validSum(res, temp, candidates, target,i);
                temp.remove(temp.size()-1);
            } else {
                return;
            }
        }
    }

    private int sum(List<Integer> res){
        int sum = 0;
        for(Integer t : res){
            sum += t;
        }
        return sum;
    }

    //a good solution in discuss,use remain to replace the judge
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
