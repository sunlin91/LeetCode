package leetcode;

/**
 * Created by SUN on 2017.11.27.
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */

public class U_Q010_RegularExpressionMatching {
    //方法一，迭代
//    public boolean isMatch(String text, String pattern) {
//        if (pattern.isEmpty()) return text.isEmpty();
//        boolean first_match = (!text.isEmpty() &&
//                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
//
//        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
//            return (isMatch(text, pattern.substring(2)) ||
//                    (first_match && isMatch(text.substring(1), pattern)));
//        } else {
//            return first_match && isMatch(text.substring(1), pattern.substring(1));
//        }
//    }

    //方法二，动态规划，自上而下，dp(i,j)记录text[i:],pattern[j:]是否匹配
//    enum Result {TRUE, FALSE}
//    Result[][] memo;
//
//    public boolean isMatch(String text, String pattern) {
//        memo = new Result[text.length() + 1][pattern.length() + 1];
//        return dp(0, 0, text, pattern);
//    }
//
//    public boolean dp(int i, int j, String text, String pattern) {
//        if (memo[i][j] != null) {
//            return memo[i][j] == Result.TRUE;
//        }
//        boolean ans;
//        if (j == pattern.length()) {
//            ans = i == text.length();
//        } else {
//            boolean first_match = (i < text.length() &&
//                    (pattern.charAt(j) == text.charAt(i) ||
//                            pattern.charAt(j) == '.'));
//
//            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
//                ans = (dp(i, j + 2, text, pattern) ||
//                        first_match && dp(i + 1, j, text, pattern));
//            } else {
//                ans = first_match && dp(i + 1, j + 1, text, pattern);
//            }
//        }
//        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
//        return ans;
//    }

    //方法三，动态规划，自下而上，dp(i,j)记录text[i:],pattern[j:]是否匹配
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        for(int i=0;i<text.length()+1;i++) {
            for (int j = 0; j < pattern.length() + 1; j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
        return dp[0][0];
    }
}
