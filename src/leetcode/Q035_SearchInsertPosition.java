package leetcode;

/**
 * Created by SUN on 2018.1.4.
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 1:
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class Q035_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target)
                return i;
        }
        return nums.length;
    }

    public int searchInsert1(int[] nums, int target) {
        int r = nums.length;
        int l = 0;
        while(l < r){
            int mid = (l+r)/2;
            if(nums[mid] < target)
                l = mid +1;
            else
                r = mid;
        }
        return l;
    }
}
