import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SUN on 2017.12.12.
 * Given an array S of n integers, are there elements a, b, c, and d
 * in S such that a + b + c + d = target? Find all unique quadruplets in the array
 * which gives the sum of target.
 * <p>
 * Note: The solution set must not contain duplicate quadruplets.
 * <p>
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class Q018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int[] newnums = new int[nums.length-i-1];
            for(int p=0;p<nums.length-i-1;p++){newnums[p]=nums[p+i+1];}
            for(List<Integer> l:(threeSum(newnums,target-nums[i]))){
                List<Integer> nl = new ArrayList<>();
                nl.add(nums[i]);nl.addAll(l);
                result.add(nl);
            }
        }
        return result;
    }
    //利用Q015中的函数(稍作修改)
    public List<List<Integer>> threeSum(int[] nums,int target) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i==0||(i>0&&nums[i]!=nums[i-1])){
                int l=i+1,r=nums.length-1,sum=target-nums[i];
                while (l<r){
                    if(nums[l]+nums[r]==sum){
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l<r&&nums[l]==nums[l+1]) l++;
                        while (l<r&&nums[r]==nums[r-1]) r--;
                        l++;r--;
                    }else if(nums[l]+nums[r]>sum)
                        r--;
                    else
                        l++;
                }
            }
        }
        return result;
    }
}
