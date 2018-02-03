import java.util.Arrays;

/**
 * Created by SUN on 2017.12.20.
 * Implement next permutation, which rearranges numbers into
 * the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as
 * the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column
 * and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Q031_NextPermutation {
    //从后往前找到第一个下降的点p，然后往后找到刚好比p大的q
    //交换p和q，对[p+1:]排序
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length<=1)
            return;
        int p=-1,q=-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                p=i-1;
                break;
            }
        }
        if (p==-1){
            Arrays.sort(nums);
            return;
        }
        for(int i=p+1;i<nums.length;i++){
            if(nums[i]<=nums[p]){
                q=i-1;
                break;
            }
            q=i;
        }

        int tmp=nums[p];
        nums[p]=nums[q];
        nums[q]=tmp;
        for(int i=1;i<=(nums.length-p-1)/2;i++){
            int temp=nums[i+p];
            nums[p+i]=nums[nums.length-i];
            nums[nums.length-i]=temp;
        }
    }
}
