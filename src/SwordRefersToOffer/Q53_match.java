package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.8
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Q53_match {
    public boolean match(char[] str, char[] pattern) {
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[str.length][pattern.length] = true;

        for (int i = str.length; i >= 0; i--){
            for (int j = pattern.length - 1; j >= 0; j--){
                boolean first_match = (i < str.length &&
                        (pattern[j] == str[i] ||
                                pattern[j] == '.'));
                if (j + 1 < pattern.length && pattern[j+1] == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        for(int i=0;i<str.length+1;i++) {
            for (int j = 0; j < pattern.length + 1; j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
        return dp[0][0];
    }
}
