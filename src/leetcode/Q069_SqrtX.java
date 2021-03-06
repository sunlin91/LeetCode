package leetcode;

/**
 * Created by SunLin on 2018.3.16
 * mplement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 * <p>
 * x is guaranteed to be a non-negative integer.
 */
public class Q069_SqrtX {

    //速度啊，朋友
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

//    public int mySqrt(int x) {
//        long a=1;
//        while (a*a<=x){
//            a++;
//        }
//        return (int)a-1;
//    }
}
