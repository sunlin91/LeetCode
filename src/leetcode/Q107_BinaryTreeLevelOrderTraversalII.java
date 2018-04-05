package leetcode;

import java.util.*;

/**
 * Created by SunLin on 2018.4.4
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class Q107_BinaryTreeLevelOrderTraversalII {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root==null)
            return res;
        List<Integer> cur = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> curQueue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            cur.add(node.val);
            if (node.left!=null)
                curQueue.offer(node.left);
            if (node.right!=null)
                curQueue.offer(node.right);
            if (queue.isEmpty()&&!curQueue.isEmpty()){
                queue.addAll(curQueue);
                curQueue.clear();
                res.add(0,cur);
                cur=new ArrayList<>();
            }
        }
        if (cur.size()>0)
            res.add(0,cur);
        return res;
    }

    //DFS solution:
    public class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

            if(root == null) return wrapList;

            queue.offer(root);
            while(!queue.isEmpty()){
                int levelNum = queue.size();
                List<Integer> subList = new LinkedList<Integer>();
                for(int i=0; i<levelNum; i++) {
                    if(queue.peek().left != null) queue.offer(queue.peek().left);
                    if(queue.peek().right != null) queue.offer(queue.peek().right);
                    subList.add(queue.poll().val);
                }
                wrapList.add(0, subList);
            }
            return wrapList;
        }
    }
//    BFS solution:

    public class Solution2 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
            levelMaker(wrapList, root, 0);
            return wrapList;
        }

        public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
            if(root == null) return;
            if(level >= list.size()) {
                list.add(0, new LinkedList<Integer>());
            }
            levelMaker(list, root.left, level+1);
            levelMaker(list, root.right, level+1);
            list.get(list.size()-level-1).add(root.val);
        }
    }
}