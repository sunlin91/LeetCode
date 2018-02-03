import java.util.*;

/**
 * Created by SUN on 2017.12.19.
 * You are given a string, s, and a list of words, words,
 * that are all of the same length. Find all starting indices of substring(s)
 * in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class U_Q030_SubstringwithConcatenationofAllWords {
    //fast
    public List<Integer> findSubstring(String s, String[] words) {
        int N = s.length();
        List<Integer> indexes = new ArrayList<Integer>(s.length());
        if (words.length == 0) {
            return indexes;
        }
        int M = words[0].length();
        if (N < M * words.length) {
            return indexes;
        }
        int last = N - M + 1;

        //map each string in words array to some index and compute target counters
        Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
        int [][] table = new int[2][words.length];
        int failures = 0, index = 0;
        for (int i = 0; i < words.length; ++i) {
            Integer mapped = mapping.get(words[i]);
            if (mapped == null) {
                ++failures;
                mapping.put(words[i], index);
                mapped = index++;
            }
            ++table[0][mapped];
        }

        //find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
        int [] smapping = new int[last];
        for (int i = 0; i < last; ++i) {
            String section = s.substring(i, i + M);
            Integer mapped = mapping.get(section);
            if (mapped == null) {
                smapping[i] = -1;
            } else {
                smapping[i] = mapped;
            }
        }

        //fix the number of linear scans
        for (int i = 0; i < M; ++i) {
            //reset scan variables
            int currentFailures = failures; //number of current mismatches
            int left = i, right = i;
            Arrays.fill(table[1], 0);
            //here, simple solve the minimum-window-substring problem
            while (right < last) {
                while (currentFailures > 0 && right < last) {
                    int target = smapping[right];
                    if (target != -1 && ++table[1][target] == table[0][target]) {
                        --currentFailures;
                    }
                    right += M;
                }
                while (currentFailures == 0 && left < right) {
                    int target = smapping[left];
                    if (target != -1 && --table[1][target] == table[0][target] - 1) {
                        int length = right - left;
                        //instead of checking every window, we know exactly the length we want
                        if ((length / M) ==  words.length) {
                            indexes.add(left);
                        }
                        ++currentFailures;
                    }
                    left += M;
                }
            }

        }
        return indexes;
    }


    //a solution with map,no fast
//    public List<Integer> findSubstring(String s, String[] words) {
//        final Map<String, Integer> counts = new HashMap<>();
//        for (final String word : words) {
//            counts.put(word, counts.getOrDefault(word, 0) + 1);
//        }
//        final List<Integer> indexes = new ArrayList<>();
//        final int n = s.length(), num = words.length, len = words[0].length();
//        for (int i = 0; i < n - num * len + 1; i++) {
//            final Map<String, Integer> seen = new HashMap<>();
//            int j = 0;
//            while (j < num) {
//                final String word = s.substring(i + j * len, i + (j + 1) * len);
//                if (counts.containsKey(word)) {
//                    seen.put(word, seen.getOrDefault(word, 0) + 1);
//                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
//                        break;
//                    }
//                } else {
//                    break;
//                }
//                j++;
//            }
//            if (j == num) {
//                indexes.add(i);
//            }
//        }
//        return indexes;
//    }

    //time limit
//    public List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> result = new ArrayList<>();
//        if (s==null||words==null)
//            return result;
//        int len = words[0].length();
//        Map<String,Integer> map = new HashMap<>();
//        Map<String,Integer> cur = new HashMap<>();
//        for(String str:words){
//            if(map.containsKey(str)){
//                map.put(str,map.get(str)+1);
//            }
//            else {
//                map.put(str,1);
//            }
//        }
//        for(int i=0;i<s.length();i++){
//            cur.clear();
//            cur.putAll(map);
//            int pos=i;
//            boolean flag=true;
//            for(int j=0;j<words.length&&pos+len<=s.length();j++){
//                String str = s.substring(pos,pos+len);
//                if(cur.containsKey(str)&&cur.get(str)>0){
//                    cur.put(str,cur.get(str)-1);
//                    pos+=len;
//                }
//                else {
//                    flag=false;
//                    break;
//                }
//            }
//            if(flag&&(pos-i)/len==words.length){
//                result.add(i);
//            }
//        }
//        return result;
//    }
}
