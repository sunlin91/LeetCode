package pastExamPaper.jingdong;

import java.util.Scanner;

/**
 * 不通过
 */
public class jingdong2018test01 {
    public static void main(String[] args) {
        System.out.println(new Scanner(System.in).next().trim().length());
        Scanner sc = new Scanner(System.in);
        String str = sc.next().trim();
        int res = 0;
        for (int i=0;i<str.length();i++){
            for (int j=i+1;j<=str.length();j++){
                String sub = str.substring(i,j);
                if (isPalindrome(sub))
                    res++;
            }
        }
        System.out.println(res);
    }

    static boolean isPalindrome(String s){
        if(s==null||"".equals(s))
            return false;
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
