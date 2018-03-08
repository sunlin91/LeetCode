package leetcode;import java.util.Arrays;

import static java.lang.Math.abs;

/**
 * Created by SUN on 2017.12.5.
 * Given an array S of n integers, find three integers in S such that
 * the sum is closest to a given number, target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Q016_3SumClosest {
    //通过，速度较慢
//    public int threeSumClosest(int[] nums, int target) {
//        if(nums==null||nums.length<3)
//            return 0;
//        Arrays.sort(nums);
//        int absmin=abs(nums[0]+nums[1]+nums[2]-target),
//                pos1=0,pos2=1,pos3=2;
//        for(int i=0;i<nums.length-2;i++){
//            for(int j=i+1;j<nums.length-1;j++){
//                for(int k=j+1;k<nums.length;k++){
//                    if(abs(nums[i]+nums[j]+nums[k]-target)<absmin){
//                        absmin=abs(nums[i]+nums[j]+nums[k]-target);
//                        pos1=i;pos2=j;pos3=k;
//                    }else if(nums[i]+nums[j]+nums[k]-target>0)
//                        break;
//                }
//            }
//        }
//        return nums[pos1]+nums[pos2]+nums[pos3];
//    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int absmin = abs(nums[0] + nums[1] + nums[2] - target),
                pos1 = 0, pos2 = 1, pos3 = 2;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (abs(nums[l] + nums[i] + nums[r] - target) < absmin) {
                    absmin = abs(nums[l] + nums[i] + nums[r] - target);
                    pos1 = i;
                    pos2 = l;
                    pos3 = r;
                } else if (nums[l] + nums[i] + nums[r] - target > 0) {
                    r--;
                } else if (nums[l] + nums[i] + nums[r] - target < 0) {
                    l++;
                }else break;
            }
        }
        return nums[pos1] + nums[pos2] + nums[pos3];
    }

}
