/**
 * Created by SUN on 2018/2/5
 * Given an array of non-negative integers,
 * you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p>
 * The minimum number of jumps to reach the last index is 2.
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * <p>
 * Note:
 * You can assume that you can always reach the last index.
 */
public class U_Q045_JumpGameII {
    //牛逼
    public int jump(int[] nums) {
        int n = nums.length;
        if(n<2)return 0;
        int level=0,currentMax=0,i=0,nextMax=0;

        while(currentMax-i+1>0){		//level代表跳的次数
            level++;
            for(;i<=currentMax;i++){	//当天level跳的次数所能达到最远的地方
                nextMax=(nextMax>nums[i]+i?nextMax:nums[i]+i);
                if(nextMax>=n-1)return level;   //如果下一跳能到达最后则直接返回level
            }
            currentMax=nextMax;
        }
        return 0;
    }
}
