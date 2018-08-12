package pastExamPaper.toutiao;

import java.util.*;


/**
 * 10,10
 * 0,0,0,0,0,0,0,0,0,0
 * 0,0,0,1,1,0,1,0,0,0
 * 0,1,0,0,0,0,0,1,0,1
 * 1,0,0,0,0,0,0,0,1,1
 * 0,0,0,1,1,1,0,0,0,1
 * 0,0,0,0,0,0,1,0,1,1
 * 0,1,1,0,0,0,0,0,0,0
 * 0,0,0,1,0,1,0,0,0,0
 * 0,0,1,0,0,1,0,0,0,0
 * 0,1,0,0,0,0,0,0,0,0
 * <p>
 * 输出
 * 6,8
 */
public class qiuzhao01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int m = Integer.parseInt(str.trim().split(",")[0]);
        int n = Integer.parseInt(str.trim().split(",")[1]);
        int input[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            String str1 = sc.nextLine();
            for (int j = 0; j < n; j++) {
                input[i][j] = Integer.parseInt(str1.trim().split(",")[j]);
            }
        }
        int max_nums = 0, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (input[i][j] == 1) {
                    max_nums = Math.max(helper(input, m, n, i, j), max_nums);
                    count++;
                }
            }
        }
        System.out.println(count + "," + max_nums);
    }

    public static int helper(int[][] input, int m, int n, int y, int x) {
        if (x >= 0 && y >= 0 && y < m && x < n && input[y][x] == 1) {
            input[y][x] = -1;
            int count = 0;
            count += helper(input, m, n, y + 1, x);
            count += helper(input, m, n, y, x + 1);
            count += helper(input, m, n, y - 1, x);
            count += helper(input, m, n, y, x - 1);
            count += helper(input, m, n, y + 1, x + 1);
            count += helper(input, m, n, y - 1, x + 1);
            count += helper(input, m, n, y - 1, x - 1);
            count += helper(input, m, n, y + 1, x - 1);
            return count + 1;
        }
        return 0;

    }

}
