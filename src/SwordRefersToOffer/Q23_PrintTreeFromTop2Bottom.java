package SwordRefersToOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Q23_PrintTreeFromTop2Bottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            res.add(node.val);
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
        }
        return res;
    }

    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        int i=0,j=0;
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        j=1;
        TreeNode pos = root;
        while(i!=j){
            pos = queue.get(i);
            result.add(pos.val);
            i++;
            if(pos.left!=null){
                queue.add(pos.left);
                j++;
            }
            if(pos.right!=null){
                queue.add(pos.right);
                j++;
            }
        }
        return result;
    }
}
