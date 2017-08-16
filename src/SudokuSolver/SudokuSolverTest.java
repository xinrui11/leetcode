package SudokuSolver;

import junit.framework.TestCase;
import org.junit.Test;

public class SudokuSolverTest extends TestCase {
    @Test
    public void testsolveSudoku() throws Exception {
        String[] testStr = new String[]{
                "..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."
        };
        char[][] test = StringToChar(testStr);
        SudokuSolver s = new SudokuSolver();
        s.solveSudoku(test);
    }

    private char[][] StringToChar(String[] testStr){
        char[][] test = new char[testStr.length][testStr.length];
        for(int i = 0;i < 9;i++){
            test[i] = testStr[i].toCharArray();
        }
        return test;
    }

}