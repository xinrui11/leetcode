package ValidSudoku;

import junit.framework.TestCase;
import org.junit.Test;

public class ValidSudokuTest extends TestCase {
    @Test
    public void testisValidSudoku() throws Exception {
        ValidSudoku v = new ValidSudoku();
        String[] testStr = new String[]{
                "..5.....6","....14...",".........",".....92..","5....2...",".......3.","...54....","3.....42.","...27.6.."
        };
        char[][] test = StringToChar(testStr);
        System.out.println(v.isValidSudoku(test));
    }

    private char[][] StringToChar(String[] testStr){
        char[][] test = new char[testStr.length][testStr.length];
        for(int i = 0;i < 9;i++){
            test[i] = testStr[i].toCharArray();
        }
        return test;
    }
}