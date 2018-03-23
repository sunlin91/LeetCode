package SwordRefersToOffer;

import java.util.ArrayList;

/**
 * Created by SunLin on 2018.3.23
 * 题目描述
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Q25_ValuePathInBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if (target < 0)
            return listAll;
        if (target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }
//    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        ArrayList<Integer> cur = new ArrayList<>();
//        if (root==null)
//            return res;
//        helper(res,cur,root,target);
//        return res;
//    }
//
//    void helper(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> cur,TreeNode root,int target){
//        if (root==null) return;
//        cur.add(root.val);
//        target-=root.val;
//        if (target<0)
//            return;
//        if(target == 0 && root.left == null && root.right == null)
//            res.add(new ArrayList<Integer>(cur));
//        helper(res,cur,root.left, target);
//        helper(res,cur,root.right, target);
//        cur.remove(cur.size()-1);
//    }

}