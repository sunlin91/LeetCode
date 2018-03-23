package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.23
 * 题目描述
 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Q24_PostTraversalOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null||sequence.length==0)
            return false;
        return helper(sequence,0,sequence.length-1);
    }
    boolean helper(int[] sequence,int start,int end){
        if (start>=end)
            return true;
        int root = sequence[end];
        int pos = start;
        while (sequence[pos]<root){
            pos++;
        }
        int p = pos;
        while (pos<end){
            if (sequence[pos]<=root)
                return false;
            pos++;
        }
        return helper(sequence,start,p-1)&&helper(sequence,p,end-1);
    }
}

//    public boolean VerifySquenceOfBST(int [] sequence) {
//        if(sequence.length == 0) return false;
//        return IsTreeBST(sequence, 0, sequence.length-1);
//    }
//    public boolean IsTreeBST(int [] sequence,int start,int end ){
//        if(end <= start) return true;
//        int i = start;
//        for (; i < end; i++) {
//            if(sequence[i] > sequence[end]) break;
//        }
//        for (int j = i; j < end; j++) {
//            if(sequence[j] < sequence[end]) return false;
//        }
//        return IsTreeBST(sequence, start, i-1) && IsTreeBST(sequence, i, end-1);
//    }
