package leetcode;

/**
 * Created by SunLin on 2018.3.16
 * Given a m x n matrix, if an element is 0,
 * set its entire row and column to 0. Do it in place.

 click to show follow up.
 */
public class Q073_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m =matrix.length,n=matrix[0].length;
        int m0=1;
        for (int i=0;i<m;i++){
            if (matrix[i][0]==0){
                m0=0;
            }
            for (int j=1;j<n;j++){
                if (matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (m0 == 0) matrix[i][0] = 0;
        }
    }
}
