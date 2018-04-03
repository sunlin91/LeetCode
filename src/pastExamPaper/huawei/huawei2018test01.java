package pastExamPaper.huawei;

import java.util.Scanner;

/**
 * 100%
 */
public class huawei2018test01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(longestPalindrome(input));
    }

    public static int longestPalindrome(String s) {
        int sLength = s.length();
        int maxLength = 1;
        for (int i = 0; i < sLength; i++) {
            int p = i - 1;
            int q = i + 1;
            while (q < sLength && s.charAt(i) == s.charAt(q)) {
                q++;
            }
            while (p >= 0 && q < sLength && s.charAt(p) == s.charAt(q)) {
                p--;
                q++;
            }
            if (q - p - 1 > maxLength) {
                maxLength = q - p - 1;
            }
        }
        return maxLength;
    }
}