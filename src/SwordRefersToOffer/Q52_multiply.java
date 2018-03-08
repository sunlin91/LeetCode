package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.8
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Q52_multiply {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            //计算下三角连乘
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            //计算上三角
            for (int j = length - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }
    //通过
//    public int[] multiply(int[] A) {
//        if (A==null||A.length==0)
//            return new int[0];
//        int[] left = new int[A.length];
//        int[] right = new int[A.length];
//        int[] result = new int[A.length];
//        left[0]=1;
//        right[A.length-1]=1;
//        for(int i=1;i<A.length-1;i++){
//            left[i]=left[i-1]*A[i-1];
//            right[A.length-1-i]=right[A.length-i]*A[A.length-i];
//        }
//        left[A.length-1]=left[A.length-2]*A[A.length-2];
//        right[0]=right[1]*A[1];
//        for (int i=0;i<A.length;i++){
//            result[i]=left[i]*right[i];
//        }
//        return result;
//    }
}
