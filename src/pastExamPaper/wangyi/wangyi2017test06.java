package pastExamPaper.wangyi;

import java.util.Scanner;

/**
 * Created by SunLin on 2018.3.27
 * 回文序列
 * 选择临近的两个数进行相加操作，使原数组变成回文序列的最小操作次数
 * 如
 * 1,2,1操作0次
 * 1,2,2操作2次
 * 1 1 1 3操作2次
 */
public class wangyi2017test06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int l = 0, r = n - 1;
        int res = 0;
        while (l < r) {
            if (a[l] == a[r]) {
                l++;
                r--;
            } else if (a[l] < a[r]) {
                a[l + 1] = a[l] + a[l + 1];
                l++;
                res++;
            } else {
                a[r - 1] = a[r] + a[r - 1];
                r--;
                res++;
            }
        }
        System.out.println(res);
    }
}
