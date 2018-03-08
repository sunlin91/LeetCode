package leetcode; /**
 * Created by SUN on 2017.11.22.
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 * <p>
 * Update (2015-02-10):
 * The signature of the C++ function had been updated.
 * If you still see your function signature accepts a const char * argument,
 * please click the reload button  to reset your code definition.
 * <p>
 * spoilers alert... click to show requirements for atoi.
 */
public class Q008_StringtoInteger_atoi {
    // 2147483647
    //-2147483648
    public int myAtoi(String str) {
        if(str==null||str.length()<=0)
            return 0;
        int start=0;
        while (str.charAt(start)==' '){
            start++;
        }
        int flag=1;
        int i =start;
        long result=0;
        if(str.charAt(start)=='-') {
            if(str.length()<=1+start)
                return 0;
            flag = -1;
            i=1+start;
        }
        if(str.charAt(start)=='+') {
            i = 1+start;
            if(str.length()<=1+start)
                return 0;
        }
        while (str.charAt(i)==' '){
            return 0;
        }
        while (str.charAt(i)=='0'){
            i++;
        }
        for(;i<str.length()-1;i++){
            char a=str.charAt(i);
            if(a>'9'||a<'0')
                break;
            result=(result+((int)a-48))*10;
            if(flag==1&&result/10>2147483647L)
                return 2147483647;
            if(flag==-1&&result/10>2147483648L)
                return -2147483648;
        }
        if(i==str.length()-1) {
            if(str.charAt(str.length()-1)>='0'&&str.charAt(str.length()-1)<='9')
                result += (str.charAt(str.length() - 1) - 48);
            else
                result/=10;
        }
        else
            result/=10;
        System.out.println(result);
        if(flag==1&&result>2147483647L)
            return 2147483647;
        if(flag==-1&&result>2147483648L)
            return -2147483648;
        return (int)result*flag;
    }
}
