package leetcode;

import java.util.*;

/**
 * Created by SUN on 2018.2.27.
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 */
public class Q049_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return null;
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List> map = new HashMap<>();
        for (String str : strs) {
            char[] strToChars = str.toCharArray();
            Arrays.sort(strToChars);
            String key = String.valueOf(strToChars);
            if(map.containsKey(key.toString())){
                map.get(key.toString()).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key.toString(),list);
            }
        }
        for(String s:map.keySet()){
            result.add(map.get(s));
        }
        return result;
    }
}
