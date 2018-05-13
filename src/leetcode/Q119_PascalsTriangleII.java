package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUN on 2018/5/13
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * Example:
 * <p>
 * Input: 3
 * Output: [1,3,3,1]
 */
public class Q119_PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>(rowIndex);
        for (int i = 0; i <= rowIndex; i++) {
            res.add(1);
            int tmp = 1;
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    res.set(j, 1);
                    continue;
                }
                int a = tmp + res.get(j);
                tmp = res.get(j);
                res.set(j, a);
            }
        }
        return res;
    }
}
