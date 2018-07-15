package pastExamPaper.wap;

import java.util.Scanner;

public class WAP2018test01 {

    private static int N = 100005;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] G = new int[N];
        int[] S = new int[N];

        for (int i = 1; i <= m; i++) {
            int k = in.nextInt();
            while (k-- > 0) {
                int x = in.nextInt();
                G[x] = i;
                S[i] = x;
            }
        }

        int result = 0;
        // write your code
        int station = 1;
        int finalRoute = G[n];
        int route = 1;
        while (station!=n){
            result++;
            station = S[route];
            route = G[station];
            if (route==finalRoute)
                break;
        }


        System.out.println(result);

    }
}
