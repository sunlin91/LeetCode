package pastExamPaper.wangyi;

import java.util.Scanner;


public class qiuzhao2018test02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int q[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (i > 0)
                q[i] = q[i - 1] + a[i];
            else
                q[i] = a[i];
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int j = helper(q, sc.nextInt());
            System.out.println(j + 1);
        }
    }

    private static int helper(int q[], int target) {

        int l = 0, r = q.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (q[mid] == target) return mid;
            else if (q[mid] < target)
                l = mid + 1;
            else {
                r = mid;
            }

        }
        return r;
    }
}
