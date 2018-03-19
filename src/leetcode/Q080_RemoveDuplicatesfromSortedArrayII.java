package leetcode;

/**
 * Created by SunLin on 2018.3.19
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first
 * five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class Q080_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        int p = 0;
        int flag = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[p]==nums[i]&&flag<2){
                nums[++p]=nums[i];
                flag++;
                continue;
            }
            if(nums[p]!=nums[i]){
                nums[++p]=nums[i];
                flag=1;
            }
        }
        return ++p;
    }
}
