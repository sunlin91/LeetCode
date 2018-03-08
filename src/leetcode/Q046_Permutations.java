package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SUN on 2018/2/7
 * Given a collection of distinct numbers, return all possible permutations.
 * <p>
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Q046_Permutations {
    //和字符串全排列相同，只不过这里没有重复元素
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums != null && nums.length > 0) {
            PermutationHelper(nums, 0, res);
        }
        return res;
    }
    void PermutationHelper(int[] cs, int i, List<List<Integer>> list) {
        if(i == cs.length - 1) {
            List<Integer> item = new ArrayList<>();
            for (int c : cs) {
                item.add(c);
            }
            list.add(item);
        } else {
            for(int j = i; j < cs.length; ++j) {
                swap(cs, i, j);
                PermutationHelper(cs, i + 1,list);
                swap(cs, i, j);
            }
        }
    }
    void swap(int[] cs,int i,int j){
        int temp=cs[i];
        cs[i]=cs[j];
        cs[j]=temp;
    }
}

