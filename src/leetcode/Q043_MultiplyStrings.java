package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUN on 2018/2/4
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Q043_MultiplyStrings {
    //other ans
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    //通过，需要优化
//    public String multiply(String num1, String num2) {
//        if(num1==null||num2==null||num1.length()==0
//                ||num2.length()==0||num1.equals("0")||num2.equals("0"))
//            return "0";
//        String res = new String("");
//        List<String> list = new ArrayList(num2.length());//存放每一位的成绩
//        for(int i=num2.length()-1;i>=0;i--){
//            list.add(multiplyByEach(num1,num2.charAt(i)+""));
//        }
//        res=new StringBuilder(list.get(0)).reverse().toString();
//        for(int i=1;i<list.size();i++){
//            StringBuilder end=new StringBuilder("");
//            for(int j=0;j<i;j++){
//                end.append("0");
//            }
//            res=addByEach(res,new StringBuilder(end+list.get(i)).reverse().toString());
//            res=new StringBuilder(res).reverse().toString();
//        }
//        return res;
//    }
//    //123*3按位相乘
//    String multiplyByEach(String num1,String s){
//        int itemOfNum2=Integer.parseInt(s);
//        int carry=0;//进位
//        int itemOfNum1=0;//第一个数的每一位
//        int result=0;
//        StringBuilder res=new StringBuilder("");
//        for(int i=num1.length()-1;i>=0;i--){
//            itemOfNum1=num1.charAt(i)-48;
//            result=itemOfNum1*itemOfNum2+carry;
//            res.append(result%10);
//            carry=result/10;
//        }
//        if(carry>0)
//            res.append(carry);
//        return res.toString();//此时结果是反的
//    }
//
//    //按位相加，结果本来就是反的，所有从0开始，即低位在前
//    String addByEach(String num1,String num2) {
//        String tmp;//保证num1比较长
//        if(num2.length()>num1.length()){
//            tmp=num1;
//            num1=num2;
//            num2=tmp;
//        }
//
//        num1=new StringBuilder(num1).reverse().toString();
//        num2=new StringBuilder(num2).reverse().toString();
//        int len1=num1.length();
//        int len2=num2.length();
//        int carry=0;//进位
//        int result=0;
//        StringBuilder res = new StringBuilder("");
//        for (int i=0;i<len1&&i<len2;i++){
//            result=carry+num1.charAt(i)+num2.charAt(i)-96;
//            res.append(result%10);
//            carry=result/10;
//        }
//        for(int i=len2;i<len1;i++){
//            result=carry+num1.charAt(i)-48;
//            res.append(result%10);
//            carry=result/10;
//        }
//        if(carry>0)
//            res.append(carry);
//        return res.toString();
//    }
}
