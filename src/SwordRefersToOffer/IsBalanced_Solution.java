package SwordRefersToOffer;

/**
 * Created by SUN on 2018/3/6
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。

 */
public class IsBalanced_Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次

    private boolean isBalanced=true;
    public boolean IsBalanced_Solution(TreeNode root) {

        getDepth(root);
        return isBalanced;
    }
    public int getDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=getDepth(root.left);
        int right=getDepth(root.right);

        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return right>left ?right+1:left+1;

    }

//    public boolean IsBalanced_Solution(TreeNode root) {
//        if (root==null)
//            return true;
//        int left = TreeDepth(root.left);
//        int right = TreeDepth(root.right);
//        return Math.abs(left-right)<=1&&IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
//
//    }
//    public int TreeDepth(TreeNode root) {
//        if (root == null)
//            return 0;
//        int left = TreeDepth(root.left);
//        int right = TreeDepth(root.right);
//        return (left > right) ? (left + 1) : (right + 1);
//    }
}
