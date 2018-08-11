package pastExamPaper.wangyi;

import java.util.Scanner;

/*
6 3
1 3 5 2 5 4
1 1 0 1 0 0
* */
public class qiuzhao2018test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] scores = new int[n];
        int[] awake = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            awake[i] = scanner.nextInt();
            if (awake[i] != 0) {
                sum += scores[i];
            }
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (awake[i] == 0) {
                max += scores[i];
            }
        }
        int pre = max;
        for (int i = k; i < n; i++) {
            if (awake[i] == 0) {
                pre += scores[i];
            }
            if (awake[i - k] == 0) {
                pre -= scores[i - k];
            }
            max = Math.max(max, pre);
        }
        int res = sum + max;
        System.out.println(res);
    }
}
