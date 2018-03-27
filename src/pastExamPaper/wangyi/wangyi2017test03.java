package pastExamPaper.wangyi;

import java.util.Scanner;

/**
 * Created by SunLin on 2018.3.27
 * 数字翻转（考虑大数问题）
 * 输入x，y
 * 输出res(res(x)+res(y))
 */
public class wangyi2017test03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextInt()+"";
        String s2 = sc.nextInt()+"";
        System.out.println(rev(add(rev(s1),rev(s2))));
    }

    //求翻转
    private static String rev(String s){
        StringBuilder res = new StringBuilder("");
        int p=s.length()-1;//找到后面第一个不为0的位置
        while (p>=0&&s.charAt(p)=='0'){
            p--;
        }
        if (p<0)
            return "0";
        while (p>=0){
            res.append(s.charAt(p));
            p--;
        }
        return res.toString();
    }

    //计算加法
    private static String add(String s1,String s2){
        StringBuilder sb = new StringBuilder("");
        int carry=0;
        int a,b;
        int p1=s1.length()-1;
        int p2=s2.length()-1;
        while (p1>=0&&p2>=0){
            int res = carry+s1.charAt(p1)-'0'+s2.charAt(p2)-'0';
            carry=res/10;
            res%=10;
            sb.append(res);
            p1--;p2--;
        }

        while (p1>=0){
            int res = carry+s1.charAt(p1)-'0';
            carry=res/10;
            res%=10;
            sb.append(res);
            p1--;
        }
        while (p2>=0){
            int res = carry+s2.charAt(p2)-'0';
            carry=res/10;
            res%=10;
            sb.append(res);
            p2--;
        }
        return sb.reverse().toString();
    }
}
