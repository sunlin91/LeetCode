package pastExamPaper.pinduoduo;

import java.util.HashSet;
import java.util.Scanner;

public class test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        HashSet<String> set = new HashSet<>();
        char[][] chars = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine().trim();
            set.add(s);
            for (int j = 0; j < M; j++) {
                chars[i][j] = s.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            char minChar = chars[0][i];
            for (int j = 0; j < N; j++) {
                if (chars[j][i] < minChar) {
                    minChar = chars[j][i];
                }
            }
            sb.append(minChar);
        }
        if (set.contains(sb.toString())) {
            System.out.println("-");
        } else
            System.out.println(sb.toString());
    }
}
