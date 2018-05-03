package leetcode;

import java.util.*;

/**
 * Created by SunLin on 2018.5.3
 * Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * Example:
 * <p>
 * Given the following binary tree,
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 * <p>
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \    \
 * 4-> 5 -> 7 -> NULL
 */
public class Q117_PopulatingNextRightPointersinEachNodeII {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }


    //思想很不错！
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                pre = dummyHead;
                root = dummyHead.next;//一开始的dummyHead.next指向改行最左节点
                dummyHead.next = null;
            }
        }
    }

    //虽然过了，但是3.7%好慢
//    public void connect(TreeLinkNode root) {
//        if (root==null)
//            return;
//        Queue<TreeLinkNode> queue = new ArrayDeque<>();
//        List<TreeLinkNode> cur = new ArrayList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            cur.clear();
//            TreeLinkNode pre = new TreeLinkNode(0);
//            while (!queue.isEmpty()){
//                TreeLinkNode node = queue.poll();
//                if (node.left!=null) {
//                    cur.add(node.left);
//                    pre.next = node.left;
//                    pre=pre.next;
//                }
//                if (node.right!=null) {
//                    cur.add(node.right);
//                    pre.next = node.right;
//                    pre=pre.next;
//                }
//            }
//
//            queue.addAll(cur);
//        }
//    }
}
