package NQueens;

import java.util.ArrayList;
import java.util.List;

/**
 The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:

 [
     [".Q..",  // Solution 1
     "...Q",
     "Q...",
     "..Q."],

     ["..Q.",  // Solution 2
     "Q...",
     "...Q",
     ".Q.."]
 ]
 */

public class NQueens {

    public static void main(String[] args){
        NQueens nQueens = new NQueens();
        List<List<String>> res = nQueens.solveNQueens(4);
        System.out.println(res);
        res = nQueens.solveNQueensSecond(4);
        System.out.print(res);
    }

    //My first solution,accepted,only beats 6.99% java submissions.
    //第一种解法，虽然通过了但是至击败了6.99%的java解法，直接使用List<String>代替解法，所以一种解法的List长度是N*N,
    //回溯上不是很复杂，但是判断函数略显复杂
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> solution = new ArrayList<>();
        //初始化
        for (int i = 0; i < n*n; i++) {
            solution.add(".");
        }
        solve(result,solution, n, 0);
        List<List<String>> res = new ArrayList<>();
        //生成需要的数据结构
        for(int i = 0; i < result.size(); i++){
            List<String> temp = new ArrayList<>();
            for (int l = 0; l < n; l++) {
                String s = "";
                for (int j = 0; j < n; j++) {
                    s = s + result.get(i).get(n*l+j);
                }
                temp.add(s);
            }
            res.add(temp);
        }
        return res;
    }

    private void solve(List<List<String>> result, List<String> solution, int n, int line){
        if(line == n){
            result.add(solution);
        }
        for (int j = 0; j < n && line < n; j++) {
            solution.set(line*n+j, "Q");
            if(isValid(solution, line , j, n)){
                solve(result, new ArrayList<>(solution), n, line + 1);
            }
            solution.set(line*n+j, ".");
        }
    }

    private boolean isValid(List<String> solution, int i, int j, int n){
        int count = 0;
        for (int m = 0; m < n; m++) {
            if(solution.get(m*n+j).equals("Q")){
                count++;
            }
        }
        if(count != 1){
            return false;
        }
        count = 0;
        for(int k = i,l = j; k >= 0&& k <n&&l>=0&&l<n;k++,l-- ){
            if(solution.get(k*n+l).equals("Q")){
                count++;
            }
        }
        if(count != 1){
            return false;
        }
        count = 0;
        for(int k = i,l = j; k >= 0&& k <n&&l>=0&&l<n;k--,l++ ){
            if(solution.get(k*n+l).equals("Q")){
                count++;
            }
        }
        if(count != 1){
            return false;
        }
        count = 0;
        for(int k = i,l = j; k >= 0&& k <n&&l>=0&&l<n;k--,l-- ){
            if(solution.get(k*n+l).equals("Q")){
                count++;
            }
        }
        if(count != 1){
            return false;
        }
        count = 0;
        for(int k = i,l = j; k >= 0&& k <n&&l>=0&&l<n;k++,l++ ){
            if(solution.get(k*n+l).equals("Q")){
                count++;
            }
        }
        if(count != 1){
            return false;
        }
        return true;
    }

    /**
     * 第二种解法，看了一些文章后写出的，核心思想是使用一维数组的下标表示横坐标（哪一行），而数组的值表示纵坐标（哪一列）
     * 这样无论是搜索还是判断都方便了一些，在leetcode网站上是击败了50%的java解法
     */
    public List<List<String>> solveNQueensSecond(int n) {
        List<List<String>> res = new ArrayList<>();
        solveSecond(res, new int[n], n, 0);
        return res;
    }

    private void solveSecond(List<List<String>> result, int[] solution, int n, int count){
        if(count == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String t = "";
                for (int j = 0; j < n; j++) {
                    if(j == solution[i]){
                        t+="Q";
                    } else {
                        t+=".";
                    }
                }
                temp.add(t);
            }
            result.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            solution[count] = i;
            if(isValidSecond(solution, count)){
                solveSecond(result, solution, n, count + 1);
            }
        }
    }

    private boolean isValidSecond(int[] solution, int n){
        for (int i = 0; i < n; i++) {
            if(solution[i] == solution[n] || Math.abs(solution[i] - solution[n]) == n - i)
                return false;
        }
        return true;
    }

}
;