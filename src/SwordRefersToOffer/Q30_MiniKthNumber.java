package SwordRefersToOffer;

import java.util.ArrayList;

/**
 * Created by SunLin on 2018.3.23
 * 题目描述
 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Q30_MiniKthNumber {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList();
        if(input.length==0||k>input.length){
            return result;
        }
        return heapSort(input,k);
    }
    //堆排序
    ArrayList<Integer> heapSort(int[] a,int k){
        ArrayList<Integer> result = new ArrayList();
        buildMaxHeap(a);
        for(int i=a.length-1;i>=0&&k>0;k--,i--){
            int temp=a[i];
            a[i]=a[0];
            result.add(a[i]);
            a[0]=temp;
            adjustDown(a,0,i-1);
        }
        return result;
    }
    void buildMaxHeap(int[] a){
        for(int i=a.length/2;i>=0;i--)
            adjustDown(a,i,a.length-1);
    }
    void adjustDown(int[] a,int k,int len){
        //将元素i向下调整
        int tem=a[k];
        for(int i=2*k;i<=len;i*=2){
            if(i<len&&a[i]>a[i+1])
                i++;
            if(tem<=a[i])
                break;
            else {
                a[k]=a[i];
                k=i;
            }
            a[k]=tem;
        }
    }
}