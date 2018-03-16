package leetcode;

/**
 * Created by SUN on 2018/3/16
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent
 * the color red, white, and blue respectively.
 * <p>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * <p>
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array
 * with total number of 0's, then 1's and followed by 2's.
 * <p>
 * Could you come up with an one-pass algorithm using only constant space?
 */
public class Q075_SortColors {
    public void sortColors(int[] nums) {
        if (nums==null||nums.length<=1)
            return;
        int a1 = 0,a2=0,a3=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0)
                a1++;
            if (nums[i]==1)
                a2++;
            if (nums[i]==2)
                a3++;
        }
        for (int i=0;i<a1;i++){
            nums[i]=0;
        }
        for (int i=0;i<a2;i++){
            nums[i+a1]=1;
        }
        for (int i=0;i<a3;i++){
            nums[i+a1+a2]=2;
        }
    }
}
