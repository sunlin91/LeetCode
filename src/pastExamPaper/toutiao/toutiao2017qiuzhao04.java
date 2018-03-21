package pastExamPaper.toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by SunLin on 2018.3.21
 * 题目描述
 * <p>
 * 给定整数n和m，将1到n的这n个整数按字典序排列之后，求其中的第m个数字。
 * 对于n = 11，m = 4，按字典序排列依次为1, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9，因此第4个数字为2。
 * <p>
 * <p>
 * 输入
 * 输入仅包含两个整数n和m。
 * 样例输入
 * 11 4
 * 输出
 * 输出仅包括一行，即所求排列中的第m个数字。
 * 样例输出
 * 2
 */

public class toutiao2017qiuzhao04 {
    //完全看不懂
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();

        long ans = 1;
        m--;
        while (m != 0) {
            long num = 0;
            long s = ans;
            long e = ans + 1;
            while (s <= n) {
                num += Math.min(n + 1, e) - s;
                s *= 10;
                e *= 10;
            }
            if (num <= m) {
                m -= num;
                ans++;
            } else {
                ans *= 10;
                m--;
            }
        }
        System.out.println(ans);
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        double[] nums = new double[n+1];
//        for (int i=1;i<=n;i++){
//            double val = i;
//            while (val>=10){
//                val/=10;
//            }
//            nums[i] = val;
//        }
//        Arrays.sort(nums);
//        int count = 0;
//        for (int i=m-1;i>=1;i--){
//            if (nums[i]==nums[m]){
//                count++;
//            }else break;
//        }
//        String res = nums[m]+"";
//        res=res.substring(0,1)+res.substring(2,res.lastIndexOf('0'));
//        while (count>0){
//            res+="0";
//            count--;
//        }
//        System.out.println(res);
//    }
}
