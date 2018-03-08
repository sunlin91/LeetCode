package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.8
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Q58_GetNext {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode==null)
            return null;
        if (pNode.right!=null){
            TreeLinkNode tln = pNode.right;
            while (tln.left!=null)
                tln=tln.left;
            return tln;
        }else if(pNode.next!=null){
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode pParent = pNode.next;
            while (pParent!=null&&pCurrent==pParent.right){
                pCurrent=pParent;
                pParent=pParent.next;
            }
            return pParent;
        }
        return null;
    }
}
