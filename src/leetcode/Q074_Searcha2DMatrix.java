package leetcode;

/**
 * Created by SUN on 2018/3/16
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class Q074_Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return false;
        int m=matrix.length,n=matrix[0].length;
        int left = 0,right =m*n-1,mid=(right+left)/2;
        while (left<=right){
            int a =matrix[mid/n][mid%n];
            if (a<target){
                left=mid+1;
                mid=(left+right)/2;
            }else if (a>target){
                right=mid-1;
                mid=(left+right)/2;
            }else {
                return true;
            }
        }
        return false;
    }
}
