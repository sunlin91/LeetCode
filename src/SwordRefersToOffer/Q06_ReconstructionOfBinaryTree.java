package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Q06_ReconstructionOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root;
        if(pre.length>0){
            root = new TreeNode(pre[0]);
            if(in.length>0){
                int i=-1;
                for(int j=0;j<in.length;j++){
                    if(pre[0]==in[j]){
                        i=j;
                    }
                }
                if(i==-1)
                    return null;
                else if(i==0){
                    int[] r_pre = copyArray(pre,i+1,pre.length-1);
                    int[] r_in = copyArray(in,i+1,in.length-1);
                    root.right = reConstructBinaryTree(r_pre,r_in);
                }//没有左子树
                else if(i==in.length-1){
                    int[] l_pre = copyArray(pre,1,i);
                    int[] l_in = copyArray(in,0,i-1);
                    root.left = reConstructBinaryTree(l_pre,l_in);
                }//没有右子树
                else{
                    int[] l_pre =copyArray(pre,1,i);
                    int[] l_in = copyArray(in,0,i-1);
                    root.left = reConstructBinaryTree(l_pre,l_in);

                    int[] r_pre = copyArray(pre,i+1,pre.length-1);
                    int[] r_in = copyArray(in,i+1,in.length-1);
                    root.right = reConstructBinaryTree(r_pre,r_in);

                }
            }
            return root;
        }
        else{
            return null;
        }
    }
    public int[] copyArray(int[] a,int start,int end){
        int[] b = new int[end-start+1];
        for(int i=0;i<end-start+1;i++){
            b[i] = a[start+i];
        }
        return b;
    }
}
