package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.8
 * 题目描述
 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 输入描述:
 输入一个字符串,包括数字字母符号,可以为空
 输出描述:
 如果是合法的数值表达则返回该数字，否则返回0
 示例1
 输入

 +2147483647
 1a33
 输出

 2147483647
 0
 */
public class Q49_StrToInt {
    public int StrToInt(String str) {
        if (str==null||str.length()==0)
            return 0;
        long result = 0;
        int flag = 1;
        for(int i=0;i<str.length();i++){
            if (i==0){
                if (str.charAt(0)=='+')
                    continue;
                if (str.charAt(0)=='-'){
                    flag=-1;continue;
                }
            }
            if (str.charAt(i)<'0'||str.charAt(i)>'9')
                return 0;
            else {
                result=result*10+(str.charAt(i)-'0');
            }
        }
        result*=flag;
        if (result>Integer.MAX_VALUE||result<Integer.MIN_VALUE)
            return 0;
        return (int)result;
    }
}
