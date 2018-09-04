package pastExamPaper.pinduoduo;

import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        char[][] chars = new char[N][M];
        for(int i=0;i<N;i++){
            String s = sc.nextLine().trim();
            for (int j =0;j<s.length();j++){
                chars[i][j] = s.charAt(j);
            }
        }
        for (int i=0;i<M;i++){
            int flag = N;
            for (int j=N-1;j>=0;j--){
                if (chars[j][i]=='o'){
                    if (flag==N){
                        chars[j][i]='.';
                    }else {
                        chars[j][i]='.';
                        chars[flag-1][i]='o';
                        flag--;
                    }
                    continue;
                }
                if (chars[j][i]=='x'){
                    flag=j;
                }
            }
        }
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }
}
