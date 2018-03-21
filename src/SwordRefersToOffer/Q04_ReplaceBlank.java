package SwordRefersToOffer;

/**
 * Created by SUN on 2018/3/21
 * 题目描述
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Q04_ReplaceBlank {
    public String replaceSpace(StringBuffer str) {
        if (str==null)
            return str.toString();
        int count = 0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==' ')
                count++;
        }
        int p = str.length()-1;
        str.setLength(str.length()+count*2);
        int q = str.length()-1;
        while (q!=p){
            if (str.charAt(p)!=' '){
                str.setCharAt(q,str.charAt(p));
                p--;q--;
            }else {
                str.setCharAt(q--,'0');
                str.setCharAt(q--,'2');
                str.setCharAt(q--,'%');
                p--;
            }
        }
        return str.toString();
    }
}