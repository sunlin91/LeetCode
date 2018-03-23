package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.23
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Q29_MoreThanHalfNumber {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null|| array.length==0)
            return 0;
        int num = array[0];
        int count = 1;
        for (int i=1;i<array.length;i++){
            if (array[i]==num){
                count++;
            }else {
                count--;
                if (count==-1){
                    num=array[i];
                    count=1;
                }
            }
        }
        if (count==0)
            return 0;
        count=0;
        for (int i=0;i<array.length;i++){
            if (num==array[i])
                count++;
        }
        return count>array.length/2?num:0;
    }
}
//    public int MoreThanHalfNum_Solution(int [] array) {
//        if(array==null)
//            return 0;
//        int flag=1;
//        int number=array[0];
//        for(int i=1;i<array.length;i++){
//            if(flag==0){
//                number=array[i];
//                flag++;
//                continue;
//            }
//            else if(array[i]==number){
//                flag++;
//            }
//            else{
//                flag--;
//            }
//        }
//        if(flag==0){
//            return 0;
//        }
//        flag=0;
//        for(int i=0;i<array.length;i++){
//            if(array[i]==number){
//                flag++;
//            }
//        }
//        if(flag>array.length/2){
//            return number;
//        }else{
//            return 0;
//        }
//    }