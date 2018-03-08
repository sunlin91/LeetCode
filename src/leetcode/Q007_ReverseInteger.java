package leetcode; /**
 * Created by SUN on 2017.11.22.
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 * Input: 123
 * Output:  321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class Q007_ReverseInteger {
    // 2147483647
    //-2147483648
    public int reverse(int x) {
        if(x==0||x==-2147483648)
            return 0;
        int flag=1;
        if(x<0){
            flag=-1;
            x=-x;
        }
        int len=0;
        int[] a = new int[10];
        for(int i=0;x/10>=0&&x>0;i++){
            a[i]=x%10;
            x=x/10;
            len++;
        }
        long result=0;
        for(int i=0;i<len-1;i++){
            result=(result+a[i])*10;
        }
        result+=a[len-1];
        if(flag==1&&result>2147483647L)
            return 0;
        if(flag==-1&&result>2147483648L)
            return 0;
        return (int)result*flag;
    }
}
