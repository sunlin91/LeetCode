package leetcode;

import java.util.*;

/**
 * Created by SunLin on 2018.3.19
 * Given a collection of integers that might contain duplicates, nums,
 * return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,2], a solution is:
 * <p>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Q090_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return new ArrayList<>(list);
    }

    private void backtrack(Set<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
