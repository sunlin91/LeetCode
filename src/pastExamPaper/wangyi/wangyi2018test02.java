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
        int res = 0;
        for (int i = k; i < n; i++) {
            res += n - i;
        }
        for (int i=n;i-(k+1)>k;i--){
            res+=(i-(k+1))-(k+1)+1;
        }
        System.out.println(res);
    }
}
