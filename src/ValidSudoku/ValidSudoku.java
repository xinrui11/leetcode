package ValidSudoku;

import java.util.HashSet;
import java.util.Set;

/**
 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


 A partially filled sudoku which is valid.

 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */

public class ValidSudoku {
    //my solution,accepted,beat 77%
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9){
            return false;
        }
        Set<Character> sc = new HashSet<>();
        Set<Character> sc2 = new HashSet<>();
        for(int i = 0;i<9;i++){
            for(int j = 0; j < 9;j++){
                if(board[i][j] != '.'){
                    if(sc.contains(board[i][j]))
                        return false;
                    else
                        sc.add(board[i][j]);
                }
                if(board[j][i] != '.'){
                    if(sc2.contains(board[j][i]))
                        return false;
                    else
                        sc2.add(board[j][i]);
                }
            }
            sc.clear();
            sc2.clear();
        }
        for(int i = 1;i<=3;i++){
            for(int m = 1;m <=3;m++){
                for(int j = i*3 - 3;j<i*3;j++){
                    for(int n = m*3-3;n<m*3;n++){
                        if(board[j][n] == '.')
                            continue;
                        if(sc.contains(board[j][n]))
                            return false;
                        else
                            sc.add(board[j][n]);
                    }
                }
                sc.clear();
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }

    //this is the best
    /**
     Collect the set of things we see, encoded as strings. For example:

     '4' in row 7 is encoded as "(4)7".
     '4' in column 7 is encoded as "7(4)".
     '4' in the top-right block is encoded as "0(4)2".
     Scream false if we ever fail to add something because it was already added (i.e., seen before).
     */
    public boolean isValidSudoku3(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";//this is necessary,otherwise '5' in row 5 or column 5 is same
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }

}
