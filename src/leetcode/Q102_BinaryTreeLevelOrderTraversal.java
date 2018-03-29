package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by SunLin on 2018.3.29
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class Q102_BinaryTreeLevelOrderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null)
            return res;
        List<Integer> cur = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> curQueue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()||!curQueue.isEmpty()){
            TreeNode node = queue.poll();
            cur.add(node.val);
            if (node.left!=null)
                curQueue.offer(node.left);
            if (node.right!=null)
                curQueue.offer(node.right);
            if (queue.isEmpty()&&!curQueue.isEmpty()){
                queue.addAll(curQueue);
                curQueue.clear();
                res.add(cur);
                cur=new ArrayList<>();
            }
        }
        if (cur.size()>0)
            res.add(cur);
        return res;
    }
}
