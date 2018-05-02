package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUN on 2018/5/2
 * Given a binary tree and a sum, find all root-to-leaf paths
 * where each path's sum equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * Example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class Q113_PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (root==null)
            return res;
        cur.add(root.val);
        helper(root,sum-root.val,res,cur);
        return res;
    }
    void helper(TreeNode root,int sum,List<List<Integer>> res,List<Integer> cur){
        if (root.left==null&&root.right==null){
            if (sum==0){
                List<Integer> list = new ArrayList<>(cur);
                res.add(list);
            }
        }
        if (root.left!=null){
            cur.add(root.left.val);
            helper(root.left,sum-root.left.val,res,cur);
            cur.remove(cur.size()-1);
        }
        if (root.right!=null){
            cur.add(root.right.val);
            helper(root.right,sum-root.right.val,res,cur);
            cur.remove(cur.size()-1);
        }
    }
}
