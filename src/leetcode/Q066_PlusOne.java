package leetcode;

/**
 * Created by SunLin on 2018.3.16
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class Q066_PlusOne {
    public static void main(String[] a){
        Q066_PlusOne q = new Q066_PlusOne();
        q.plusOne(new int[]{1,2,3});
    }
    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1;i>=0;i--){
            digits[i]+=1;
            if (digits[i]==10&&i>0){
                digits[i]=0;
            }else {
                break;
            }
        }
        int n=digits.length;
        if (digits[0]==10){
            n++;
            int[] res = new int[n];
            digits[0]=0;
            res[0]=1;
            for (int i=1;i<n;i++){
                res[i]=digits[i-1];
            }
            return res;
        }else {
            int[] res = new int[n];
            for (int i=0;i<n;i++){
                res[i]=digits[i];
            }
            return res;
        }
    }
}
