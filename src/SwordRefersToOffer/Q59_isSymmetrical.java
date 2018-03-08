package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.8
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Q59_isSymmetrical {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot,pRoot);
    }

    boolean isSymmetrical(TreeNode left,TreeNode right){
        if(left==null&&right==null)
            return true;
        if (left==null||right==null)
            return false;
        if(left.val!=right.val)
            return false;
        //比较左左右右，左右右左
        return isSymmetrical(left.left,right.right)&&isSymmetrical(left.right,right.left);
    }
}
