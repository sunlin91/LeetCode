package leetcode;

/**
 * Created by SUN on 2018.1.2.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 */
public class Q033_SearchInRotatedSortedArray {
    //感觉也快不了多少
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length-1,mid=(left+right)/2;
        while (left<=right){
            if(nums[mid]==target)
                return mid;
            if(nums[right]==target)
                return right;
            if(nums[left]==target)
                return left;
            if(nums[left]<target&&nums[mid]>target){
                right=mid-1;
            }
            else if(nums[right]>target&&nums[mid]<target){
                left=mid+1;
            }
            else{
                left++;
                right--;
            }
            mid=(left+right)/2;
        }
        return -1;
    }

    //直接找，速度还可以
//    public int search(int[] nums, int target) {
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]==target)
//                return i;
//        }
//        return -1;
//    }
}
