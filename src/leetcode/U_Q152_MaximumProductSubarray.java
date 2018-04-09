package leetcode;

/**
 * Created by SunLin on 2018.4.9
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class U_Q152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int r = nums[0];

        for (int i = 1, imax = r, imin = r; i < n; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax=imin;
                imin=tmp;
            }

            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
            r = Math.max(r, imax);
        }
        return r;
    }
}
