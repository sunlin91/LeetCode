package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Q14_OddBeforeEven {
    //相对位置不变
    public void reOrderArray2(int[] a) {
        if (a == null || a.length == 0)
            return;
        int i = 0, j;
        while (i < a.length) {
            while (i < a.length && !isEven(a[i]))
                i++;
            j = i + 1;//关键是这里
            while (j < a.length && isEven(a[j]))
                j++;
            if (j < a.length) {
                int tmp = a[j];
                for (int j2 = j - 1; j2 >= i; j2--) {
                    a[j2 + 1] = a[j2];
                }
                a[i++] = tmp;
            } else {// 查找失敗
                break;
            }
        }
    }

    boolean isEven(int n) {
        if (n % 2 == 0)
            return true;
        return false;
    }
//    //相对位置会改变
//    public void reOrderArray(int [] array) {
//        if (array==null||array.length<=1)
//            return;
//        int left = 0,right = array.length-1;
//        while (left<right){
//            while (left<right&array[left]%2==1){
//                left++;
//            }
//            while (left<right&array[right]%2==0){
//                right--;
//            }
//            if (left<right){
//                int tmp = array[left];
//                array[left]=array[right];
//                array[right]=tmp;
//            }
//        }
//    }
    //相对位置不变
//    public void reOrderArray(int [] array) {
//        int num = 0;
//        for(int a : array){
//            if(a%2==1)
//                num++;
//        }
//        int[] array1=new int[num];
//        int pos=array.length-1;
//        for(int i=array.length-1,j=num-1;i>=0;i--){
//            if(array[i]%2==1){
//                array1[j]=array[i];
//                j--;
//                continue;
//            }
//            else{
//                if(pos==i){
//                    pos--;
//                    continue;
//                }else{
//                    array[pos]=array[i];
//                    pos--;
//                }
//            }
//        }
//        for(int i=0;i<num;i++){
//            array[i]=array1[i];
//        }
//    }
}
