package leetcode;

import java.util.Stack;

/**
 * Created by SUN on 2018/5/2
 * Given a binary tree, flatten it to a linked list in-place.
 For example, given the following tree:

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:

 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 */

public class Q114_FlattenBinaryTreetoLinkedList {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * tmp = root.right
     * root.right = root.left
     * root.left=null
     * root.right.right=tmp
     * 不需要排序啥的
     */
    public void flatten(TreeNode root) {

        if(null == root)
            return;

        root.right = flatten_dfs(root).right;
        root.left = null;
    }

    TreeNode flatten_dfs(TreeNode root) {

        if(null == root)
            return null;

        TreeNode head = new TreeNode(-1);
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        TreeNode previous = head;
        while (!nodes.isEmpty()) {
            TreeNode next = nodes.pop();
            previous.right = next;
            previous.left = null;

            if(null != next.right)
                nodes.push(next.right);

            if(null != next.left)
                nodes.push(next.left);

            previous = next;
        }

        return head.right;
    }

}
