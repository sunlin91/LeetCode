package SwordRefersToOffer;

import java.util.Arrays;

/**
 * Created by SUN on 2018/3/6
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);
        boolean flag=false;
        for(int i=1;i<array.length;i++){
            if((i<array.length-1&&array[i]==array[i+1])||array[i]==array[i-1])
                continue;
            if(!flag){
                num1[0]=array[i];
                flag=true;
            }else {
                num2[0]=array[i];
                return;
            }
        }
    }
}
