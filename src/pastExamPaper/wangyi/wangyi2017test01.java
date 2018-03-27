package pastExamPaper.wangyi;

import java.util.Scanner;

/**
 * Created by SunLin on 2018.3.27
 * 计算糖果
 * 输入四个数分别表示A-B,B-C,A+B,B+C
 * 计算A,B,C，可以直接计算，要判断是否满足条件
 */
public class wangyi2017test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int A = (int) (0.5 * (a + c));
        int B1 = (int) (0.5 * (b + d));
        int B2 = (int) (0.5 * (c - a));
        int C = (int) (0.5 * (d - b));
        if (B1 != B2)
            System.out.println("No");
        else
            System.out.println(A + " " + B1 + " " + C);
    }
}
