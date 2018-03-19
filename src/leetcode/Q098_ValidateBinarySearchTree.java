package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SunLin on 2018.3.19
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * 2
 * / \
 * 1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 * 1
 * / \
 * 2   3
 * Binary tree [1,2,3], return false.
 */
public class Q098_ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root==null)
            return true;
        List<Integer> res = new ArrayList<>();
        helper(res,root);
        for (int i=1;i<res.size();i++){
            if (res.get(i-1)>=res.get(i))
                return false;
        }
        return true;
    }

    void helper(List<Integer> list,TreeNode root){
        if (root==null)
            return;
        helper(list,root.left);
        list.add(root.val);
        helper(list,root.right);
    }
}
