package SwordRefersToOffer;

import java.util.Stack;

/**
 * Created by SunLin on 2018.3.22
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Q22_StackPushAndPop {
    public static void main(String[] a){
        IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1});
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[0]);
        int p = 1,q = 0;
        while (q<popA.length){
            if (popA[q]==stack.peek()){
                stack.pop();
                q++;
            }else if (p<pushA.length){
                stack.push(pushA[p++]);
            }else
                break;
        }
        return stack.isEmpty();
    }
}
//    public boolean IsPopOrder(int [] pushA,int [] popA) {
//        int[] buff = new int[pushA.length];
//        int pos = 0;
//        for(int i=0,j=0;i<pushA.length;){
//            buff[pos++]=pushA[i++];
//            while (j<popA.length&&buff[pos-1]==popA[j]){
//                pos--;
//                j++;
//            }
//        }
//        return (pos==0)?true:false;
//    }