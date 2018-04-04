package leetcode;

/**
 * Created by SunLin on 2018.4.4
 * 后序和中序构建二叉树
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Q106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args){
        Q106_ConstructBinaryTreeFromInorderAndPostorderTraversal q = new Q106_ConstructBinaryTreeFromInorderAndPostorderTraversal();
        q.buildTree(new int[]{3,2,1},new int[] {3,2,1});
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length-1, 0, inorder.length - 1, postorder, inorder);
    }

    public TreeNode helper(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
        //这里是后序，start从后往前
        if (postStart < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(postStart - (inEnd-inIndex+1), inStart, inIndex - 1, postorder, inorder);
        root.right = helper(postStart - 1, inIndex + 1, inEnd, postorder, inorder);
        return root;
    }
}
