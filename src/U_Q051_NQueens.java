import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUN on 2018.2.27.
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * <p>
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * <p>
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class U_Q051_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        //用数组保存第i行时，Q所在的列
        int[] row = new int[n];
        solver(result,row,0,n);
        return result;
    }

    /**
     * 主方法
     * @param result
     * @param row
     * @param m
     * @param n
     */
    private void solver(List<List<String>> result,int[] row,int m,int n){
        if(m==n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(row[i]==j) sb.append("Q");
                    else sb.append(".");
                }
                list.add(sb.toString());
            }
            result.add(list);
        }else {
            //不断尝试第m行时，所有列的合法情况，合法则继续调用下一行m+1
            for(int i=0;i<n;i++){
                row[m]=i;
                if(isNQueens(row,m))
                    solver(result,row,m+1,n);
            }
        }
    }

    /**
     * 判断在第m行时，row[m]列为Q，与之前的Q是否有冲突
     * @param row
     * @param m
     * @return
     */
    private boolean isNQueens(int[] row,int m){
        for(int i=0;i<m;i++){
            if(row[i]==row[m])//不同行是否同列
                return false;
            if(Math.abs(i-m)==Math.abs(row[m]-row[i]))//判断是否在一条斜线上
                return false;
        }
        return true;
    }
}
