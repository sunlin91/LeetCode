package leetcode;

/**
 * Created by SunLin on 2018.3.16
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class Q067_AddBinary {

    public String addBinary(String a, String b) {
        if (a==null&&b==null)
            return null;
        if (a==null||a.equals(""))
            return b;
        if (b==null||b.equals(""))
            return a;
        int alen =a.length();
        int blen=b.length();
        if (alen<blen){
            String tmp = a;
            a=b;
            b=tmp;
            alen=a.length();
            blen=b.length();
        }
        StringBuilder res =new StringBuilder();
        StringBuilder pre0 = new StringBuilder();
        for (int i=0;i<alen-blen;i++){
            pre0.append("0");
        }
        b=pre0.toString()+b;
        int flag = 0;//true表示有进位
        for(int i=alen-1;i>=0;i--){
            int achar = a.charAt(i)-'0';
            int bchar = b.charAt(i)-'0';
            int result = flag+achar+bchar;
            res.append(result%2);
            flag=result/2;
        }
        if (flag==1)
            res.append(1);
        return res.reverse().toString();
    }
}
