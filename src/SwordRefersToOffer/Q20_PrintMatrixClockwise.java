package SwordRefersToOffer;

import java.util.ArrayList;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Q20_PrintMatrixClockwise {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix==null)
            return null;
        ArrayList<Integer> res = new ArrayList<>();
        int top=0,bottom=matrix.length-1,left=0,right=matrix[0].length-1;
        while (top<=bottom&&left<=right){
            for (int j=left;j<=right;j++){
                res.add(matrix[top][j]);
            }
            top++;
            if (top>bottom)break;

            for (int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;
            if (left>right)break;

            for (int j=right;j>=left;j--){
                res.add(matrix[bottom][j]);
            }
            bottom--;
            if (top>bottom)break;

            for (int i=bottom;i>=top;i--){
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}