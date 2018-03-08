package SwordRefersToOffer;

import java.util.Stack;

/**
 * Created by SunLin on 2018.3.8
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class Q63_KthNode {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot==null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);
        int count=0;
        while (!stack.empty()){
            while (stack.peek().left!=null){
                stack.push(stack.peek().left);
            }
            while (!stack.empty()){
                TreeNode node = stack.pop();
                if (++count==k)
                    return node;
                if (node.right!=null){
                    stack.push(node.right);
                    break;
                }

            }
        }
        return null;
    }
    public static void main(String[] a){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left=node1;
        node2.right=node3;
        node4.left=node2;
        node4.right=node5;
        Q63_KthNode q = new Q63_KthNode();
        System.out.println(q.KthNode(node4,4).val);
    }
}
