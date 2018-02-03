/**
 * Created by SUN on 2017.11.21.
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */
public class Q005_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s==null||s.equals("")||s.length()==0)
            return "";
        String result = "";
        int maxLength=0;
        for(int i=0;i<s.length();i++){
            int j=0;
            while ((i-j)>=0&&(i+j)<s.length()){
                if(s.charAt(i-j)!=s.charAt(i+j))
                    break;
                if(2*j+1>maxLength){
                    result=s.substring(i-j,i+j+1);
                    maxLength=2*j+1;
                }
                j++;
            }
            j=0;
            while ((i-j)>=0&&(i+j+1)<s.length()){
                if(s.charAt(i-j)!=s.charAt(i+1+j))
                    break;
                if(2*j+2>maxLength){
                    result=s.substring(i-j,i+j+2);
                    maxLength=2*j+2;
                }
                j++;
            }
        }

        return result;
    }
}
