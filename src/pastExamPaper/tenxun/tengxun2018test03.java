package pastExamPaper.tenxun;

import java.io.*;
import java.util.*;

public class tengxun2018test03 {
    private static class val {
        int x;
        int y;
    }

    public static void main(String[] args) {
        int n, m, res1=0;
        long res2=0;
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        n = sc.nextInt();
        m = sc.nextInt();

        val s1[] = new val[n];
        val s2[] = new val[m];
        int machine[] = new int[200];
        for (int i = 0; i < n; i++) {
            s1[i] = new val();
        }
        for (int i = 0; i < m; i++) {
            s2[i] = new val();
        }
        for (int i = 0; i < n; i++) {
            s1[i].x = sc.nextInt();
            s1[i].y = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            s2[i].x = sc.nextInt();
            s2[i].y = sc.nextInt();
        }
        Arrays.sort(s1, 0, n, new MyComparator());
        Arrays.sort(s2, 0, m, new MyComparator());
        Arrays.fill(machine, 0);
        for (int i = 0, j = 0; i < m; i++) {
            while (j < n && s1[j].x >= s2[i].x) {
                machine[s1[j].y]++;
                j++;
            }
            for (int k = s2[i].y; k <= 100; k++) {
                if (machine[k] > 0) {
                    machine[k]--;
                    res2 += (s2[i].x * 200 + s2[i].y * 3);
                    res1++;
                    break;
                }
            }
        }
        System.out.println(res1 + " " + res2);
    }

    private static class MyComparator implements Comparator<val> {
        @Override
        public int compare(val a, val b) {
            if (a.x == b.x) {
                if (a.y == b.y) return 0;
                return a.y < b.y ? 1 : -1;
            }
            if (a.x == b.x) return 0;
            return a.x < b.x ? 1 : -1;
        }
    }
}