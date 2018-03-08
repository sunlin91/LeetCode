package SwordRefersToOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by SunLin on 2018.3.8
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Q60_Print {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot==null)
            return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            Queue<TreeNode> tmp = new ArrayDeque<>();
            ArrayList<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if (node.left != null)
                    tmp.add(node.left);
                if (node.right != null)
                    tmp.add(node.right);
                list.add(node.val);
            }
            queue.addAll(tmp);
            res.add(list);
        }
        return res;
    }
}
