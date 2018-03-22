package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Q10_NumberOf1sInBinary {
    public int NumberOf1(int n) {
        int res = 0;
        while (n>0){
            res+=(n&0x1)==0x1?1:0;
            n=n>>>1;
        }
        return res;
    }
}
