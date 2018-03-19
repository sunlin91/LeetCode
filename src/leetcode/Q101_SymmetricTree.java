package leetcode;

/**
 * Created by SunLin on 2018.3.19
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *     3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class Q101_SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        return isMirrorTree(root.left,root.right);
    }
    boolean isMirrorTree(TreeNode p, TreeNode q) {
        if ((p==null&&q!=null)||(p!=null&&q==null))
            return false;
        if (p==null&&q==null)
            return true;
        return p.val==q.val&&isMirrorTree(p.left,q.right)&&isMirrorTree(p.right,q.left);
    }
}
