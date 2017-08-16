package SudokuSolver;

import java.util.HashSet;
import java.util.Set;

/**
 Write a program to solve a Sudoku puzzle by filling the empty cells.

 Empty cells are indicated by the character '.'.

 You may assume that there will be only one unique solution.
 */

public class SudokuSolver {
    //my first solution,have bugs,some situation is not consider
    public void solveSudoku(char[][] board) {
        Set<Character> sc = new HashSet<>();
        char[] all = new char[]{'1','2','3','4','5','6','7','8','9'};
        for(int i = 0;i < 9; i++){
            for(int j = 0;j < 9; j++){
                if(board[i][j] != '.'){
                    continue;
                }
                for(int m = 0;m < 9; m++){
                    add(board[i][m], sc);
                    add(board[m][j], sc);
                    add(board[i/3*3 + m/3][j/3*3 + m%3], sc);
                }
                char res = vaild(all, sc);
                if(res!='.'){
                    board[i][j] = res;
                    i = 0;
                    sc.clear();
                    break;
                }
                sc.clear();
            }
        }
    }

    private void add(char c, Set<Character> sc){
        if(c != '.'){
            sc.add(c);
        }
    }

    private char vaild(char[] all, Set<Character> sc){
        if(sc.size() == 8){
            for(char a : all){
                if(!sc.contains(a)){
                    return a;
                }
            }
        }
        return '.';
    }

    //second solution, backtracking, accepted, The time complexity should be 9 ^ m (m represents the number of blanks to be filled in)
    public void solveSudoku2(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        for(int i = 0;i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    continue;
                }
                for(char a = '1'; a <= '9'; a++){
                    if(isVaild(board ,i ,j, a)){
                        board[i][j] = a;
                        if(solve(board)){
                           return true;
                        } else {
                            board[i][j] = '.';
                        }
                    }
                }
                return false;//backtracking
            }
        }
        return true;//board is all num
    }

    private boolean isVaild(char[][] board, int i, int j, char a){
        for(int m = 0;m < 9; m++){
            if(board[i][m] != '.' && board[i][m] == a)
                return false;
            if(board[m][j] != '.' && board[m][j] == a)
                return false;
            if(board[i/3*3 + m/3][j/3*3 + m%3] != '.' && board[i/3*3 + m/3][j/3*3 + m%3] == a)
                return false;
        }
        return true;
    }

}
