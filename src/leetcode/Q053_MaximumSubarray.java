package leetcode;

/**
 * Created by SunLin on 2018.3.16
 * 今天开始只刷easy和medium难度，找实习前刷200左右，加油！！！2018.3.16
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * <p>
 * click to show more practice.
 * <p>
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution
 * using the divide and conquer approach, which is more subtle.
 */
public class Q053_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int current = res;
        for (int i = 1; i < nums.length; i++) {
            if (current < 0 && nums[i] > 0) {
                current = nums[i];
                res = res > current ? res : current;
                continue;
            }
            if (current + nums[i] > 0) {
                current += nums[i];
                res = res > current ? res : current;
            } else {
                current = nums[i];
                res=res>current?res:current;
            }
        }
        return res;
    }
}
