package pastExamPaper.wangyi;

import java.util.Scanner;

/**
 * Created by SunLin on 2018.3.27
 * 买苹果
 * 每次买6个或8个苹果，求买的最少次数正好买n个苹果。
 */
public class wangyi2017test02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = n/8;
        int b = 0;
        int cur = a*8;
        while (cur!=n&&a>0){
            if (cur<n){
                b++;
                cur+=6;
            }else if(cur>n){
                a--;
                cur-=8;
            }
        }
        if (a*8+b*6==n)
            System.out.println(a+b);
        else
            System.out.println(-1);
    }
}
