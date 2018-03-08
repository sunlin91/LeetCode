package SwordRefersToOffer;

import java.util.LinkedList;

/**
 * Created by SunLin on 2018.3.8
 * 0,1,...,n-1这n个数字排成一个圈，从0开始每次从这个圈中删除第m个数字。求剩下的最后一个数字。
 */
public class Q45_LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n==0||m==0)
            return -1;
        m--;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            list.addLast(i);
        }
        int nextNum=0;//判断列表剩下的数是否大于要减的数
        while (list.size()>1){
            int index;
            if (m<nextNum){
                index=list.size()-1-(nextNum-m-1);
            }else {
                index = (m-nextNum)%list.size();
            }
            nextNum=list.size()-index-1;
            list.remove(index);

        }
        return list.getFirst();
    }
}
