package leetcode;

/**
 * Created by SunLin on 2018.3.16
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example 1:
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Q064_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] nums = new int[m][n];
        nums[0][0]=grid[0][0];
        for (int j=1;j<n;j++){
            nums[0][j]=nums[0][j-1]+grid[0][j];
        }
        for (int i=1;i<m;i++){
            nums[i][0]=nums[i-1][0]+grid[i][0];
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                nums[i][j]=(nums[i-1][j]<nums[i][j-1]?nums[i-1][j]:nums[i][j-1])+grid[i][j];
            }
        }
        return nums[m-1][n-1];
    }
}
