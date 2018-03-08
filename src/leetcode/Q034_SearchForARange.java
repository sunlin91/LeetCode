package leetcode;

/**
 * Created by SUN on 2018.1.3.
 * Given an array of integers sorted in ascending order,
 * find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class Q034_SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums==null||nums.length==0)
            return result;
        int left=0,right=nums.length-1,mid=(left+right)/2;
        //找左
        while (left<=right){
            if(nums[mid]>target){
                right=mid-1;
                mid=(right+left)/2;
            }else if(nums[mid]<target){
                left=mid+1;
                mid=(right+left)/2;
            }else {
                if(mid>0&&nums[mid-1]<target){
                    result[0]=mid;
                    break;
                }else if(nums[0]==target){
                    result[0]=0;
                    break;
                }else {
                    right=mid-1;
                    mid=(left+right)/2;
                }
            }
        }
        if(result[0]==-1)
            return result;
        //找右
        left=result[0];right=nums.length-1;mid=(left+right)/2;
        while (left<=right){
            if(nums[mid]>target){
                right=mid-1;
                mid=(right+left)/2;
            }else if(nums[mid]<target){
                left=mid+1;
                mid=(right+left)/2;
            }else {
                if(mid<nums.length-1&&nums[mid+1]>target){
                    result[1]=mid;
                    break;
                }else if(nums[nums.length-1]==target){
                    result[1]=nums.length-1;
                    break;
                }else {
                    left=mid+1;
                    mid=(left+right)/2;
                }
            }
        }
        return result;
    }
}
