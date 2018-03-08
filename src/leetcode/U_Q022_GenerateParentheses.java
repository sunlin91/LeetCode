package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SUN on 2017.12.14.
 * Given n pairs of parentheses, write a function to generate
 * all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class U_Q022_GenerateParentheses {
    //参考
    public void combination(List<String> result, String prefix, int open, int close) {
        if (open == 0 && close == 0) {
            result.add(prefix);
        } else {
            if (open > 0) {
                combination(result, prefix + '(', open - 1, close + 1);
            }
            if (close > 0) {
                combination(result, prefix + ')', open, close - 1);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        combination(result, "", n, 0);
        return result;
    }
}
