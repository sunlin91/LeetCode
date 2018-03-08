package SwordRefersToOffer;

import java.util.ArrayList;

/**
 * Created by SunLin on 2018.3.8
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class Q41_FindNumbersWithSum {
    //更简洁
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        if (array==null||array.length==0){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        int left=0,right=array.length-1;
        while (left<right){
            if(array[left]+array[right]==sum){
                result.add(array[left]);
                result.add(array[right]);
                break;
            }
            while(left < right && array[left] + array[right] > sum) --right;
            while(left < right && array[left] + array[right] < sum) ++left;
        }
        return result;
    }
    //通过
//    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
//        if (array==null||array.length==0){
//            return new ArrayList<Integer>();
//        }
//        ArrayList<Integer> result = new ArrayList<>();
//        int left=0,right=0;
//        for(int i=0;i<array.length;i++){
//            if(array[i]<sum/2)
//                continue;
//            if(array[i]==sum/2){
//                if(i==0||i==array.length-1)
//                    return null;
//                left=i-1;
//                right=i+1;
//                break;
//            }
//            if (array[i]>sum/2&&i==0)
//                return null;
//            if (array[i]>sum/2){
//                left=i-1;
//                right=i;
//            }
//        }
//        int minProduct=Integer.MAX_VALUE;
//        while (left>=0&&right<array.length){
//            if((array[left]+array[right]==sum)&&(array[left]*array[right]<=minProduct)){
//                result.clear();
//                result.add(array[left]);
//                result.add(array[right]);
//                left--;
//                right++;
//                continue;
//            }
//            if(array[left]+array[right]<sum){
//                right++;continue;
//            }
//            if (array[left]+array[right]>sum){
//                left--;continue;
//            }
//        }
//        return result;
//    }
}
