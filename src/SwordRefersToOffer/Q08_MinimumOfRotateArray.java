package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Q08_MinimumOfRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array==null||array.length==0)
            return 0;
        int min =array[0];
        for (int i=1;i<array.length;i++){
            if (array[i]<min){
                return array[i];
            }
        }
        return min;
    }
    //二分查找
//    public int minNumberInRotateArray(int [] array) {
//        if(array.length==0)
//            return 0;
//        int low=0;
//        int high=array.length-1;
//        int mid=(high+low)/2;
//        while(array[low]>=array[high]){
//            if(high-low==1){
//                mid=high;
//                break;
//            }
//            if (array[mid] > array[high]) {
//                low = mid;
//                mid = (high + low) / 2;
//            } else if(array[mid] <= array[high]){
//                high = mid;
//                mid = (high + low) / 2;
//            }
//        }
//        return array[mid];
//    }
}
