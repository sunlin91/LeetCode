package leetcode;import java.util.*;

/**
 * Created by SUN on 2017.12.5.
 * Given an array S of n integers, are there elements a, b, c in S
 * such that a + b + c = 0? Find all unique triplets in the array which
 * gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Q015_3Sum_g {
    //Time Limit Exceeded
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList();
//        if(nums==null||nums.length<3)
//            return result;
//        Set<String> set1 = new HashSet<>();
//        for(int i=0;i<nums.length-2;i++){
//            for(int j=i+1;j<nums.length-1;j++){
//                for(int k=j+1;k<nums.length;k++){
//                    if(nums[i]+nums[j]+nums[k]==0){
//                        List<Integer> list = new ArrayList<>();
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        list.add(nums[k]);
//                        list.sort(Integer::compareTo);
//                        if(set1.contains(list.toString()))
//                            continue;
//                        else
//                            set1.add(list.toString());
//                        result.add(list);
//                    }
//                }
//            }
//        }
//        return result;
//    }

    //先对nums排序，时间复杂度n*n
    public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
       List<List<Integer>> result = new ArrayList<>();
       for(int i=0;i<nums.length-2;i++){
           if(i==0||(i>0&&nums[i]!=nums[i-1])){
               int l=i+1,r=nums.length-1,sum=0-nums[i];
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
