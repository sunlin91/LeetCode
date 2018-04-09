package pastExamPaper.jingdong;

import java.util.Scanner;
import java.util.Stack;

public class jingdong2018test03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Character> stack = new Stack<>();

        int count;
        for (int i=0;i<n;i++){
            stack.clear();
            count=0;
            String str = sc.next().trim();
            if (str.length()==0){
                System.out.println("No");
                continue;
            }
            for (int j=0;j<str.length();j++){
                char c = str.charAt(j);
                if (c=='('){
                    stack.push(c);
                }else if (c==')'){
                    if (stack.isEmpty()){
                        count++;
                    }else if (stack.peek()=='('){
                        stack.pop();
                    }else{
                        count++;
                    }
                }
            }
            if (count==1&&str.length()%2==0){
                System.out.println("Yes");
            }else if(count==0&&stack.isEmpty()&& str.length()>=4){
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }
}