package SwordRefersToOffer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by SUN on 2018/3/6
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        int[] charArrays = new int[52];
        Queue q = new ArrayDeque();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            int index = 0;
            if(c>'Z'){
                index=c-'a'+26;
            }else {
                index=c-'A';
            }
            if(charArrays[index]==0){
                q.add(c);
                charArrays[index]++;
            }else {
                charArrays[index]++;
            }
        }
        char result=0;
        while (q.size()>0){
            int index =0;
            char c = (char) q.poll();
            if(c>'Z'){
                index=c-'a'+26;
            }else {
                index=c-'A';
            }
            if(charArrays[index]==1){
                result = (char) (index>25?'a'+(index-26):('A'+index));
                break;
            }
        }
        if (result==0)
            return -1;
        return str.indexOf(result);
    }
}
