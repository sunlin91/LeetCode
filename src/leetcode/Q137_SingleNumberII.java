package leetcode;

import java.util.Arrays;

/**
 * Created by SunLin on 2018.6.21
 * <p>
 * Given a non-empty array of integers, every element appears three times except for one,
 * which appears exactly once. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
public class Q137_SingleNumberII {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i+=3){
            if (nums[i]!=nums[i+1]||nums[i]!=nums[i+2])
                return nums[i];
        }
        return nums[nums.length-1];
    }
}
