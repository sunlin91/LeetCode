package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SunLin on 2018.3.19
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * For example:
 * Given "25525511135",
 * <p>
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Q093_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j,k);
                    String s4 = s.substring(k,len);
                    if(isIP(s1) && isIP(s2) && isIP(s3) && isIP(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }

    boolean isIP(String s){
        if (s.length()>3||s.length()==0||(s.charAt(0)=='0'&&s.length()>1)||(Integer.parseInt(s)>255))
            return false;
        return true;
    }

}
