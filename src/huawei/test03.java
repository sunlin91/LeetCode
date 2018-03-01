package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by SUN on 2018.3.1.
 */
public class test03 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        while (input.hasNext()){
            String str = input.next().substring(2);
            int result = 0;
            if(str.charAt(0)>='0'&&str.charAt(0)<='9'){
                result=str.charAt(0)-'0';
            }else {
                result=str.charAt(0)-'A'+10;
            }
            for(int i=1;i<str.length();i++){
                if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                    result=result*16+(str.charAt(i)-'0');
                }else {
                    result=result*16+(str.charAt(i)-'A'+10);
                }
            }
            list.add(result);
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
