package huawei;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by SUN on 2018.3.1.
 * <p>
 * 输入一个字符串，求出该字符串包含的字符集合
 * <p>
 * 输入描述:
 * 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 * <p>
 * <p>
 * 输出描述:
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 * <p>
 * 输入例子1:
 * abcqweracb
 * <p>
 * 输出例子1:
 * abcqwer
 */
public class test05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Set<Character> set = new LinkedHashSet<>();
            String str = sc.next();
            for (int i = 0; i < str.length(); i++) {
                set.add(str.charAt(i));
            }
            for (Character c : set)
                System.out.print(c);
            System.out.println();
        }
    }
}
