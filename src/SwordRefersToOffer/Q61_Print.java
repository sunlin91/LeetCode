package SwordRefersToOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by SunLin on 2018.3.8
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Q61_Print {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        int flag = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            //出队同时子女入队
            Deque<Integer> deque = new ArrayDeque<>();
            Queue<TreeNode> tmp = new ArrayDeque<>();
            if (flag % 2 == 1) {//从左到右
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    if (node.left != null)
                        tmp.add(node.left);
                    if (node.right != null)
                        tmp.add(node.right);
                    deque.addFirst(node.val);
                }
            } else if (flag % 2 == 0) {
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    if (node.left != null)
                        tmp.add(node.left);
                    if (node.right != null)
                        tmp.add(node.right);
                    deque.addLast(node.val);
                }
            }
            flag++;
            queue.addAll(tmp);
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(deque);
            res.add(list);
        }
        return res;
    }
}
