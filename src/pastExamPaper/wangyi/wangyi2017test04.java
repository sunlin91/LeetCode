package pastExamPaper.wangyi;

import java.util.Scanner;

/**
 * Created by SunLin on 2018.3.27
 * 黑暗的字符串
 * 字符串只包含ABC三种字符，任意位置长度为3的子串恰好ABC各包含一个则不是黑暗字符串。
 * 求长度n的字符串为黑暗字符串的长度。
 * 如，AAAAA不是，AAABC，BBBAC是
 */
public class wangyi2017test04 {

    public static void main(String[] args){
        int n = new Scanner(System.in).nextInt();
        long[] dp1 = new long[n+1];
        long[] dp2 = new long[n+1];
        dp1[1]=0;
        dp1[2]=3;
        dp2[1]=3;
        dp2[2]=6;
        for (int i=3;i<=n;i++){
            dp1[i]=dp1[i-1]+dp2[i-1];
            dp2[i]=dp1[i-1]*2+dp2[i-1];
        }
        System.out.println(dp1[n]+dp2[n]);
    }
}
