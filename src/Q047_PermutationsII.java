import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SUN on 2018/2/7
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class Q047_PermutationsII {
    //使用一个boolean数组
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }

    //accept
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums != null && nums.length > 0) {
//            PermutationHelper(nums, 0, res);
//        }
//        return res;
//    }
//    void PermutationHelper(int[] cs, int i, List<List<Integer>> list) {
//        if(i == cs.length - 1) {
//            List<Integer> item = new ArrayList<>();
//            for (int c : cs) {
//                item.add(c);
//            }
//            //判断是否重复
//            if (!list.contains(item))
//                list.add(item);
//        } else {
//            for(int j = i; j < cs.length; ++j) {
//                swap(cs, i, j);
//                PermutationHelper(cs, i + 1,list);
//                swap(cs, i, j);
//            }
//        }
//    }
//    void swap(int[] cs,int i,int j){
//        int temp=cs[i];
//        cs[i]=cs[j];
//        cs[j]=temp;
//    }
}
