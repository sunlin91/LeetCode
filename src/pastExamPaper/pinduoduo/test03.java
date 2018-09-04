package pastExamPaper.pinduoduo;

import java.util.ArrayList;
import java.util.Scanner;

public class test03 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        char str[] = Float.toString(a / b).toCharArray();

        if (!isLoop(a, b)) {
            int i = str.length - 1;
            while (str[i] != '.') i--;
            int count = str.length - i;
            System.out.println(count + " " + 0);
        } else {
            int res = helper((long) a, b);
            System.out.println(0 + " " + res);
        }
    }

    static int helper(Long n, long m) {
        n = n % m;
        ArrayList<Long> v = new ArrayList<>();
        while (true) {
            v.add(n);
            n *= 10;
            n = n % m;
            if (n == 0)
                return 0;
            if (v.indexOf(n) >= 0)
                return v.size() - v.indexOf(n);
        }
    }

    //判断是否为循环小数
    private static boolean isLoop(long a, long b) {
        // 1.化简，分子分母同时除以最大公约数
        long commonDivisor = greatestCommonDivisor(a, b);
        b = b / commonDivisor;
        // 2.判断分母是否为2的次幂，5的次幂，或者2 5结合
        // 首先让其除以2的次幂
        while (b % 2 == 0) {
            b /= 2;
        }
        // 然后让其除以5的次幂
        while (b % 5 == 0) {
            b /= 5;
        }
        // 最后判断是否为1,如果为1 说明没有 2或者5或者2和5结合构成 以外的因子
        return b != 1;
    }

    private static long greatestCommonDivisor(long a, long b) {
        long c = 0;
        while (true) {// 循环的辗转相除法
            c = a % b;
            a = b;
            b = c;
            if (b == 0) {
                return a;
            }
        }
    }

}