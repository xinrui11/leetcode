package PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
     [1,1,2],
     [1,2,1],
     [2,1,1]
 ]
 */
public class PermutationsII {
    //my solution,TLE
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<Integer> numsList = new ArrayList<>();
        for(int i = 0; i < nums.length;i++){
            numsList.add(nums[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        recursive(res, new ArrayList<>(), numsList);
        return res;
    }
    private void recursive(List<List<Integer>> res, List<Integer> temp, List<Integer> numsList){
        if(numsList.size() == 0 && !res.contains(temp)){
            res.add(new ArrayList<>(temp));
        } else {
            for(int i = 0;i < numsList.size();i++){
                temp.add(numsList.get(i));
                numsList.remove(i);
                recursive(res, temp, numsList);
                numsList.add(i,temp.get(temp.size() - 1));
                temp.remove(temp.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        PermutationsII p = new PermutationsII();
        List<List<Integer>> res = p.permuteUnique2(nums);
        System.out.println(res);
    }

    //a solution in discuss,it's like question Permutations
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 && nums[i-1]==nums[i] && !used[i-1]) continue;//remove duplication
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}
