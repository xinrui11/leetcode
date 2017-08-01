package GenerateParentheses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
 ]
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateList(res, 2*n, 0, 0, "");
        return res;
    }

    void generateList( List<String> res, int count, int startCount,int endCount, String temp){
        if(startCount+endCount == count){
            res.add(temp);
            return;
        }
        if(startCount<count/2){
            generateList(res,count,startCount+1,endCount, temp+"(");
            //! generateList(res,count,++startCount,endCount, temp+"(");this is wrong
        }
        if(endCount<startCount){
            generateList(res,count,startCount,++endCount, temp+")");
        }
    }

    /**
      DP solution

     f(0): ""

     f(1): "("f(0)")"

     f(2): "("f(0)")"f(1), "("f(1)")"

     f(3): "("f(0)")"f(2), "("f(1)")"f(1), "("f(2)")"

     So f(n) = "("f(0)")"f(n-1) , "("f(1)")"f(n-2) "("f(2)")"f(n-3) ... "("f(i)")"f(n-1-i) ... "(f(n-1)")"
     */
    public List<String> generateParenthesisDP(int n)
    {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));
        for (int i = 1; i <= n; ++i)
        {
            final List<String> list = new ArrayList<>();
            for (int j = 0; j < i; ++j)
            {
                for (final String first : lists.get(j))
                {
                    for (final String second : lists.get(i - 1 - j))
                    {
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            lists.add(list);
        }
        return lists.get(lists.size() - 1);
    }

    //DFS solution
    public List<String> generateParenthesisDFS(int n) {
        List<String> list = new ArrayList<String>();
        generateOneByOne("", list, n, n);
        return list;
    }
    void generateOneByOne(String sublist, List<String> list, int left, int right){
        if(left > right){
            return;
        }
        if(left > 0){
            generateOneByOne( sublist + "(" , list, left-1, right);
        }
        if(right > 0){
            generateOneByOne( sublist + ")" , list, left, right-1);
        }
        if(left == 0 && right == 0){
            list.add(sublist);
            return;
        }
    }

}
