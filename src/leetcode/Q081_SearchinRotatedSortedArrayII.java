package leetcode;

/**
 * Created by SunLin on 2018.3.19
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p>
 * Would this affect the run-time complexity? How and why?
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Write a function to determine if a given target is in the array.
 * The array may contain duplicates.
 */
public class Q081_SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int left = 0, right = nums.length - 1, mid = (left + right) / 2;
        while (left <= right) {
            if (nums[mid] == target || nums[right] == target || nums[left] == target)
                return true;
            if (nums[left] < target && nums[mid] > target) {
                right = mid - 1;
            } else if (nums[right] > target && nums[mid] < target) {
                left = mid + 1;
            } else {
                left++;
                right--;
            }
            mid = (left + right) / 2;
        }
        return false;
    }
//    public boolean search(int[] nums, int target) {
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]==target)
//                return true;
//        }
//        return false;
//    }
}
