package leetcode;

/**
 * Created by SunLin on 2018.3.16
 * Given an array of non-negative integers,
 * you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 */
public class Q055_JumpGame {
    public boolean canJump(int[] nums) {
        if (nums==null||nums.length==0)
            return true;
        int pos = 0;
        int maxJump=nums[0];//最远可跳
        for (int i=1;i<nums.length&&(maxJump+pos>=i);i++){
            if (nums[i]>maxJump-(i-pos)){
                maxJump=nums[i];
                pos=i;
            }
            if (pos+maxJump>=nums.length-1)
                return true;
        }
        return pos>=nums.length-1;
    }
}
