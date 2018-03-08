package leetcode;

/**
 * Created by SUN on 2018.2.26.
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * Example 2:
 * <p>
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class Q048_RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null)
            return;
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            int[] tmp = new int[n - i * 2];
            for (int j = 0; j < n - i * 2 - 1; j++) {//交换前n-1个，最后一个留给下一组
                tmp[j] = matrix[i][j + i];
                //左换到上
                matrix[i][j + i] = matrix[n - j - i - 1][i];//注意第i圈的时候应该为j+i
                //下换到左
                matrix[n - j - i - 1][i] = matrix[n - 1 - i][n - 1 - j - i];
                //右换到下
                matrix[n - 1 - i][n - 1 - j - i] = matrix[j + i][n - 1 - i];
                //上换到右
                matrix[j + i][n - 1 - i] = tmp[j];
            }
        }
    }
}
