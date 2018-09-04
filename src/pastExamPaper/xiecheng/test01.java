package pastExamPaper.xiecheng;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        System.out.println(NumberOf1(a));
    }

    public static int NumberOf1(long n) {
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
