package leetcode;import java.util.HashSet;
import java.util.Set;

/**
 * Created by SUN on 2017.11.16.
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Q003_LongestSWRC {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.equals(""))
            return 0;
        int maxnum=1,cur=1;
        int p=0,q=1;
        Set<Character> set = new HashSet();
        set.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                while (s.charAt(p)!=s.charAt(i)&&p<q){
                    set.remove(s.charAt(p));
                    p++;
                }
                p++;
                q=i;
            }
            else {
                set.add(s.charAt(i));
                q=i;
                cur=q-p+1;
                if(cur>maxnum)
                    maxnum=cur;
            }
        }
        return maxnum;
    }
    //官方解法
    public class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            int[] index = new int[128]; // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                i = Math.max(index[s.charAt(j)], i);
                ans = Math.max(ans, j - i + 1);
                index[s.charAt(j)] = j + 1;
            }
            return ans;
        }
    }
}
