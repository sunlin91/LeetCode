package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUN on 2018/5/13
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Q118_Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows<=0)
            return res;
        for (int i=0;i<numRows;i++){
            List<Integer> cur = new ArrayList<>();
            for (int j=0;j<=i;j++){
                if (j==0||j==i){
                    cur.add(1);
                    continue;
                }
                int a = res.get(i-1).get(j-1)+res.get(i-1).get(j);
                cur.add(a);
            }
            res.add(cur);
        }
        return res;
    }
}
