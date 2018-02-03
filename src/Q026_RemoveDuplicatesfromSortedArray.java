/**
 * Created by SUN on 2017.12.18.
 * Given a sorted array, remove the duplicates in-place such that
 * each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * <p>
 * Example:
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class Q026_RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        int p = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[p]!=nums[i]){
                nums[++p]=nums[i];
            }
        }
        return ++p;
    }
}
