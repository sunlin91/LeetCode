package leetcode;

/**
 * Created by SunLin on 2018.3.16
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 */
public class Q063_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] map = new int[m][n];
        boolean flag=false;
        for(int i = 0; i<m;i++){
            if (obstacleGrid[i][0]==1)
                flag=true;
            if (flag)
                map[i][0]=0;
            else
                map[i][0] = 1;
        }
        flag=false;
        for(int j= 0;j<n;j++){
            if (obstacleGrid[0][j]==1)
                flag=true;
            if (flag)
                map[0][j]=0;
            else
                map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if (obstacleGrid[i][j]==1)
                    map[i][j]=0;
                else
                    map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
}
