package leetcode;

/**
 * Created by SunLin on 2018.5.28
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 */
public class Q125_ValidPalindrome {
    public static void main(String[] args){
        System.out.println(isPalindrome("0P"));
    }
    public static boolean isPalindrome(String s) {
        if (s==null||"".equals(s)||s.length()<=1)
            return true;
        int l=0,r=s.length()-1;
        boolean res = true;

        while (l<=r){
            //Character.isLetterOrDigit(char)有现成的方法判断是否是字母或数字
            while (!((s.charAt(l)>='a'&&s.charAt(l)<='z')||
                    (s.charAt(l)>='A'&&s.charAt(l)<='Z')||
                    (s.charAt(l)>='0'&&s.charAt(l)<='9'))){
                l++;
                if (l>r||l>=s.length())
                    break;
            }
            while (!((s.charAt(r)>='a'&&s.charAt(r)<='z')||
                    (s.charAt(r)>='A'&&s.charAt(r)<='Z')||
                    (s.charAt(r)>='0'&&s.charAt(r)<='9'))){
                r--;
                if (r<l||r<0)
                    break;
            }
            if ((l>r)||(l>=s.length())||(r<0))
                break;
            if (s.charAt(l)==s.charAt(r)||(Math.abs(s.charAt(l)-s.charAt(r))==32&&
                    (s.charAt(l)>57)&&(s.charAt(r)>57))){
                l++;
                r--;
            }else {
                res=false;
                break;
            }
        }
        return res;
    }
}
