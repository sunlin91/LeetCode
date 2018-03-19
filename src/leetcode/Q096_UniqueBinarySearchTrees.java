package leetcode;

/**
 * Created by SunLin on 2018.3.19
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * <p>
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3
 */
public class Q096_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n==0||n==1){
            return 1;
        }
        int[] nums=new int[n+1];
        nums[0]=1;
        nums[1]=1;

        for(int i=2;i<=n;i++){
            int sum=0;
            for(int j=0;j<=i-1;j++){
                sum+=nums[j]*nums[i-j-1];
            }
            nums[i]=sum;
        }

        return nums[n];
    }
}
