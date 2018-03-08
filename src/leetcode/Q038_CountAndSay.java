package leetcode;

/**
 * SUN 2018.2.3
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * Note: Each term of the sequence of integers will be represented as a string.
 * Example 1:
 * Input: 1
 * Output: "1"
 * Example 2:
 * Input: 4
 * Output: "1211"
 */
public class Q038_CountAndSay {
    public String countAndSay(int n) {
        if(n<=0)
            return null;

        String pre="1";
        StringBuilder result=new StringBuilder();

        for(int i=1;i<n;i++){
            int num=0;
            char a=pre.charAt(0);
            for(int j=0;j<pre.length();j++){
                if(num==0){
                    a=pre.charAt(j);
                    num++;
                    continue;
                }
                if(pre.charAt(j)==a){
                    num++;
                }else {
                    result.append(num+"");
                    result.append(a);
                    a=pre.charAt(j);
                    num=1;
                }
            }
            result.append(num+"");
            result.append(a);
            pre=result.toString();
            result.delete(0,result.length());
        }
        return pre;
    }
}
