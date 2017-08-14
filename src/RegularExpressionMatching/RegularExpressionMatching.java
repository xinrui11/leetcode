package RegularExpressionMatching;

/**
 Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") ? false
 isMatch("aa","aa") ? true
 isMatch("aaa","aa") ? false
 isMatch("aa", "a*") ? true
 isMatch("aa", ".*") ? true
 isMatch("ab", ".*") ? true
 isMatch("aab", "c*a*b") ? true
 */
public class RegularExpressionMatching {
    /**
     This Solution use 2D DP. beat 90% solutions, very simple.

     Here are some conditions to figure out, then the logic can be very straightforward.

     1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
     2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
     3, If p.charAt(j) == '*':
     here are two sub conditions:
     1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
     2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
     dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
     or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
     or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            dp[0][i+1] = p.charAt(i) == '*' && dp[0][i-1];
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*' && j-1 >= 0 ) {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    //this question is really hard,after a long time to understand,I write my solution below
    public boolean isMatchMY(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        int lengths = s.length(),lengthp = p.length();
        boolean[][] d = new boolean[lengths + 1][lengthp + 1];
        d[0][0] = true;
        for(int i = 1; i < lengthp; i++){//match empty
            d[0][i + 1] = p.charAt(i) == '*' && d[0][i - 1];
        }
        char cs,ps;
        for(int i = 0; i < lengths; i++){
            cs = s.charAt(i);
            for(int j = 0; j < lengthp; j++){
                ps = p.charAt(j);
                if(ps == '.' || cs == ps){
                    d[i+1][j+1] = d[i][j];
                }
                if(ps == '*' && j - 1 >=0) {
                    if(p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)){
                        d[i+1][j+1] = d[i+1][j] || d[i][j+1] || d[i+1][j-1];
                    } else if(p.charAt(j - 1) != s.charAt(i)){
                        d[i+1][j+1] = d[i+1][j-1];
                    }
                }
            }
        }
        return d[lengths][lengthp];
    }
}
