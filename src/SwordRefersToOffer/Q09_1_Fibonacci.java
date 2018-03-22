package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 n<=39
 */
public class Q09_1_Fibonacci {
    public int Fibonacci(int n) {
        if (n==0)
            return 0;
        int[] fibonacci = new int[n+1];
        fibonacci[0]=0;
        fibonacci[1]=1;
        for (int i=2;i<=n;i++){
            fibonacci[i]=fibonacci[i-1]+fibonacci[i-2];
        }
        return fibonacci[n];
    }
}
//    public int Fibonacci(int n) {
//        int f = 0, g = 1;
//        while (n-- > 0) {
//            g += f;
//            f = g - f;
//        }
//        return f;
//    }
