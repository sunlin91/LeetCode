package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Q09_3_FrogJumpTheStairs2 {
    public int JumpFloorII(int target) {
        if (target<1)
            return 0;
        int[] res = new int[target+1];
        res[0]=0;
        res[1]=1;
        int sum = 1;
        for (int i=2;i<=target;i++){
            res[i]=sum+1;
            sum+=res[i];
            //相当于res[i]=res[i-1]*2;
        }
        return res[target];
    }
}