package SwordRefersToOffer;

import java.util.Stack;

/**
 * Created by SunLin on 2018.3.23
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Q27_BSTandDoubleLinkedList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        Stack<TreeNode> s = new Stack();
        s.push(pRootOfTree);
        TreeNode pre=null;
        TreeNode head=null;
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            if(node.left!=null){
                s.push(node);
                s.push(node.left);
                node.left=null;
                continue;
            }
            if(node.right!=null){
                s.push(node.right);
            }
            node.left=pre;
            if(pre!=null){
                pre.right=node;
            }else{
                head=node;
            }
            pre=node;
        }
        return head;
    }
}
