package leetcode;

/**
 * Created by SunLin on 2018.3.16
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output:  2
 * Explanation:  There are two ways to climb to the top.
 * <p>
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output:  3
 * Explanation:  There are three ways to climb to the top.
 * <p>
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class Q070_ClimbingStairs {
    public int climbStairs(int n) {
        if (n<=0)
            return 0;
        if (n==1)
            return 1;
        int[] a = new int[n];

        a[n-1]=1;
        a[n-2]=2;
        for (int i=n-3;i>=0;i--){
            a[i]=a[i+1]+a[i+2];
        }
        return a[0];
    }
}
