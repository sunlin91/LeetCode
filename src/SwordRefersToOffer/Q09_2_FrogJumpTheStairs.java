package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Q09_2_FrogJumpTheStairs {
    public int JumpFloor(int target) {
        if (target==0)
            return 0;
        int g = 2;
        int f = 1;
        while (target-->1){
            g+=f;
            f=g-f;
        }
        return f;
    }
}

