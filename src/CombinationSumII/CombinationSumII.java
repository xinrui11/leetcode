package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given a collection of candidate numbers (C) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
     [1, 7],
     [1, 2, 5],
     [2, 6],
     [1, 1, 6]
 ]
 */

public class CombinationSumII {
    //my solution ,accepted, only beat 5%
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> temp, int[] candidates, int remain, int start){
        if(remain == 0){
            if(!isRepeat(res, temp))
                res.add(new ArrayList<>(temp));
        } else if(remain > 0){
            for(int i = start; i < candidates.length;i++){
                temp.add(candidates[i]);
                backtracking(res, temp, candidates, remain - candidates[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isRepeat(List<List<Integer>> res, List<Integer> temp){
        if(res.size() == 0)
            return false;
        for(List<Integer> t : res){
            int size = t.size();
            if(size != temp.size()){
                continue;
            }
            boolean flag = true;
            for(int i = 0; i<size;i++){
                if(!t.get(i).equals(temp.get(i))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }

    //A DFS solution in discuss
    public List<List<Integer>> combinationSum22(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs_com(cand, 0, target, path, res);
        return res;
    }
    void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        if (target < 0) return;
        for (int i = cur; i < cand.length; i++) {
            if (i > cur && cand[i] == cand[i - 1]) continue;//this is the key
            path.add(path.size(), cand[i]);
            dfs_com(cand, i + 1, target - cand[i], path, res);
            path.remove(path.size() - 1);
        }
    }

}
