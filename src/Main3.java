import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by SunLin on 2018.3.22
 */
public class Main3 {
    public static void main(String[] args){
        String s = new Scanner(System.in).nextLine().trim();
        Map<Character,Integer> m = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if (m.containsKey(s.charAt(i))){
                m.put(s.charAt(i),m.get(s.charAt(i))+1);
            }else {
                m.put(s.charAt(i),1);
            }
        }
        int a,b;
        a=1;
        b = m.getOrDefault('1', 0);
        for(int i=1;i<10;i++){
            if(m.getOrDefault('0'+i,0)<b){
                b=m.getOrDefault('0'+i,0);
                a=i;
            }
        }
        if(m.getOrDefault('0',0)<b){
            b=m.getOrDefault('0',0);
            a=0;
        }
        String res = "";
        for(int i=0;i<b+1;i++)
            res+=(char)('0'+a);
        if(a==0)res="1"+res;
        System.out.println(res);
    }
}
