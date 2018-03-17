package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUN on 2018/3/16
 * Given two integers n and k, return all possible
 * combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class U_Q077_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        if(n<=0 || n<k)
            return res;
        help(new ArrayList(), k, n, 1, res);
        return res;
    }
    void help(List<Integer> list, int k, int n, int start, List<List<Integer>> res) {
        if(list.size() == k) {
            res.add(new ArrayList(list));
            return;
        }
        for(int i = start; i <= n; i ++) {
            list.add(i);
            if(list.size() + n - start >= k)
                help(list, k, n, i + 1, res);
            list.remove(list.size() - 1);
        }
    }

}
