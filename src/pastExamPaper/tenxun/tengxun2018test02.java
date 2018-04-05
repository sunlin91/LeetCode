package pastExamPaper.tenxun;

import java.util.Scanner;

/**
 * Created by SUN on 2018/4/5
 */
public class tengxun2018test02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int A = sc.nextInt();
        int X = sc.nextInt();
        int B = sc.nextInt();
        int Y = sc.nextInt();

        double res = 0;
        if (A+B>K){
            System.out.println((int)res);return;
        }
        for (int a=0;a<=(K/A);a++){
            for (int b=0;b<=(K/B);b++){
                if ((a*A+b*B)==K){
                    res+=helper(X,a,Y,b);
                    if (res>1000000007){
                        res%=1000000007;
                    }
                }
            }
        }
        System.out.println((int)res);
    }
    static double helper(int X,int a,int Y,int b){
        double res1 = 1;
        double res2 = 1;
        for (int i=X;i>=1;i--){
            res1*=i;
        }
        for (int i=a;i>=1;i--){
            res1/=i;
        }
        for (int i=(X-a);i>=1;i--){
            res1/=i;
        }

        for (int i=Y;i>=1;i--){
            res2*=i;
        }
        for (int i=b;i>=1;i--){
            res2/=i;
        }
        for (int i=(Y-b);i>=1;i--){
            res2/=i;
        }
        return res1*res2;
    }
}
