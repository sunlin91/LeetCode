package pastExamPaper.toutiao;

import java.util.Scanner;

/**
 * Created by SunLin on 2018.3.21
 * 题目描述
 * <p>
 * 给定整数m以及n个数字A1, A2, …, An，将数列A中所有元素两两异或，
 * 共能得到n(n-1)/2个结果。请求出这些结果中大于m的有多少个。
 * 输入
 * 第一行包含两个整数n, m。
 * 第二行给出n个整数A1, A2, …, An。
 * 样例输入
 * 3 10
 * 6 5 10
 * 输出
 * 输出仅包括一行，即所求的答案。
 * 样例输出
 * 2
 */
//未解出
public class toutiao2017qiuzhao02 {
    static int m;

    public static long findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < nums.length; i++) {
            TrieNode r = root;
            for (int j = 17; j >= 0; j--) {
                int k = ((1 << j) & nums[i]) >>> j;
                if (r.next[k] == null) {
                    r.next[k] = new TrieNode();

                    r.next[k].digits = 0;
                }
                r.next[k].digits++;
                r = r.next[k];
            }
        }
        long res = 0;
        for (int i = 0; i < nums.length; i++)
            res += count(root, nums[i]);
        return res / 2;
    }


    public static int count(TrieNode r, int x) {
        int res = 0;
        for (int j = 17; j >= 0; j--) {
            int k = (((1 << j) & m) >>> j);
            int p = (((1 << j) & x) >>> j);

            if (k == 0) {
                if (r.next[p ^ 1] != null)
                    res += r.next[p ^ 1].digits;
                r = r.next[p];
            } else {
                r = r.next[p ^ 1];
            }

            if (r == null) break;
        }
        return res;
    }

    public static class TrieNode {
        TrieNode[] next = new TrieNode[2];
        int digits = 0;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        m = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        System.out.println(findMaximumXOR(nums));
    }
}
