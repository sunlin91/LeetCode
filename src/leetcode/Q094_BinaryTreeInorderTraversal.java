package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by SunLin on 2018.3.19
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree [1,null,2,3],
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Q094_BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null)
            return res;
        inorder(root,res);
        return res;
    }

//    void inorder(TreeNode root,List<Integer> res){
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()){
//            while (stack.peek().left != null) {
//                stack.push(stack.peek().left);
//            }
//            while (!stack.isEmpty()) {
//                TreeNode node = stack.pop();
//                res.add(node.val);
//                if (node.right != null) {
//                    stack.push(node.right);
//                    break;
//                }
//            }
//        }
//    }

    //递归
    void inorder(TreeNode root,List<Integer> res){
        if (root==null)
            return;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}
