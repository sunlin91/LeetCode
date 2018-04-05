package pastExamPaper.tenxun;

import java.util.Scanner;

/**
 * Created by SUN on 2018/4/5
 */
public class tengxun2018test01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        if (n%2*m!=0)
            return;
        else {
            long tmp = n/(2*m);
            long res = m*m*tmp;
            System.out.println(res);
        }
    }
}
