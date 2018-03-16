package leetcode;

import java.util.*;

/**
 * Created by SunLin on 2018.3.16
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * <p>
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class Q071_SimplifyPath {
    public static void main(String[] a){
        Q071_SimplifyPath q = new Q071_SimplifyPath();
        System.out.println(q.simplifyPath("/a/./b/../../c/"));
    }
    public String simplifyPath(String path) {
        if (path==null||path.length()==0)
            return "/";
        List<String> list = new LinkedList<>();
        String[] file = path.replace("//","/").split("/");
        for(int i=0;i<file.length;i++){
            if (file[i].equals(".")||file[i].equals(""))
                continue;
            if (file[i].equals("..")){
                if (!list.isEmpty())
                    list.remove(list.size()-1);
            }
            else {
                list.add(file[i]);
            }
        }
        StringBuilder res = new StringBuilder("/");
        for (int i=0;i<list.size();i++){
            res.append(list.get(i));
            if (i!=list.size()-1)
                res.append("/");
        }
        return res.toString();
    }
}
