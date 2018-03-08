package SwordRefersToOffer;

import java.util.ArrayList;

/**
 * Created by SunLin on 2018.3.8
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Q65_maxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num==null||num.length==0||size==0||size>num.length){
            return res;
        }
        for(int i=0;i<=num.length-size;i++){
            res.add(findMax(num,i,i+size-1));
        }
        return res;
    }

    int findMax(int[] a,int start,int end){
        int maxNum=a[start];
        for(int i=start+1;i<=end;i++){
            if (a[i]>maxNum)
                maxNum=a[i];
        }
        return maxNum;
    }
}
