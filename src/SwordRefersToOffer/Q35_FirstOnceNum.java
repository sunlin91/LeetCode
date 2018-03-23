package SwordRefersToOffer;

import java.util.*;

/**
 * Created by SunLin on 2018.3.23
 * 题目描述
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class Q35_FirstOnceNum {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;
        List<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (set.contains(c)) {
                if (list.contains(c)) {
                    list.remove(c);
                }
            } else {
                set.add(c);
                list.add(c);
            }
        }
        return list.size() > 0 ? str.indexOf(list.get(0)) : 0;
    }
}