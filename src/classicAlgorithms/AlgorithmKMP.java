package classicAlgorithms;

/**
 * Created by SunLin on 2018.3.28
 */
public class AlgorithmKMP {
    //KMP算法主函数
    public static int kmp(String str, String sub) {
        int j = 0;
        int[] n = next(sub);//初始化next数组
        for (int i = 0; i < str.length(); i++) {
            //如果字符不匹配，更新j的值，也就是计算往右滑动多少的过程
            while(j > 0 && str.charAt(i) != sub.charAt(j)){
                j = n[j - 1];
            }
            if(str.charAt(i) == sub.charAt(j)){
                j++;
            }
            if(sub.length() == j){
                return i - j + 1;
            }
        }
        return -1;
    }
    //初始化next数组的函数
    private static int[] next(String sub) {
        int[] next = new int[sub.length()];
        int x = 0;
        for (int i = 1; i < sub.length(); i++) {
            while (x > 0 && sub.charAt(i) != sub.charAt(x)) {
                x = next[x - 1];
            }
            if (sub.charAt(i) == sub.charAt(x)) {
                x++;
            }
            next[i] = x;
        }
        return next;
    }
    //测试
    public static void main(String[] args) {
        String str = "xbaabaabcacabcacba";
        String sub = "abaabcac";
        int index = kmp(str, sub);
        System.out.println(index);
    }
}
