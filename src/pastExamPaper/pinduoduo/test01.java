package pastExamPaper.pinduoduo;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int res;
        if (c > b * 2) {
            res = 2 * (a / c);
            if (a % c != 0) {
                if (a % c > b) {
                    res += 2;
                } else {
                    res += 1;
                }
            }
        } else {
            if (a % b == 0) {
                res = a / b;
            } else {
                res = a / b + 1;
            }
        }
        System.out.println(res);
    }
}
