package leetcode;

import java.util.List;

/**
 * Created by SunLin on 2018.4.9
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 */
public class U_Q120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle==null||triangle.size()==0)
            return 0;
        int n = triangle.size();
        int[] res = new int[n];
        //从最底层开始往上找一条路径
        for (int i=0;i<n;i++){
            res[i]=triangle.get(n-1).get(i);
        }
        for (int i=n-2;i>=0;i--){
            List<Integer> list = triangle.get(i);
            for (int j=0;j<list.size();j++){
                //每一层与其下一层的子节点i和i+1比较，小的纳入路径中
                res[j] = Math.min(res[j],res[j+1])+triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}
