package leetcode;

/**
 * Created by SunLin on 2018.3.16
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]

 */
public class Q059_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n<=0)
            return new int[0][0];
        int[][] res = new int[n][n];
        int top=0,bottom=n-1,left=0,right=n-1;
        int a=1;
        while (true){

            for (int i=left;i<=right;i++){
                res[top][i]=a++;
            }
            top++;
            if (top>bottom)break;

            for (int i=top;i<=bottom;i++){
                res[i][right]=a++;
            }
            right--;
            if (left>right)break;

            for (int i=right;i>=left;i--){
                res[bottom][i]=a++;
            }
            bottom--;
            if (top>bottom)break;

            for (int i=bottom;i>=top;i--){
                res[i][left]=a++;
            }
            left++;
            if (left>right)break;
        }
        return res;
    }
}
