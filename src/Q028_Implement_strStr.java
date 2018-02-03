/**
 * Created by SUN on 2017.12.19.
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class Q028_Implement_strStr {
    //elegant
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

//    public int strStr(String haystack, String needle) {
//        if(haystack==null||needle==null)
//            return -1;
//        if(haystack.equals("")&&needle.equals(""))
//            return 0;
//        int result=-1;
//        boolean flag=true;
//        for(int i=0;i<haystack.length();i++){
//            int pos=i,start=i;
//            for(int j=0;j<needle.length();j++){
//                if(pos>=haystack.length())
//                    return -1;
//                if(haystack.charAt(pos)==needle.charAt(j)){
//                    pos++;flag=true;continue;
//                }else {
//                    flag=false;
//                    break;
//                }
//            }
//            if(flag){
//                return start;
//            }
//        }
//        return result;
//    }
}
