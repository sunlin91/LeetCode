package leetcode;

/**
 * Created by SUN on 2018.2.27.
 * Implement pow(x, n).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 */
public class U_Q050_PowXN {

    //方法二
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }

    //方法一
//    private double fastPow(double x, long n) {
//        if (n == 0) {
//            return 1.0;
//        }
//        double half = fastPow(x, n / 2);
//        if (n % 2 == 0) {
//            return half * half;
//        } else {
//            return half * half * x;
//        }
//    }
//
//    public double myPow(double x, int n) {
//        long N = n;
//        if (N < 0) {
//            x = 1 / x;
//            N = -N;
//        }
//
//        return fastPow(x, N);
//    }
}
