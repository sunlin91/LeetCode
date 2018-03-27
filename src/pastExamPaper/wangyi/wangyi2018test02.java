package pastExamPaper.wangyi;

import java.util.Scanner;

/**
 * Created by SunLin on 2018.3.27
 */
public class wangyi2018test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (n >= 100000 || k > n) {
            System.out.println(0);

            return;
        }
        int count = 0;
        for (int i = n; i >= k; i--) {
            for (int j = n; j >= k; j--) {
                if (i % j >= k)
                    count++;
            }
        }
        System.out.println(count);
    }
}
