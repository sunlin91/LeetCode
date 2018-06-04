package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by SunLin on 2018.6.4
 * <p>
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class Q136_SingleNumber {
    //牛逼
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int a:nums) r^=a;//相等的两个数异或运算为0，剩下的就是要找的那个数
        return r;
    }

    //30%了。。。
//    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        for (int i=0;i<nums.length-1;i+=2){
//            if (nums[i]!=nums[i+1])
//                return nums[i];
//        }
//        return nums[nums.length-1];
//    }

    //速度不是很快（20%）
//    public int singleNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int i=0;i<nums.length;i++){
//            if (set.contains(nums[i]))
//                set.remove(nums[i]);
//            else
//                set.add(nums[i]);
//        }
//        return (int) set.toArray()[0];
//    }
}
