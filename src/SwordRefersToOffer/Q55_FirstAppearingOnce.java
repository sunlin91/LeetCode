package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.8
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符
 */
public class Q55_FirstAppearingOnce {
    //Insert one char from stringstream
    char[] chars = new char[256];
    StringBuilder stringBuilder = new StringBuilder();
    public void Insert(char ch) {
        chars[ch]++;
        stringBuilder.append(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char ans = '#';
        for(int i=0;i<stringBuilder.length();i++){
            if(chars[stringBuilder.charAt(i)]==1){
                ans=stringBuilder.charAt(i);
                break;
            }
        }
        return ans;
    }
}
