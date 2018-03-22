package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 */
public class Q19_BinaryTreeMirroring {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if (root==null)
            return;
        helper(root,root.left,root.right);
    }
    void helper(TreeNode root,TreeNode r1,TreeNode r2){
        if (root==null)
            return;
        root.left=r2;
        root.right=r1;
        if (r1!=null)
            helper(r1,r1.left,r1.right);
        if (r2!=null)
            helper(r2,r2.left,r2.right);
    }
    public void Mirror2(TreeNode root) {
        if(root==null)
            return;
        Mirror(root.left);
        Mirror(root.right);
        if(root.left!=null||root.right!=null){
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
        return;
    }
}
