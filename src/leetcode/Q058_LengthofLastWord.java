package leetcode;

/**
 * Created by SunLin on 2018.3.16
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 */
public class Q058_LengthofLastWord {
    public static void main(String[] a){
        Q058_LengthofLastWord q = new Q058_LengthofLastWord();
        System.out.print(q.lengthOfLastWord("a"));
    }
    public int lengthOfLastWord(String s) {
        if (s==null||s.length()==0)
            return 0;
        String[] words = s.split(" ");
        for (int i=words.length-1;i>=0;i--){
            if (isWord(words[i])){
                return words[i].length();
            }
        }
        return 0;
    }
    boolean isWord(String s){
        for (int i=0;i<s.length();i++){
            if ((s.charAt(i)>='a'&&s.charAt(i)<='z')||
                    s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
