import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by SunLin on 2018.3.22
 */
public class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        Map<Character,Integer> m = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            if (m.containsKey(s.charAt(i)))
                m.put(s.charAt(i),m.get(s.charAt(i))+1);
            else
                m.put(s.charAt(i),1);
        }
        int a=1,b=m.get('1');
        for (int i=1;i<10;i++){
            if (m.get('0'+i)<b){
                b=m.get('0'+i);
                a=i;
            }
        }
        if (m.get('0')<b){
            b=m.get('0');
            a=0;
        }
        String res="";
        for (int i=0;i<b+1;i++)
            res+=('0'+a);
        if (a==0)
            res="1"+res;
        System.out.println(res);
    }
}
