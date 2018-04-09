package pastExamPaper.jingdong;

import java.util.*;

public class jingdong2018test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] t = new long[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextLong();
        }
        for (int j = 0; j < n; j++) {
            helper(t[j]);
        }
    }

    static void helper(long n) {
        if (n % 2 != 0) {
            System.out.println("No");
            return;
        }
        long end = n / 2;
        for (int i = 2; i <= end; i = i + 2) {
            if (n % i == 0) {
                long X = n / i;
                int Y = i;
                if (X % 2 != 0) {
                    System.out.println(X + " " + Y);
                    return;
                }
            }
        }
        System.out.println("No");
    }

}