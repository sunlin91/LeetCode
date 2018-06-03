package leetcode;

/**
 * Created by SUN on 2018/6/3
 * <p>
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * 1
 * / \
 * 2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 * <p>
 * Input: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 * / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class Q129_SumRoottoLeafNumbers {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args){
        TreeNode r = new TreeNode(4);
        r.left=new TreeNode(9);
        r.right=new TreeNode(0);
        r.left.left=new TreeNode(5);
        r.left.right=new TreeNode(1);
        System.out.println(sumNumbers(r));
    }

    public static int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    static int helper(TreeNode root,int cur){
        if (root==null){
            return cur;
        }
        if (root.left==null&&root.right==null)
            return root.val+cur;
        cur+=root.val;
        if (root.left!=null&&root.right!=null)
            return helper(root.left,cur*10)+helper(root.right,cur*10);
        if (root.left!=null)
            return helper(root.left,cur*10);
        if (root.right!=null)
            return helper(root.right,cur*10);
        return 0;
    }
}
