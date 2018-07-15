package pastExamPaper.wap;

import java.util.Scanner;

public class WAP2018test02 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();


        int[] d = new int[n + 1];
        int[] c = new int[n + 1];
        d[0] = 0;
        c[0] = 0;
        for (int i = 1; i <= n; i++) {
            c[i] = in.nextInt();
            d[i] = in.nextInt();
        }

        int result = 0;
        //write your code
        int[][] T = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            T[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            T[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < c[i]) {
                    T[i][j] = T[i - 1][j];
                } else {
                    T[i][j] = Math.max(T[i - 1][j], T[i - 1][j - c[i]] + d[i]);
                }
            }
        }
        result = T[n][m];
        System.out.println(result);
    }
}
