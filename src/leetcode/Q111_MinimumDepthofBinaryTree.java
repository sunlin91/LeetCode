package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by SunLin on 2018.4.9
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest
 * path from the root node down to the nearest leaf node.
 */
public class Q111_MinimumDepthofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }
//    public int minDepth(TreeNode root) {
//        if (root==null)
//            return 0;
//        int res = 1;
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        Queue<TreeNode> curQueue = new ArrayDeque<>();
//        queue.offer(root);
//        while (!queue.isEmpty()||!curQueue.isEmpty()){
//            TreeNode node = queue.poll();
//            if (node.left==null&&node.right==null)
//                break;
//            if (node.left!=null)
//                curQueue.offer(node.left);
//            if (node.right!=null)
//                curQueue.offer(node.right);
//            if (queue.isEmpty()&&!curQueue.isEmpty()){
//                queue.addAll(curQueue);
//                curQueue.clear();
//                res++;
//            }
//        }
//        return res;
//    }

}
