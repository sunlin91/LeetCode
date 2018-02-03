/**
 * Created by SUN on 2018/2/3
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class Q041_FirstMissingPositive {
    //利用下标
    public int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0)
            return 1;
        for(int i=0;i<nums.length;i++){
            //最后一个判断用来判断重复元素的情况
            if(nums[i]>0&&nums[i]<nums.length&&nums[nums[i]-1]!=nums[i]){
                int tmp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=tmp;
                i--;
            }
        }
        for(int i=0;i<nums.length;i++){
            if((i+1)!=nums[i])
                return i+1;
        }
        return nums.length+1;
    }
}
