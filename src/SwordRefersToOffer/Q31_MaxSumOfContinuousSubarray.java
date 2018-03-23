package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.23
 * 题目描述
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,
 * 他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Q31_MaxSumOfContinuousSubarray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null)
            return 0;
        int maxSum = array[0];
        int cur = array[0];
        for (int i = 1; i < array.length; i++) {
            cur += array[i];
            if (cur <= 0) {
                if (i+1<array.length&&array[i+1]>=0)
                    cur=0;
                else
                    cur = array[i];
            }
            if (maxSum < cur) {
                maxSum = cur;
            }
        }
        return maxSum;
    }
}
//    public int FindGreatestSumOfSubArray(int[] array) {
//        if(array.length<1)
//            return 0;
//        int result=Integer.MIN_VALUE;
//        int max=array[0];
//        boolean flag=false;
//        for(int i=0;i<array.length;i++){
//            if(array[i]>0){
//                flag=true;
//                break;
//            }
//            if(max<array[i]){
//                max=array[i];
//            }
//        }
//        if(!flag)
//            return max;
//        for(int i=1;i<array.length;i++){
//            if(max+array[i]>0){
//                max+=array[i];
//                if(max>result){
//                    result=max;
//                }
//            }else{
//                max=0;
//            }
//        }
//        return result;
//    }