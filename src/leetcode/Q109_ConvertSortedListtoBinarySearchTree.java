package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SunLin on 2018.4.4
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in
 * which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted linked list: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Q109_ConvertSortedListtoBinarySearchTree {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head==null)
            return null;
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p!=null){
            list.add(p.val);
            p=p.next;
        }
        return helper(list.toArray(),0,list.size()-1);
    }

    TreeNode helper(Object[] nums,int start,int end){
        if (nums==null||nums.length==0||start>end)
            return null;
        int mid = (end+start)/2;
        TreeNode root = new TreeNode((Integer) nums[mid]);
        root.left = helper(nums,start,mid-1);
        root.right = helper(nums,mid+1,end);
        return root;
    }

//    class Solution {
//        public TreeNode sortedListToBST(ListNode head) {
//            if (head == null) return null;
//            return toBST(head, null);
//        }
//
//        public TreeNode toBST(ListNode head, ListNode tail) {
//            ListNode slow = head;
//            ListNode fast = head;
//            if (head == tail) return null;
//
//            while (fast != tail && fast.next != tail) {
//                fast = fast.next.next;
//                slow = slow.next;
//            }
//            TreeNode thead = new TreeNode(slow.val);
//            thead.left = toBST(head, slow);
//            thead.right = toBST(slow.next, tail);
//            return thead;
//        }
//    }
}
